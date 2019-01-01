package basic2java;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class PrintAST3 {
    public static void main(String[] args) throws Exception {
        String src = "10 PRINT \"Hello, World!\"\n" +
                "20 END";

        CharStream is = CharStreams.fromString(src);
        BasicLexer lexer = new BasicLexer(is);
        BasicParser parser = new BasicParser(new CommonTokenStream(lexer));
        parser.setBuildParseTree(true);

        ParserRuleContext tree = parser.prog();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new MyListener(), tree);
    }
}

class MyListener extends BasicBaseListener {
    @Override
    public void enterProg(BasicParser.ProgContext ctx) {
        System.out.println("====== STARTING PROGRAM ======");
    }

    @Override
    public void exitProg(BasicParser.ProgContext ctx) {
        System.out.println("====== ENDING PROGRAM ======");
    }

    @Override
    public void enterLine(BasicParser.LineContext ctx) {
        System.out.println("Line # : " + ctx.linenumber().getText() + " " + ctx.getText());
    }

    @Override
    public void exitLine(BasicParser.LineContext ctx) {

    }
}