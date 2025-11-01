package toy_language.controller;

import toy_language.domain.my_exceptions.ToyLanguageExceptions;
import toy_language.domain.my_exceptions.EmptyStackException;
import toy_language.domain.my_exceptions.FinishUnexistentStateException;
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
         if (state == null)
            throw new NoProgramToRunException();
        MyStack<Stmt> stk=state.getExeStk();
        if(stk.isEmpty()) 
            //this.repo.finishCrtState();    
            throw new EmptyStackException();
        Stmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }
    
    @Override
    public void allStep(ExecutionObserver observer) throws ToyLanguageExceptions {
        PrgState prg = repo.getCrtPrg();
        if (prg == null)
            throw new NoProgramToRunException();
        
        if (this.printFlag) {
            observer.onExecutionStart(prg);
        }
        while (!prg.getExeStk().isEmpty()) {
            oneStep(prg);
            if (this.printFlag) {
                observer.onStepExecuted(prg);
            }
        }
        if (this.printFlag) {
            observer.onExecutionFinish(prg);
        }
        //this.repo.finishCrtState();
    }
    //TODo -- we keep this depending on threading part
    @Override
    public void goToNextState() throws FinishUnexistentStateException{
        this.repo.finishCrtState();
    }

    @Override
    public PrgState getCurrentState() throws NoProgramToRunException {
        PrgState prg = this.repo.getCrtPrg();
        if (prg == null)
            throw new NoProgramToRunException();
        return prg;
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
    @Override
    public Stmt getOriginalState() throws NoProgramToRunException {
        PrgState prg = this.repo.getCrtPrg();
        if (prg == null)
            throw new NoProgramToRunException();
        return prg.getOriginal();
    }

}
