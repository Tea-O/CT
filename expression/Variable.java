package expression;

import java.util.Objects;

public class Variable implements Inter {
    String st;

    public Variable(String st) {
        this.st = st;
    }

    @Override
    public String toString() {
        return this.st;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return (this.st.equals(((Variable) obj).st)) ;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.st.hashCode();
    }

    @Override
    public int evaluate(int var) {
        return var;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (st.equals("x")) {
            return x;
        } else if (st.equals("y")) {
            return y;
        } else {
            return z;
        }
    }
}
