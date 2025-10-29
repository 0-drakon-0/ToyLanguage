package toy_language.domain.values;

import toy_language.domain.types.BoolType;
import toy_language.domain.types.Type;


public class BoolValue implements Value {
    private boolean val;

    public BoolValue(boolean b) {
        this.val = b;
    }
    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
    @Override
    public Type getType() {
        return new BoolType();
    }
    public boolean getValue() {
        return val;
    }
    @Override
    public BoolValue deepCopy(){
        return new BoolValue(this.val);
    }

}
