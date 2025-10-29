package toy_language.domain.types;


public interface Type {
    public boolean equals(Object another);
    public String toString();
    public Type deepCopy();
}

