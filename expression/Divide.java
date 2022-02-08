package expression;

public class Divide extends Abstract implements Inter {

    public Divide(Inter var1, Inter var2) {
        super(var1, var2);
    }

    @Override
    public String operation() {
        return " / ";
    }

    @Override
    public int calculation(int a, int b) {
        return a / b;
    }
}
