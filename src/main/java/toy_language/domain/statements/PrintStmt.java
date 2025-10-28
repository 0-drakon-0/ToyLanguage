package toy_language.domain.statements;

import toy_language.domain.my_exceptions.*;
import toy_language.domain.prg_state.PrgState;
import toy_language.domain.expressions.Exp;

public class PrintStmt implements Stmt{
    private Exp exp;
    
    public PrintStmt(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "print(" + exp.toString() + ")";
    }
    public PrgState execute(PrgState state) {
        //TODO -- after you implement Out list
        return state;
    }
}

