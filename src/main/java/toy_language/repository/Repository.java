package toy_language.repository;

import toy_language.domain.prg_state.PrgState;

public interface Repository {
    public PrgState getCrtPrg();
    public void addPrgState(PrgState state);
}
