package toy_language.controller;

import toy_language.domain.my_exceptions.FinishUnexistentStateException;
import toy_language.domain.my_exceptions.NoProgramToRunException;
import toy_language.domain.my_exceptions.ToyLanguageExceptions;
import toy_language.domain.prg_state.PrgState;
import toy_language.domain.statements.Stmt;

public interface Controller {
    public void addPrgState(PrgState state);
    public PrgState oneStep(PrgState state) throws ToyLanguageExceptions;
    public void allStep() throws ToyLanguageExceptions;
    public PrgState getCurrentState() throws NoProgramToRunException;
    public boolean getPrintFlag();
    public void flipPrintFlag();
    public Stmt getOriginalState() throws NoProgramToRunException;
    public void goToNextState() throws FinishUnexistentStateException;
}

