package basic2java;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;


public class PrintAST1 {
    public static void main(String[] args) throws Exception {
        String src = "10 PRINT \"Hello, World!\"\n" +
                "20 END";

        CharStream is = CharStreams.fromString(src);
        BasicLexer lexer = new BasicLexer(is);
        BasicParser parser = new BasicParser(new CommonTokenStream(lexer));
        parser.setBuildParseTree(true);

        ParserRuleContext tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }
}

