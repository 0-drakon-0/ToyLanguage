package toy_language.domain.expressions;

import toy_language.domain.expressions.operators.ArithOp;
import toy_language.domain.values.Value;
import toy_language.domain.values.IntValue;
import toy_language.domain.adts.dictionary.MyDict;
import toy_language.domain.my_exceptions.*;
import toy_language.domain.types.IntType;

public class ArithExp implements Exp{
    Exp e1;
    Exp e2;
    ArithOp op;
    
    public ArithExp(Exp e1, Exp e2, ArithOp op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }
    @Override
    public Value eval(MyDict<String,Value> tbl) throws IdNotFoundException, IdAlreadyExistsException, MissmatchValueException, UnknownOperatorException, DivisionByZeroException{
        Value v1,v2;
        v1= e1.eval(tbl);
        if (v1.getType().equals(new IntType())) {
                v2 = e2.eval(tbl);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue)v1;
                IntValue i2 = (IntValue)v2;
                int n1,n2;
                n1= i1.getValue();
                n2 = i2.getValue();
                switch (op) {
                    case ADD:
                        return new IntValue(n1+n2);
                    case SUBTRACT:
                        return new IntValue(n1-n2);
                    case MULTIPLY:
                        return new IntValue(n1*n2);
                    case DIVIDE:
                        if (n2 == 0) {throw new DivisionByZeroException();};
                        return new IntValue(n1/n2);
                    default:
                        throw new UnknownOperatorException(op.toString());
                }
            }else
                throw new MissmatchValueException(new IntType(), v2.getType());
        } else {
            throw new MissmatchValueException(new IntType(), v1.getType());
        }
    }
}
