package expression;

public class Multiply extends Abstract implements Inter {

    public Multiply(Inter var1, Inter var2) {
        super(var1, var2);
    }

    @Override
    public String operation() {
        return " * ";
    }

    @Override
    public int calculation(int per1, int per2) {
        return per1 * per2;
    }
}
