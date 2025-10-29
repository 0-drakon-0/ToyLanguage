package toy_language.repository;

import toy_language.domain.prg_state.PrgState;
import toy_language.domain.statements.Stmt;

public class MyRepo implements Repository {
    //TODO -- ADAPT for threading
    private PrgState state;

    public MyRepo() {
        //useless for now
    }

    @Override
    public void addPrgState(PrgState state) {
        this.state = state;
    }
    @Override
    public PrgState getCrtPrg() {
        return this.state;
    }
    @Override
    public Stmt getOriginalState() {
        return this.state.getOriginal();
    }
}
