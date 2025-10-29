package toy_language.repository;

import toy_language.domain.prg_state.PrgState;
import toy_language.domain.statements.Stmt;

public interface Repository {
    public PrgState getCrtPrg();
    public void addPrgState(PrgState state);
    public Stmt getOriginalState();
}
