package toy_language.domain.types;


public class NullType implements Type {
    @Override
    public boolean equals(Object another) {
        if (another instanceof NullType)
            return true;
        else
            return false;
    }
    @Override
    public String toString() {
        return "Null";
    }
    @Override
    public Type deepCopy() {
        return new NullType();
    }
}
