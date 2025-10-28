package toy_language.view.commands;

import toy_language.controller.Controller; 
import java.util.Scanner;

import toy_language.domain.statements.*;
import toy_language.domain.types.*;
import toy_language.domain.values.*;
import toy_language.domain.adts.dictionary.MyDict;
import toy_language.domain.adts.dictionary.SymbolTable;
import toy_language.domain.adts.list.MyList;
import toy_language.domain.adts.list.OutList;
import toy_language.domain.adts.stack.ExeStk;
import toy_language.domain.adts.stack.MyStack;
import toy_language.domain.expressions.*;
import toy_language.domain.my_exceptions.UnknownOperatorException;
import toy_language.domain.prg_state.PrgState;

public class SelectPrgCommand extends Command {
    private final Controller controller;
    private final Scanner keyboard = new Scanner(System.in);
    private final String[] hardcode_options = {
        "int v; v=2;Print(v)", 
        "int a;int b; a=2+3*5;b=a+1;Print(b)",
        "bool a; int v; a=true;(If a Then v=2 Else v=3);Print(v)" 
    };

        
    public SelectPrgCommand (String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
        
    }

    @Override
    public void execute() {
        this.printOptions();
        String option = keyboard.next();
        
        if(option.equals("1")) {
            this.loadOption1();
            System.out.println("program saved successfully");
        } else if (option.equals("2")) {
            this.loadOption2();
            System.out.println("program saved successfully");
        } else if (option.equals("3")) {
            this.loadOption3();
            System.out.println("program saved successfully");
        } else {
            System.err.println("unkown option");
        }
    }

    private void printOptions() {
        int ind = 1;
        System.out.println("\n----------- SELECT -----------");
        for (String s : this.hardcode_options) {
            String line = String.format("%3s. %s", Integer.toString(ind), s);
            System.out.println(line);
            ind++;
        }
        System.out.println("  0. Back");
        System.out.println("------------------------------");

    }
    private void loadOption1() {
        Stmt ex1= new CompStmt(new VarDeclStmt("v",new IntType()),new CompStmt(new AssignStmt("v",new ValueExp(new IntValue(2))), new PrintStmt(new VarExp("v"))));
        MyStack<Stmt> exeStk = new ExeStk<>();
        exeStk.push(ex1);
        MyDict<String, Value> symTable = new SymbolTable<>();
        MyList<Value> outList = new OutList<>();
        PrgState state = new PrgState(exeStk, symTable, outList);
        this.controller.addPrgState(state);
    }
    private void loadOption2() {
        try {
            Stmt ex2 = new CompStmt( new VarDeclStmt("a",new IntType()),new CompStmt(new VarDeclStmt("b",new IntType()),new CompStmt(new AssignStmt("a", new ArithExp('+',new ValueExp(new IntValue(2)),new ArithExp('*',new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))), new CompStmt(new AssignStmt("b",new ArithExp('+',new VarExp("a"), new ValueExp(new IntValue(1)))), new PrintStmt(new VarExp("b"))))));
            MyStack<Stmt> exeStk = new ExeStk<>();
            exeStk.push(ex2);
            MyDict<String, Value> symTable = new SymbolTable<>();
            MyList<Value> outList = new OutList<>();
            PrgState state = new PrgState(exeStk, symTable, outList);
            this.controller.addPrgState(state);
        } catch (UnknownOperatorException e) {
            //TODO
        }
    }
    private void loadOption3() {
        Stmt ex3 = new CompStmt(new VarDeclStmt("a",new BoolType()), new CompStmt(new VarDeclStmt("v", new IntType()), new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))), new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));
        MyStack<Stmt> exeStk = new ExeStk<>();
        exeStk.push(ex3);
        MyDict<String, Value> symTable = new SymbolTable<>();
        MyList<Value> outList = new OutList<>();
        PrgState state = new PrgState(exeStk, symTable, outList);
        this.controller.addPrgState(state);
    }

        
}
  
