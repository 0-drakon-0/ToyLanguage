package toy_language.domain.prg_state;

import toy_language.domain.adts.dictionary.*;
import toy_language.domain.adts.stack.*;
import toy_language.domain.values.Value;
import toy_language.domain.statements.Stmt;

public class PrgState {
    private final MyDict<String, Value> symTable;
    private final MyStack<Stmt> exeStk;

    public PrgState(MyStack<Stmt> stk, MyDict<String, Value> dict) {
        this.symTable = dict;
        this.exeStk = stk;
    }
    
    public MyDict<String, Value> getSymTable() {
        return this.symTable;
    }
    public MyStack<Stmt> getExeStk() {
        return this.exeStk;
    }

}
