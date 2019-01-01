package basic2java;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Translator1 {
    public static void main(String[] args) throws Exception {

        String src = Utils.readFile(Translator1.class.getClassLoader().getResource("test1.bas").getFile());

        CharStream is = CharStreams.fromString(src);
        BasicLexer lexer = new BasicLexer(is);
        BasicParser parser = new BasicParser(new CommonTokenStream(lexer));
        parser.setBuildParseTree(true);

        ParserRuleContext tree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();

        MyBasicListener listener = new MyBasicListener("Test1", parser);
        walker.walk(listener, tree);

        System.out.println(listener.getGeneratedCode());
    }
}
