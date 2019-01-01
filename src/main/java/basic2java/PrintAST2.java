package basic2java;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.*;

import java.util.Arrays;
import java.util.List;

public class PrintAST2 {
    public static void main(String[] args) {
        String src = "10 PRINT \"Hello, World!\"\n" +
                "20 END";

        CharStream is = CharStreams.fromString(src);
        BasicLexer lexer = new BasicLexer(is);
        BasicParser parser = new BasicParser(new CommonTokenStream(lexer));

        List<String> ruleNames = Arrays.asList(parser.getRuleNames());
        TreePrinterListener listener = new TreePrinterListener(ruleNames);
        parser.setBuildParseTree(true);
        ParserRuleContext tree = parser.prog();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
        String formatted = listener.toString();

        System.out.println(formatted);
    }
}


class TreePrinterListener implements ParseTreeListener {
    private final List<String> ruleNames;
    private final StringBuilder builder = new StringBuilder();

    public TreePrinterListener(Parser parser) {
        this.ruleNames = Arrays.asList(parser.getRuleNames());
    }

    public TreePrinterListener(List<String> ruleNames) {
        this.ruleNames = ruleNames;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        if (builder.length() > 0) {
            builder.append(' ');
        }

        builder.append(Utils.escapeWhitespace(Trees.getNodeText(node, ruleNames), false));
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        if (builder.length() > 0) {
            builder.append(' ');
        }

        builder.append(Utils.escapeWhitespace(Trees.getNodeText(node, ruleNames), false));
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if (builder.length() > 0) {
            builder.append(' ');
        }

        if (ctx.getChildCount() > 0) {
            builder.append('(');
        }

        int ruleIndex = ctx.getRuleIndex();
        String ruleName;
        if (ruleIndex >= 0 && ruleIndex < ruleNames.size()) {
            ruleName = ruleNames.get(ruleIndex);
        }
        else {
            ruleName = Integer.toString(ruleIndex);
        }

        builder.append(ruleName);
    }

    /*
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (ctx.getChildCount() > 0) {
            builder.append(')');
        }
    }
    */

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (ctx.getChildCount() > 0) {
            Token positionToken = ctx.getStart();
            if (positionToken != null) {
                builder.append(" [line ");
                builder.append(positionToken.getLine());
                builder.append(", offset ");
                builder.append(positionToken.getStartIndex());
                builder.append(':');
                builder.append(positionToken.getStopIndex());
                builder.append("])");
            }
            else {
                builder.append(')');
            }
        }
    }


    @Override
    public String toString() {
        return builder.toString();
    }
}