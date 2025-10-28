package toy_language.domain.prg_state;

import toy_language.domain.adts.dictionary.*;
import toy_language.domain.adts.stack.*;
import toy_language.domain.adts.list.*;
import toy_language.domain.values.Value;
import toy_language.domain.statements.Stmt;

public class PrgState {
    private final MyStack<Stmt> exeStk;
    private final MyDict<String, Value> symTable;
    private final MyList<Value> outList;
    //private final PrgState originalProgram;

    public PrgState(MyStack<Stmt> stk, MyDict<String, Value> dict, MyList<Value> list) {
        this.exeStk = stk;
        this.symTable = dict;
        this.outList = list;
        //this.originalProgram=deepCopy(prg);//recreate the entire original prg
    }
    
    public MyDict<String, Value> getSymTable() {
        return this.symTable;
    }
    public MyStack<Stmt> getExeStk() {
        return this.exeStk;
    }
    public MyList<Value> getOutList() {
        return this.outList;
    }
    @Override
    public String toString() {
        StringBuilder allStr = new StringBuilder();
        allStr.append(this.exeStk.toString());
        allStr.append("\n");
        allStr.append(this.symTable.toString());
        allStr.append("\n");
        allStr.append(this.outList.toString());
        return allStr.toString();
    }
    //public PrgState getOriginal() {
    //    return this.originalProgram;
    //}

}
