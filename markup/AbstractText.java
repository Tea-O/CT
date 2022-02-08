package markup;

import java.util.List;

public abstract class AbstractText implements Inter {
    public abstract String div();

    public abstract String divBBCodeS();

    public abstract String divBBCodeE();
    /*protected StringBuilder buf = new StringBuilder();

    public AbstractText(String str) {
        this.buf.append(str);
    }*/

    List<Inter> interList;

    public AbstractText(List<Inter> list) {
        this.interList = list;
    }

    public void toBBCode(StringBuilder buf) {
        buf.append(divBBCodeS());
        for (Inter in : interList) {
            in.toBBCode(buf);
        }
        buf.append(divBBCodeE());
    }

    public void toMarkdown(StringBuilder buf) {
        buf.append(div());
        for (Inter in : interList) {
            in.toMarkdown(buf);
        }
        buf.append(div());
    }

}
