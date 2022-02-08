package expression;

import java.util.Objects;

public class Const  implements Inter {
    int var;

    public Const(int var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return Integer.toString(this.var);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return (this.var == (((Const) obj).var)) ;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return var;
    }

    @Override
    public int evaluate(int var) {
        return this.var;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return var;
    }
}
