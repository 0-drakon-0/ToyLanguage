package toy_language.domain.expressions;

import toy_language.domain.my_exceptions.IdNotFoundException;
import toy_language.domain.adts.dictionary.MyDict;
import toy_language.domain.values.*;

public class ValueExp implements Exp{
    Value val;
    //TODO -- see if can be removed
    public ValueExp(IntValue i) {
        val = i;
    }
    public ValueExp(BoolValue b) {
        val = b;
    }
    public ValueExp(Value val) {
        this.val = val;
    }

    @Override
    public Value eval(MyDict<String,Value> tbl) throws IdNotFoundException{
        return val;
    }
    @Override
    public String toString() {
        return this.val.toString();
    }
    public Exp deepCopy() {
        return new ValueExp(this.val.deepCopy());
    }
}
