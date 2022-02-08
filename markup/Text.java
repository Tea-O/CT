package markup;

public class Text implements Inter {
    private String st;

    public Text(String st) {
        this.st = st;
    }

    @Override
    public void toMarkdown(StringBuilder vst) {
        vst.append(st);
    }

    @Override
    public void toBBCode(StringBuilder vst) {
        vst.append(st);
    }

    public String div() {
        return "";
    }

    public String divBBCodeE() {
        return "";
    }

    public String divBBCodeS() {
        return "";
    }
}
