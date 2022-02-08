package markup;

public interface Inter {
    public void toMarkdown(StringBuilder sb);

    public void  toBBCode(StringBuilder sb);

    public String div();

    public String divBBCodeE();

    public String divBBCodeS();
}
