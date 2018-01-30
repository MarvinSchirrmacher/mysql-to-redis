package de.fh_bielefeld.compiler_construction;

import de.fh_bielefeld.compiler_construction.parser.MySqlLexer;
import de.fh_bielefeld.compiler_construction.parser.MySqlParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class MySqlToRedisConverter {
    public void convert(String inputFilePath) throws IOException {
        CharStream inputStream = CharStreams.fromFileName(inputFilePath);
        MySqlLexer lexer = new MySqlLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MySqlParser parser = new MySqlParser(tokens);
        ParseTree tree = parser.sql();
        ParseTreeWalker walker = new ParseTreeWalker();
        MySqlParserRedisListener listener = new MySqlParserRedisListener();
        walker.walk(listener, tree);
    }
}
