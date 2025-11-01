package toy_language.domain.types;

import toy_language.domain.values.IntValue;
import toy_language.domain.values.Value;

public class IntType implements Type {
    private int defaultVal = 0;

    @Override
    public boolean equals(Object another) {
        if (another instanceof IntType)
            return true;
        else
            return false;
    }
    @Override
    public String toString() {
        return "int";
    }
    @Override
    public Type deepCopy() {
        return new IntType();
    }
    @Override
    public Value defaultValue() {
        return new IntValue(this.defaultVal);
    }
}
