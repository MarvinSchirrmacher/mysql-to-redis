package de.fh_bielefeld.compiler_construction;

import de.fh_bielefeld.compiler_construction.parser.MySqlLexer;
import de.fh_bielefeld.compiler_construction.parser.MySqlParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.json.JsonObject;
import java.io.IOException;

/**
 * Sql analyzer to create a generic request object.
 */
public class MySqlAnalyzer {
    private ParseTreeWalker walker;
    private MySqlParserRedisListener listener;

    /**
     * Initializes a parse tree walker and a listener.
     */
    MySqlAnalyzer() {
        this.walker = new ParseTreeWalker();
        this.listener = new MySqlParserRedisListener();
    }

    /**
     * Parses the sql file with via a mysql parser listener and collects
     * all set and get requests.
     * @param inputFilePath The file path to the sql file to parse.
     * @return A generic requests object.
     * @throws IOException
     */
    public JsonObject process(String inputFilePath) throws IOException {
        CharStream inputStream = CharStreams.fromFileName(inputFilePath);
        MySqlLexer lexer = new MySqlLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MySqlParser parser = new MySqlParser(tokens);
        ParseTree tree = parser.sql();

        this.walker.walk(this.listener, tree);
        return this.listener.getRequest();
    }
}
