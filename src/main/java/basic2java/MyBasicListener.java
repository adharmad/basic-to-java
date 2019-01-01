package basic2java;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class MyBasicListener extends BasicBaseListener {
    public static final String[] TABS = {
            "",
            "\t",
            "\t\t",
            "\t\t\t",
            "\t\t\t\t",
            "\t\t\t\t\t",
            "\t\t\t\t\t\t",
            "\t\t\t\t\t\t\t",
            "\t\t\t\t\t\t\t\t",
            "\t\t\t\t\t\t\t\t\t",
            "\t\t\t\t\t\t\t\t\t\t",
            "\t\t\t\t\t\t\t\t\t\t\t",
            "\t\t\t\t\t\t\t\t\t\t\t\t"
    };

    private BasicParser parser;
    private String progName;
    private StringBuffer sbuf;
    private int level;
    private boolean scannerGenerated = false;

    public MyBasicListener(String progName, BasicParser parser) {
        this.progName = progName;
        this.parser = parser;
        sbuf = new StringBuffer();
        level = 0;
    }

    public String getGeneratedCode() {
        return sbuf.toString();
    }

    @Override
    public void enterProg(BasicParser.ProgContext ctx) {
        // static imports
        sbuf.append(TABS[level] + "import java.io.*;\n");
        sbuf.append(TABS[level] + "import java.util.*;\n");
        sbuf.append(TABS[level] + "\n");


        sbuf.append(TABS[level] + "public class " + progName + " {\n");
        level++;

        sbuf.append(TABS[level] + "public static void main(String[] args) {\n");
        level++;

        //super.enterProg(ctx);
    }

    @Override
    public void exitProg(BasicParser.ProgContext ctx) {
        level--;
        sbuf.append(TABS[level] + "}\n");

        level--;
        sbuf.append(TABS[level] + "}\n");
        //super.exitProg(ctx);
    }

    @Override
    public void enterLine(BasicParser.LineContext ctx) {
        super.enterLine(ctx);
    }

    @Override
    public void exitLine(BasicParser.LineContext ctx) {
        super.exitLine(ctx);
    }

    @Override
    public void enterAmperoper(BasicParser.AmperoperContext ctx) {
        super.enterAmperoper(ctx);
    }

    @Override
    public void exitAmperoper(BasicParser.AmperoperContext ctx) {
        super.exitAmperoper(ctx);
    }

    @Override
    public void enterLinenumber(BasicParser.LinenumberContext ctx) {
        super.enterLinenumber(ctx);
    }

    @Override
    public void exitLinenumber(BasicParser.LinenumberContext ctx) {
        super.exitLinenumber(ctx);
    }

    @Override
    public void enterAmprstmt(BasicParser.AmprstmtContext ctx) {
        super.enterAmprstmt(ctx);
    }

    @Override
    public void exitAmprstmt(BasicParser.AmprstmtContext ctx) {
        super.exitAmprstmt(ctx);
    }

    @Override
    public void enterStatement(BasicParser.StatementContext ctx) {
        super.enterStatement(ctx);
    }

    @Override
    public void exitStatement(BasicParser.StatementContext ctx) {
        super.exitStatement(ctx);
    }

    @Override
    public void enterVardecl(BasicParser.VardeclContext ctx) {
        super.enterVardecl(ctx);
    }

    @Override
    public void exitVardecl(BasicParser.VardeclContext ctx) {
        super.exitVardecl(ctx);
    }

    @Override
    public void enterPrintstmt1(BasicParser.Printstmt1Context ctx) {
        sbuf.append(TABS[level] + "System.out.println(");

        //super.enterPrintstmt1(ctx);
    }

    @Override
    public void exitPrintstmt1(BasicParser.Printstmt1Context ctx) {
        sbuf.append(");\n");

        //super.exitPrintstmt1(ctx);
    }

    @Override
    public void enterPrintlist(BasicParser.PrintlistContext ctx) {
        String txt = "";

        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree node = ctx.getChild(i);
            if (node.getText().equals(";")) {
                txt += " + ";
            } else if (node.getText().endsWith("$")){
                txt += node.getText().substring(0, node.getText().length()-1);
            } else {
                txt += node.getText();
            }
        }

        sbuf.append(txt);
        //super.enterPrintlist(ctx);
    }

    @Override
    public void exitPrintlist(BasicParser.PrintlistContext ctx) {
        //super.exitPrintlist(ctx);
    }

    @Override
    public void enterGetstmt(BasicParser.GetstmtContext ctx) {
        super.enterGetstmt(ctx);
    }

    @Override
    public void exitGetstmt(BasicParser.GetstmtContext ctx) {
        super.exitGetstmt(ctx);
    }

    @Override
    public void enterLetstmt(BasicParser.LetstmtContext ctx) {
        super.enterLetstmt(ctx);
    }

    @Override
    public void exitLetstmt(BasicParser.LetstmtContext ctx) {
        super.exitLetstmt(ctx);
    }

    @Override
    public void enterVariableassignment(BasicParser.VariableassignmentContext ctx) {
        TokenStream tokens = parser.getTokenStream();
        String varName = tokens.getText(ctx.vardecl());
        String varValue = tokens.getText(ctx.exprlist());

        if (varName.endsWith("$")) {
            sbuf.append(TABS[level] + "String ");
        }
        sbuf.append(varName.substring(0, varName.length()-1) + " = " + varValue + ";\n");

        //super.enterVariableassignment(ctx);
    }

    @Override
    public void exitVariableassignment(BasicParser.VariableassignmentContext ctx) {

        //super.exitVariableassignment(ctx);
    }

    @Override
    public void enterRelop(BasicParser.RelopContext ctx) {
        super.enterRelop(ctx);
    }

    @Override
    public void exitRelop(BasicParser.RelopContext ctx) {
        super.exitRelop(ctx);
    }

    @Override
    public void enterNeq(BasicParser.NeqContext ctx) {
        super.enterNeq(ctx);
    }

    @Override
    public void exitNeq(BasicParser.NeqContext ctx) {
        super.exitNeq(ctx);
    }

    @Override
    public void enterIfstmt(BasicParser.IfstmtContext ctx) {
        super.enterIfstmt(ctx);
    }

    @Override
    public void exitIfstmt(BasicParser.IfstmtContext ctx) {
        super.exitIfstmt(ctx);
    }

    @Override
    public void enterForstmt1(BasicParser.Forstmt1Context ctx) {
        super.enterForstmt1(ctx);
    }

    @Override
    public void exitForstmt1(BasicParser.Forstmt1Context ctx) {
        super.exitForstmt1(ctx);
    }

    @Override
    public void enterForstmt2(BasicParser.Forstmt2Context ctx) {
        super.enterForstmt2(ctx);
    }

    @Override
    public void exitForstmt2(BasicParser.Forstmt2Context ctx) {
        super.exitForstmt2(ctx);
    }

    @Override
    public void enterNextstmt(BasicParser.NextstmtContext ctx) {
        super.enterNextstmt(ctx);
    }

    @Override
    public void exitNextstmt(BasicParser.NextstmtContext ctx) {
        super.exitNextstmt(ctx);
    }

    @Override
    public void enterInputstmt(BasicParser.InputstmtContext ctx) {
        if (!scannerGenerated) {
            sbuf.append(TABS[level] + "Scanner in = new Scanner(System.in);\n");
            scannerGenerated = true;
        }

        String varName = "";
        String varType = "";
        String txt = "";

        for (int i = 0; i < ctx.getChildCount(); i++) {

            ParseTree node = ctx.getChild(i);

            if (node.getText().equals("INPUT") || node.getText().equals(";") || node.getText().equals(",")) {
                // consume
            } else if (node instanceof BasicParser.VarlistContext){
                if (node.getText().endsWith("$")) {
                    varType = "String";
                    varName = node.getText().substring(0, node.getText().length()-1);
                } else {
                    varType = "int";
                    varName = node.getText();
                }

            } else {
                txt = node.getText();
            }

        }

        sbuf.append(TABS[level] + "System.out.print(" + txt + " );\n");
        sbuf.append(TABS[level] + varType + " " + varName + " = in.");
        if (varType.equals("String")) {
            sbuf.append("nextLine();\n");
        } else if (varType.equals("int")) {
            sbuf.append("nextInt();\n");
        }

        //super.enterInputstmt(ctx);
    }

    @Override
    public void exitInputstmt(BasicParser.InputstmtContext ctx) {

        //super.exitInputstmt(ctx);
    }

    @Override
    public void enterReadstmt(BasicParser.ReadstmtContext ctx) {
        super.enterReadstmt(ctx);
    }

    @Override
    public void exitReadstmt(BasicParser.ReadstmtContext ctx) {
        super.exitReadstmt(ctx);
    }

    @Override
    public void enterDimstmt(BasicParser.DimstmtContext ctx) {
        super.enterDimstmt(ctx);
    }

    @Override
    public void exitDimstmt(BasicParser.DimstmtContext ctx) {
        super.exitDimstmt(ctx);
    }

    @Override
    public void enterGotostmt(BasicParser.GotostmtContext ctx) {
        super.enterGotostmt(ctx);
    }

    @Override
    public void exitGotostmt(BasicParser.GotostmtContext ctx) {
        super.exitGotostmt(ctx);
    }

    @Override
    public void enterGosubstmt(BasicParser.GosubstmtContext ctx) {
        super.enterGosubstmt(ctx);
    }

    @Override
    public void exitGosubstmt(BasicParser.GosubstmtContext ctx) {
        super.exitGosubstmt(ctx);
    }

    @Override
    public void enterPokestmt(BasicParser.PokestmtContext ctx) {
        super.enterPokestmt(ctx);
    }

    @Override
    public void exitPokestmt(BasicParser.PokestmtContext ctx) {
        super.exitPokestmt(ctx);
    }

    @Override
    public void enterCallstmt(BasicParser.CallstmtContext ctx) {
        super.enterCallstmt(ctx);
    }

    @Override
    public void exitCallstmt(BasicParser.CallstmtContext ctx) {
        super.exitCallstmt(ctx);
    }

    @Override
    public void enterHplotstmt(BasicParser.HplotstmtContext ctx) {
        super.enterHplotstmt(ctx);
    }

    @Override
    public void exitHplotstmt(BasicParser.HplotstmtContext ctx) {
        super.exitHplotstmt(ctx);
    }

    @Override
    public void enterVplotstmt(BasicParser.VplotstmtContext ctx) {
        super.enterVplotstmt(ctx);
    }

    @Override
    public void exitVplotstmt(BasicParser.VplotstmtContext ctx) {
        super.exitVplotstmt(ctx);
    }

    @Override
    public void enterPlotstmt(BasicParser.PlotstmtContext ctx) {
        super.enterPlotstmt(ctx);
    }

    @Override
    public void exitPlotstmt(BasicParser.PlotstmtContext ctx) {
        super.exitPlotstmt(ctx);
    }

    @Override
    public void enterOngotostmt(BasicParser.OngotostmtContext ctx) {
        super.enterOngotostmt(ctx);
    }

    @Override
    public void exitOngotostmt(BasicParser.OngotostmtContext ctx) {
        super.exitOngotostmt(ctx);
    }

    @Override
    public void enterOngosubstmt(BasicParser.OngosubstmtContext ctx) {
        super.enterOngosubstmt(ctx);
    }

    @Override
    public void exitOngosubstmt(BasicParser.OngosubstmtContext ctx) {
        super.exitOngosubstmt(ctx);
    }

    @Override
    public void enterVtabstmnt(BasicParser.VtabstmntContext ctx) {
        super.enterVtabstmnt(ctx);
    }

    @Override
    public void exitVtabstmnt(BasicParser.VtabstmntContext ctx) {
        super.exitVtabstmnt(ctx);
    }

    @Override
    public void enterHtabstmnt(BasicParser.HtabstmntContext ctx) {
        super.enterHtabstmnt(ctx);
    }

    @Override
    public void exitHtabstmnt(BasicParser.HtabstmntContext ctx) {
        super.exitHtabstmnt(ctx);
    }

    @Override
    public void enterHimemstmt(BasicParser.HimemstmtContext ctx) {
        super.enterHimemstmt(ctx);
    }

    @Override
    public void exitHimemstmt(BasicParser.HimemstmtContext ctx) {
        super.exitHimemstmt(ctx);
    }

    @Override
    public void enterLomemstmt(BasicParser.LomemstmtContext ctx) {
        super.enterLomemstmt(ctx);
    }

    @Override
    public void exitLomemstmt(BasicParser.LomemstmtContext ctx) {
        super.exitLomemstmt(ctx);
    }

    @Override
    public void enterDatastmt(BasicParser.DatastmtContext ctx) {
        super.enterDatastmt(ctx);
    }

    @Override
    public void exitDatastmt(BasicParser.DatastmtContext ctx) {
        super.exitDatastmt(ctx);
    }

    @Override
    public void enterDatum(BasicParser.DatumContext ctx) {
        super.enterDatum(ctx);
    }

    @Override
    public void exitDatum(BasicParser.DatumContext ctx) {
        super.exitDatum(ctx);
    }

    @Override
    public void enterWaitstmt(BasicParser.WaitstmtContext ctx) {
        super.enterWaitstmt(ctx);
    }

    @Override
    public void exitWaitstmt(BasicParser.WaitstmtContext ctx) {
        super.exitWaitstmt(ctx);
    }

    @Override
    public void enterXdrawstmt(BasicParser.XdrawstmtContext ctx) {
        super.enterXdrawstmt(ctx);
    }

    @Override
    public void exitXdrawstmt(BasicParser.XdrawstmtContext ctx) {
        super.exitXdrawstmt(ctx);
    }

    @Override
    public void enterDrawstmt(BasicParser.DrawstmtContext ctx) {
        super.enterDrawstmt(ctx);
    }

    @Override
    public void exitDrawstmt(BasicParser.DrawstmtContext ctx) {
        super.exitDrawstmt(ctx);
    }

    @Override
    public void enterDefstmt(BasicParser.DefstmtContext ctx) {
        super.enterDefstmt(ctx);
    }

    @Override
    public void exitDefstmt(BasicParser.DefstmtContext ctx) {
        super.exitDefstmt(ctx);
    }

    @Override
    public void enterTabstmt(BasicParser.TabstmtContext ctx) {
        super.enterTabstmt(ctx);
    }

    @Override
    public void exitTabstmt(BasicParser.TabstmtContext ctx) {
        super.exitTabstmt(ctx);
    }

    @Override
    public void enterSpeedstmt(BasicParser.SpeedstmtContext ctx) {
        super.enterSpeedstmt(ctx);
    }

    @Override
    public void exitSpeedstmt(BasicParser.SpeedstmtContext ctx) {
        super.exitSpeedstmt(ctx);
    }

    @Override
    public void enterRotstmt(BasicParser.RotstmtContext ctx) {
        super.enterRotstmt(ctx);
    }

    @Override
    public void exitRotstmt(BasicParser.RotstmtContext ctx) {
        super.exitRotstmt(ctx);
    }

    @Override
    public void enterScalestmt(BasicParser.ScalestmtContext ctx) {
        super.enterScalestmt(ctx);
    }

    @Override
    public void exitScalestmt(BasicParser.ScalestmtContext ctx) {
        super.exitScalestmt(ctx);
    }

    @Override
    public void enterColorstmt(BasicParser.ColorstmtContext ctx) {
        super.enterColorstmt(ctx);
    }

    @Override
    public void exitColorstmt(BasicParser.ColorstmtContext ctx) {
        super.exitColorstmt(ctx);
    }

    @Override
    public void enterHcolorstmt(BasicParser.HcolorstmtContext ctx) {
        super.enterHcolorstmt(ctx);
    }

    @Override
    public void exitHcolorstmt(BasicParser.HcolorstmtContext ctx) {
        super.exitHcolorstmt(ctx);
    }

    @Override
    public void enterHlinstmt(BasicParser.HlinstmtContext ctx) {
        super.enterHlinstmt(ctx);
    }

    @Override
    public void exitHlinstmt(BasicParser.HlinstmtContext ctx) {
        super.exitHlinstmt(ctx);
    }

    @Override
    public void enterVlinstmt(BasicParser.VlinstmtContext ctx) {
        super.enterVlinstmt(ctx);
    }

    @Override
    public void exitVlinstmt(BasicParser.VlinstmtContext ctx) {
        super.exitVlinstmt(ctx);
    }

    @Override
    public void enterOnerrstmt(BasicParser.OnerrstmtContext ctx) {
        super.enterOnerrstmt(ctx);
    }

    @Override
    public void exitOnerrstmt(BasicParser.OnerrstmtContext ctx) {
        super.exitOnerrstmt(ctx);
    }

    @Override
    public void enterPrstmt(BasicParser.PrstmtContext ctx) {
        super.enterPrstmt(ctx);
    }

    @Override
    public void exitPrstmt(BasicParser.PrstmtContext ctx) {
        super.exitPrstmt(ctx);
    }

    @Override
    public void enterInstmt(BasicParser.InstmtContext ctx) {
        super.enterInstmt(ctx);
    }

    @Override
    public void exitInstmt(BasicParser.InstmtContext ctx) {
        super.exitInstmt(ctx);
    }

    @Override
    public void enterStorestmt(BasicParser.StorestmtContext ctx) {
        super.enterStorestmt(ctx);
    }

    @Override
    public void exitStorestmt(BasicParser.StorestmtContext ctx) {
        super.exitStorestmt(ctx);
    }

    @Override
    public void enterRecallstmt(BasicParser.RecallstmtContext ctx) {
        super.enterRecallstmt(ctx);
    }

    @Override
    public void exitRecallstmt(BasicParser.RecallstmtContext ctx) {
        super.exitRecallstmt(ctx);
    }

    @Override
    public void enterListstmt(BasicParser.ListstmtContext ctx) {
        super.enterListstmt(ctx);
    }

    @Override
    public void exitListstmt(BasicParser.ListstmtContext ctx) {
        super.exitListstmt(ctx);
    }

    @Override
    public void enterPopstmt(BasicParser.PopstmtContext ctx) {
        super.enterPopstmt(ctx);
    }

    @Override
    public void exitPopstmt(BasicParser.PopstmtContext ctx) {
        super.exitPopstmt(ctx);
    }

    @Override
    public void enterAmptstmt(BasicParser.AmptstmtContext ctx) {
        super.enterAmptstmt(ctx);
    }

    @Override
    public void exitAmptstmt(BasicParser.AmptstmtContext ctx) {
        super.exitAmptstmt(ctx);
    }

    @Override
    public void enterIncludestmt(BasicParser.IncludestmtContext ctx) {
        super.enterIncludestmt(ctx);
    }

    @Override
    public void exitIncludestmt(BasicParser.IncludestmtContext ctx) {
        super.exitIncludestmt(ctx);
    }

    @Override
    public void enterEndstmt(BasicParser.EndstmtContext ctx) {
        sbuf.append(TABS[level] + "System.exit(0);\n");
        //super.enterEndstmt(ctx);
    }

    @Override
    public void exitEndstmt(BasicParser.EndstmtContext ctx) {
        //super.exitEndstmt(ctx);
    }

    @Override
    public void enterReturnstmt(BasicParser.ReturnstmtContext ctx) {
        super.enterReturnstmt(ctx);
    }

    @Override
    public void exitReturnstmt(BasicParser.ReturnstmtContext ctx) {
        super.exitReturnstmt(ctx);
    }

    @Override
    public void enterRestorestmt(BasicParser.RestorestmtContext ctx) {
        super.enterRestorestmt(ctx);
    }

    @Override
    public void exitRestorestmt(BasicParser.RestorestmtContext ctx) {
        super.exitRestorestmt(ctx);
    }

    @Override
    public void enterNumber(BasicParser.NumberContext ctx) {
        super.enterNumber(ctx);
    }

    @Override
    public void exitNumber(BasicParser.NumberContext ctx) {
        super.exitNumber(ctx);
    }

    @Override
    public void enterFunc(BasicParser.FuncContext ctx) {
        super.enterFunc(ctx);
    }

    @Override
    public void exitFunc(BasicParser.FuncContext ctx) {
        super.exitFunc(ctx);
    }

    @Override
    public void enterSignExpression(BasicParser.SignExpressionContext ctx) {
        super.enterSignExpression(ctx);
    }

    @Override
    public void exitSignExpression(BasicParser.SignExpressionContext ctx) {
        super.exitSignExpression(ctx);
    }

    @Override
    public void enterExponentExpression(BasicParser.ExponentExpressionContext ctx) {
        super.enterExponentExpression(ctx);
    }

    @Override
    public void exitExponentExpression(BasicParser.ExponentExpressionContext ctx) {
        super.exitExponentExpression(ctx);
    }

    @Override
    public void enterMultiplyingExpression(BasicParser.MultiplyingExpressionContext ctx) {
        super.enterMultiplyingExpression(ctx);
    }

    @Override
    public void exitMultiplyingExpression(BasicParser.MultiplyingExpressionContext ctx) {
        super.exitMultiplyingExpression(ctx);
    }

    @Override
    public void enterAddingExpression(BasicParser.AddingExpressionContext ctx) {
        super.enterAddingExpression(ctx);
    }

    @Override
    public void exitAddingExpression(BasicParser.AddingExpressionContext ctx) {
        super.exitAddingExpression(ctx);
    }

    @Override
    public void enterRelationalExpression(BasicParser.RelationalExpressionContext ctx) {
        super.enterRelationalExpression(ctx);
    }

    @Override
    public void exitRelationalExpression(BasicParser.RelationalExpressionContext ctx) {
        super.exitRelationalExpression(ctx);
    }

    @Override
    public void enterExpression(BasicParser.ExpressionContext ctx) {
        super.enterExpression(ctx);
    }

    @Override
    public void exitExpression(BasicParser.ExpressionContext ctx) {
        super.exitExpression(ctx);
    }

    @Override
    public void enterVar(BasicParser.VarContext ctx) {
        super.enterVar(ctx);
    }

    @Override
    public void exitVar(BasicParser.VarContext ctx) {
        super.exitVar(ctx);
    }

    @Override
    public void enterVarname(BasicParser.VarnameContext ctx) {
        super.enterVarname(ctx);
    }

    @Override
    public void exitVarname(BasicParser.VarnameContext ctx) {
        super.exitVarname(ctx);
    }

    @Override
    public void enterVarsuffix(BasicParser.VarsuffixContext ctx) {
        super.enterVarsuffix(ctx);
    }

    @Override
    public void exitVarsuffix(BasicParser.VarsuffixContext ctx) {
        super.exitVarsuffix(ctx);
    }

    @Override
    public void enterVarlist(BasicParser.VarlistContext ctx) {
        super.enterVarlist(ctx);
    }

    @Override
    public void exitVarlist(BasicParser.VarlistContext ctx) {
        super.exitVarlist(ctx);
    }

    @Override
    public void enterExprlist(BasicParser.ExprlistContext ctx) {
        super.enterExprlist(ctx);
    }

    @Override
    public void exitExprlist(BasicParser.ExprlistContext ctx) {
        super.exitExprlist(ctx);
    }

    @Override
    public void enterSqrfunc(BasicParser.SqrfuncContext ctx) {
        super.enterSqrfunc(ctx);
    }

    @Override
    public void exitSqrfunc(BasicParser.SqrfuncContext ctx) {
        super.exitSqrfunc(ctx);
    }

    @Override
    public void enterChrfunc(BasicParser.ChrfuncContext ctx) {
        super.enterChrfunc(ctx);
    }

    @Override
    public void exitChrfunc(BasicParser.ChrfuncContext ctx) {
        super.exitChrfunc(ctx);
    }

    @Override
    public void enterLenfunc(BasicParser.LenfuncContext ctx) {
        super.enterLenfunc(ctx);
    }

    @Override
    public void exitLenfunc(BasicParser.LenfuncContext ctx) {
        super.exitLenfunc(ctx);
    }

    @Override
    public void enterAscfunc(BasicParser.AscfuncContext ctx) {
        super.enterAscfunc(ctx);
    }

    @Override
    public void exitAscfunc(BasicParser.AscfuncContext ctx) {
        super.exitAscfunc(ctx);
    }

    @Override
    public void enterMidfunc(BasicParser.MidfuncContext ctx) {
        super.enterMidfunc(ctx);
    }

    @Override
    public void exitMidfunc(BasicParser.MidfuncContext ctx) {
        super.exitMidfunc(ctx);
    }

    @Override
    public void enterPdlfunc(BasicParser.PdlfuncContext ctx) {
        super.enterPdlfunc(ctx);
    }

    @Override
    public void exitPdlfunc(BasicParser.PdlfuncContext ctx) {
        super.exitPdlfunc(ctx);
    }

    @Override
    public void enterPeekfunc(BasicParser.PeekfuncContext ctx) {
        super.enterPeekfunc(ctx);
    }

    @Override
    public void exitPeekfunc(BasicParser.PeekfuncContext ctx) {
        super.exitPeekfunc(ctx);
    }

    @Override
    public void enterIntfunc(BasicParser.IntfuncContext ctx) {
        super.enterIntfunc(ctx);
    }

    @Override
    public void exitIntfunc(BasicParser.IntfuncContext ctx) {
        super.exitIntfunc(ctx);
    }

    @Override
    public void enterSpcfunc(BasicParser.SpcfuncContext ctx) {
        super.enterSpcfunc(ctx);
    }

    @Override
    public void exitSpcfunc(BasicParser.SpcfuncContext ctx) {
        super.exitSpcfunc(ctx);
    }

    @Override
    public void enterFrefunc(BasicParser.FrefuncContext ctx) {
        super.enterFrefunc(ctx);
    }

    @Override
    public void exitFrefunc(BasicParser.FrefuncContext ctx) {
        super.exitFrefunc(ctx);
    }

    @Override
    public void enterPosfunc(BasicParser.PosfuncContext ctx) {
        super.enterPosfunc(ctx);
    }

    @Override
    public void exitPosfunc(BasicParser.PosfuncContext ctx) {
        super.exitPosfunc(ctx);
    }

    @Override
    public void enterUsrfunc(BasicParser.UsrfuncContext ctx) {
        super.enterUsrfunc(ctx);
    }

    @Override
    public void exitUsrfunc(BasicParser.UsrfuncContext ctx) {
        super.exitUsrfunc(ctx);
    }

    @Override
    public void enterLeftfunc(BasicParser.LeftfuncContext ctx) {
        super.enterLeftfunc(ctx);
    }

    @Override
    public void exitLeftfunc(BasicParser.LeftfuncContext ctx) {
        super.exitLeftfunc(ctx);
    }

    @Override
    public void enterRightfunc(BasicParser.RightfuncContext ctx) {
        super.enterRightfunc(ctx);
    }

    @Override
    public void exitRightfunc(BasicParser.RightfuncContext ctx) {
        super.exitRightfunc(ctx);
    }

    @Override
    public void enterStrfunc(BasicParser.StrfuncContext ctx) {
        super.enterStrfunc(ctx);
    }

    @Override
    public void exitStrfunc(BasicParser.StrfuncContext ctx) {
        super.exitStrfunc(ctx);
    }

    @Override
    public void enterFnfunc(BasicParser.FnfuncContext ctx) {
        super.enterFnfunc(ctx);
    }

    @Override
    public void exitFnfunc(BasicParser.FnfuncContext ctx) {
        super.exitFnfunc(ctx);
    }

    @Override
    public void enterValfunc(BasicParser.ValfuncContext ctx) {
        super.enterValfunc(ctx);
    }

    @Override
    public void exitValfunc(BasicParser.ValfuncContext ctx) {
        super.exitValfunc(ctx);
    }

    @Override
    public void enterScrnfunc(BasicParser.ScrnfuncContext ctx) {
        super.enterScrnfunc(ctx);
    }

    @Override
    public void exitScrnfunc(BasicParser.ScrnfuncContext ctx) {
        super.exitScrnfunc(ctx);
    }

    @Override
    public void enterSinfunc(BasicParser.SinfuncContext ctx) {
        super.enterSinfunc(ctx);
    }

    @Override
    public void exitSinfunc(BasicParser.SinfuncContext ctx) {
        super.exitSinfunc(ctx);
    }

    @Override
    public void enterCosfunc(BasicParser.CosfuncContext ctx) {
        super.enterCosfunc(ctx);
    }

    @Override
    public void exitCosfunc(BasicParser.CosfuncContext ctx) {
        super.exitCosfunc(ctx);
    }

    @Override
    public void enterTanfunc(BasicParser.TanfuncContext ctx) {
        super.enterTanfunc(ctx);
    }

    @Override
    public void exitTanfunc(BasicParser.TanfuncContext ctx) {
        super.exitTanfunc(ctx);
    }

    @Override
    public void enterAtnfunc(BasicParser.AtnfuncContext ctx) {
        super.enterAtnfunc(ctx);
    }

    @Override
    public void exitAtnfunc(BasicParser.AtnfuncContext ctx) {
        super.exitAtnfunc(ctx);
    }

    @Override
    public void enterRndfunc(BasicParser.RndfuncContext ctx) {
        super.enterRndfunc(ctx);
    }

    @Override
    public void exitRndfunc(BasicParser.RndfuncContext ctx) {
        super.exitRndfunc(ctx);
    }

    @Override
    public void enterSgnfunc(BasicParser.SgnfuncContext ctx) {
        super.enterSgnfunc(ctx);
    }

    @Override
    public void exitSgnfunc(BasicParser.SgnfuncContext ctx) {
        super.exitSgnfunc(ctx);
    }

    @Override
    public void enterExpfunc(BasicParser.ExpfuncContext ctx) {
        super.enterExpfunc(ctx);
    }

    @Override
    public void exitExpfunc(BasicParser.ExpfuncContext ctx) {
        super.exitExpfunc(ctx);
    }

    @Override
    public void enterLogfunc(BasicParser.LogfuncContext ctx) {
        super.enterLogfunc(ctx);
    }

    @Override
    public void exitLogfunc(BasicParser.LogfuncContext ctx) {
        super.exitLogfunc(ctx);
    }

    @Override
    public void enterAbsfunc(BasicParser.AbsfuncContext ctx) {
        super.enterAbsfunc(ctx);
    }

    @Override
    public void exitAbsfunc(BasicParser.AbsfuncContext ctx) {
        super.exitAbsfunc(ctx);
    }

    @Override
    public void enterTabfunc(BasicParser.TabfuncContext ctx) {
        super.enterTabfunc(ctx);
    }

    @Override
    public void exitTabfunc(BasicParser.TabfuncContext ctx) {
        super.exitTabfunc(ctx);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        //System.out.println(ctx.getText());
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }
}
