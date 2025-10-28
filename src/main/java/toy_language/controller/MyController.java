package toy_language.controller;

import toy_language.domain.my_exceptions.ToyLanguageExceptions;
import toy_language.domain.my_exceptions.EmptyStackException;
import toy_language.domain.my_exceptions.NoProgramToRunException;
import toy_language.domain.prg_state.PrgState;
import toy_language.repository.*;
import toy_language.domain.statements.Stmt;
import toy_language.domain.adts.stack.MyStack;

public class MyController implements Controller {
    private Repository repo;
    private boolean printFlag = true; 

    public MyController(Repository repo) { 
        this.repo = repo;
    }

    @Override
    public void addPrgState(PrgState state) {
        this.repo.addPrgState(state);
    }

    @Override
    public PrgState oneStep(PrgState state) throws ToyLanguageExceptions {
        MyStack<Stmt> stk=state.getExeStk();
        if(stk.isEmpty()) 
            throw new EmptyStackException();
        Stmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }
    
    @Override
    public void allStep() throws ToyLanguageExceptions {
        PrgState prg = repo.getCrtPrg();
        if (prg == null)
            throw new NoProgramToRunException();
        while (!prg.getExeStk().isEmpty()){
            if (this.printFlag) {
                this.displayCurentState(prg);
                System.out.println("\n==>");
            }
            oneStep(prg);
        }
        if (this.printFlag) {
                this.displayCurentState(prg);
            }
    }
    @Override
    public void displayCurentState(PrgState state) {
        System.out.println(state.toString());
    }
    @Override
    public boolean getPrintFlag() {
        return this.printFlag;
    }
    @Override 
    public void flipPrintFlag() {
        if (printFlag)
            printFlag = false;
        else
            printFlag = true;
    }
}
