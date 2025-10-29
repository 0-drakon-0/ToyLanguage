package toy_language.domain.values;

import toy_language.domain.types.Type;

public interface Value{
    public String toString();
    public Type getType();
    public Value deepCopy();
}
