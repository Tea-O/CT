package markup;

import java.util.List;

public class Strikeout extends AbstractText implements Inter {

    public Strikeout(List<Inter> obj) {
        super(obj);
    }

    public String div() {
        return "~";
    }

    public String divBBCodeS() {
        return "[s]";
    }

    public String divBBCodeE() {
        return "[/s]";
    }
}
