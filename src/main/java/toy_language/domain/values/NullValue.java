package toy_language.domain.values;

import toy_language.domain.types.NullType;
import toy_language.domain.types.Type;

/*
 * THIS VALUE IS ONLY USED TO SIGNAL THAT THE VALUE OF A KEY IN MyDict IS EMPTY
 */
public class NullValue implements Value {
    private String val;

    public NullValue() {
        val = "Null"; 
    }

    @Override
    public String toString() {
        return this.val;
    }
    @Override
    public Type getType() {
        return new NullType();
    }
    public String getValue() {
        return val;
    }
}
