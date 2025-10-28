package toy_language.controller;

import toy_language.domain.my_exceptions.ToyLanguageExceptions;
import toy_language.domain.prg_state.PrgState;

public interface Controller {
    public void addPrgState(PrgState state);
    public PrgState oneStep(PrgState state) throws ToyLanguageExceptions;
    public void allStep() throws ToyLanguageExceptions;
    public void displayCurentState(PrgState state);
    public boolean getPrintFlag();
    public void flipPrintFlag();
}

