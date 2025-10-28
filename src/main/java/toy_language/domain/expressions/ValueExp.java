package toy_language.domain.expressions;

import toy_language.domain.my_exceptions.IdNotFoundException;
import toy_language.domain.adts.dictionary.MyDict;
import toy_language.domain.values.*;

public class ValueExp implements Exp{
    Value val;

    public ValueExp(IntValue i) {
        val = i;
    }
    public ValueExp(BoolValue b) {
        val = b;
    }

    @Override
    public Value eval(MyDict<String,Value> tbl) throws IdNotFoundException{
        return val;
    }
    @Override
    public String toString() {
        return this.val.toString();
    }
}
