package markup;

import java.util.List;

public class Emphasis extends AbstractText implements Inter {

    public Emphasis(List<Inter> obj) {
        super(obj);
    }

    public String divBBCodeS() {
        return "[i]";
    }

    public String divBBCodeE() {
        return "[/i]";
    }

    public String div() {
        return "*";
    }
}
