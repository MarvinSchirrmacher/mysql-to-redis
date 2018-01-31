package de.fh_bielefeld.compiler_construction;

import de.fh_bielefeld.compiler_construction.parser.MySqlLexer;
import de.fh_bielefeld.compiler_construction.parser.MySqlParser;
import de.fh_bielefeld.compiler_construction.parser.MySqlParserBaseListener;

import javax.json.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MySqlParserRedisListener extends MySqlParserBaseListener {
    private enum Action { GET, SET }

    private JsonObjectBuilder responseBuilder;
    private JsonObjectBuilder setBuilder;
    private JsonObjectBuilder getBuilder;

    private JsonArrayBuilder itemsToSetBuilder;
    private JsonObjectBuilder itemToSetBuilder;

    private String itemsContext = null;
    private List<String> itemKeys = new ArrayList<>();
    private int itemKeyIndex = 0;

    private Action currentAction;

    public JsonObject getRequest() {
        return responseBuilder.build();
    }

    public void enterSql(MySqlParser.SqlContext ctx) {
        responseBuilder = Json.createObjectBuilder();
        this.setBuilder = Json.createObjectBuilder();
        this.getBuilder = Json.createObjectBuilder();
    }

    public void exitSql(MySqlParser.SqlContext ctx) {
        this.responseBuilder.add("get", this.getBuilder.build());
        this.responseBuilder.add("set", this.setBuilder.build());
    }

    public void enterInsert(MySqlParser.InsertContext ctx) {
        this.currentAction = Action.SET;
        this.itemsToSetBuilder = Json.createArrayBuilder();
        this.itemsContext = ctx.table.getText();
        this.itemKeys.clear();
        ctx.columns.id().forEach(i -> this.itemKeys.add(i.start.getText()));
    }

    public void exitInsert(MySqlParser.InsertContext ctx) {
        this.setBuilder.add(this.itemsContext, this.itemsToSetBuilder.build());
    }

    /**
     * Checks whether the insert format is "VALUES" and not "VALUE" as only the
     * former is supported by this adapter.
     * @param ctx The insert value context.
     */
    public void enterInsertValue(MySqlParser.InsertValueContext ctx) {
        assert ctx.insertFormat.getType() == MySqlLexer.VALUES;
    }

    public void enterExpressionsOrDefaults(MySqlParser.ExpressionsOrDefaultsContext ctx) {
        switch (this.currentAction) {
            case GET:
                break;
            case SET:
                this.itemToSetBuilder = Json.createObjectBuilder();
                break;
        }
    }

    public void exitExpressionsOrDefaults(MySqlParser.ExpressionsOrDefaultsContext ctx) {
        switch (this.currentAction) {
            case GET:
                break;
            case SET:
                this.itemsToSetBuilder.add(this.itemToSetBuilder.build());
                this.itemKeyIndex = 0;
                break;
        }
    }

    public void enterConstant(MySqlParser.ConstantContext ctx) {
        int constantType = ctx.start.getType();
        int itemKey = this.itemKeyIndex++;

        switch (constantType) {
            case MySqlParser.NULL_LITERAL:
                this.itemToSetBuilder.add(
                        this.itemKeys.get(itemKey), JsonValue.NULL);
                break;
            case MySqlParser.DECIMAL_LITERAL:
                int decimalValue = Integer.parseInt(ctx.start.getText());
                this.itemToSetBuilder.add(
                        this.itemKeys.get(itemKey), decimalValue);
                break;
            case MySqlParser.STRING_LITERAL:
            default:
                String value = ctx.start.getText();
                if (value.startsWith("'")) {
                    value = value.substring(1, value.length() - 1);
                }
                this.itemToSetBuilder.add(
                        this.itemKeys.get(itemKey), value);
                break;
        }
    }
}
