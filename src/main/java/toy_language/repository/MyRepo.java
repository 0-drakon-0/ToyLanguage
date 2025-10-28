package toy_language.repository;

import toy_language.domain.prg_state.PrgState;

public class MyRepo implements Repository {
    //TODO -- ADAPT
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
}
