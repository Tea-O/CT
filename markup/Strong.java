package markup;

import java.util.List;
public class Strong extends AbstractText implements Inter {

    public Strong(List<Inter> obj) {
        super(obj);
    }

    public String divBBCodeS() {
        return  "[b]";
    }

    public String divBBCodeE() {
        return "[/b]";
    }

    public String div() {
        return "__";
    }
}
