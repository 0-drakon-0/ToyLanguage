package toy_language.controller;

import toy_language.domain.my_exceptions.ToyLanguageExceptions;
import toy_language.domain.prg_state.PrgState;
import toy_language.domain.statements.Stmt;

public interface Controller {
    public void addPrgState(PrgState state);
    public PrgState oneStep(PrgState state) throws ToyLanguageExceptions;
    public void allStep() throws ToyLanguageExceptions;
    public PrgState getCurrentState();
    public boolean getPrintFlag();
    public void flipPrintFlag();
    public Stmt getOriginalState();
}

