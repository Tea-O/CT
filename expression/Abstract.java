package expression;

import java.util.List;
import java.util.Objects;

public abstract class Abstract implements Inter {

    public abstract int calculation(int a, int b);

    public abstract String operation();

    Inter var1;
    Inter var2;

    public Abstract(Inter var1, Inter var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public int evaluate(int var) {
        return calculation(var1.evaluate(var), var2.evaluate(var));
    }


    public int evaluate(int x, int y, int z) {
        return calculation(var1.evaluate(x, y, z), var2.evaluate(x, y, z));
    }

    public String toString() {
        String st = "";
        st += "(" + var1.toString() + operation() + var2.toString() + ")";
        return st;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Abstract && obj.getClass() == getClass()) {
            return (this.var1.equals(((Abstract) obj).var1) &&
                    this.var2.equals(((Abstract) obj).var2));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(var1.hashCode(), var2.hashCode(), getClass());
    }
}
