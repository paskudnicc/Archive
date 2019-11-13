package markup;

public interface ToAnything {
    void toMarkdown(StringBuilder sb);

    void toTex(StringBuilder sb);

    void toHtml(StringBuilder sb);
}
