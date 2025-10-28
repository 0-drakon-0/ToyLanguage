package toy_language.domain.statements;

import toy_language.domain.my_exceptions.*;
import toy_language.domain.prg_state.PrgState;
import toy_language.domain.adts.stack.MyStack;

public class CompStmt implements Stmt{
    private Stmt first;
    private Stmt snd;
    
    public CompStmt(Stmt first, Stmt snd) {
        this.first = first;
        this.snd = snd;
    }

    @Override
    public String toString() {
        return "("+first.toString() + " ; " + snd.toString()+")";
    }

    @Override
    public PrgState execute(PrgState state) throws ToyLanguageExceptions {
        MyStack<Stmt> stk=state.getExeStk();
        stk.push(snd);
        stk.push(first);
        return state;
    }
}
