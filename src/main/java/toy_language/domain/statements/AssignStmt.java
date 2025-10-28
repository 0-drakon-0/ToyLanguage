package toy_language.domain.statements;

import toy_language.domain.values.Value;
import toy_language.domain.my_exceptions.*;
import toy_language.domain.expressions.Exp;
import toy_language.domain.prg_state.PrgState;
import toy_language.domain.adts.dictionary.MyDict;
import toy_language.domain.types.Type;
import toy_language.domain.types.NullType;

public class AssignStmt implements Stmt{
    private String id;
    private Exp exp;

    public AssignStmt(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }
    @Override
    public String toString() {
        return this.id+"="+ this.exp.toString();
    }
    @Override
    public PrgState execute(PrgState state) throws ToyLanguageExceptions {
        MyDict<String,Value> symTbl= state.getSymTable();
        if (symTbl.isDefined(this.id)) {
            Value val = this.exp.eval(symTbl);
            Type typId= (symTbl.lookup(this.id)).getType();
            if ((val.getType()).equals(typId) || typId.equals(new NullType())) {
                symTbl.update(this.id, val);
            } else {
                throw new MissmatchValueException(typId, val.getType());
            }
        } else { 
            throw new IdNotDefinedException(this.id);
        }
        return state;
    }
}
