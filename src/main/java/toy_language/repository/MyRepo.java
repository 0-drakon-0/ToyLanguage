package toy_language.repository;

import java.util.List;
import java.util.ArrayList;

import toy_language.domain.my_exceptions.FinishUnexistentStateException;
import toy_language.domain.my_exceptions.NoProgramToRunException;
import toy_language.domain.prg_state.PrgState;
import toy_language.domain.statements.Stmt;

public class MyRepo implements Repository {
    //as of now it mimicks queue logic
    private List<PrgState> prgStates;

    public MyRepo() {
        this.prgStates = new ArrayList<>();
    }
    @Override
    public void addPrgState(PrgState state) {
        this.prgStates.add(state);
    }
    @Override
    public PrgState getCrtPrg() throws NoProgramToRunException{
        if (! this.prgStates.isEmpty())
            return this.prgStates.get(0);
        else 
            throw new NoProgramToRunException();
    }

    @Override
    public Stmt getOriginalState() throws NoProgramToRunException{
        return this.prgStates.get(0).getOriginal();
    }
    @Override 
    public void finishCrtState() throws FinishUnexistentStateException{
        if (! this.prgStates.isEmpty())
            this.prgStates.remove(0);
        else
            throw new FinishUnexistentStateException();
    }
}
