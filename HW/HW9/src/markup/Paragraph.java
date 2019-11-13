package markup;

import java.util.List;

public class Paragraph extends Matryoshka {
    public Paragraph(List content) {
        super(content);
    }

    public void toMarkdown(StringBuilder sb) {
        super.recursiveMarkdown(sb);
    }

    public void toTex(StringBuilder sb) {
        super.recursiveTex(sb);
    }

    public void toHtml(StringBuilder sb) {
        super.recursiveHtml(sb);
    }
}
