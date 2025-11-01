package toy_language.repository;

import toy_language.domain.prg_state.PrgState;
import toy_language.domain.statements.Stmt;
import toy_language.domain.my_exceptions.FinishUnexistentStateException;
import toy_language.domain.my_exceptions.NoProgramToRunException;

public interface Repository {
    public PrgState getCrtPrg() throws NoProgramToRunException; // returns first prg in line
    //public PrgState getCrtPrg(String id);
    //public PrgState getAllCrtPrg();
    public void addPrgState(PrgState state);
    public Stmt getOriginalState() throws NoProgramToRunException; //returns from 1st prg in line
    //public Stmt getOriginalState(String id);
    //public Stmt getAllOriginalState();
    public void finishCrtState() throws FinishUnexistentStateException;
}
