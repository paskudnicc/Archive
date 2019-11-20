package markup;

import java.util.List;

public abstract class WrapperTexHtml implements Texable, Htmlable {
    List content;
    Tags tags;

    public WrapperTexHtml(List content, Tags tags) {
        this.content = content;
        this.tags = tags;
    }

    public void toTex(StringBuilder sb) {
        ToAnyLayout.toTex(sb, content, tags.texStart, tags.texEnd);
    }

    public void toHtml(StringBuilder sb) {
        ToAnyLayout.toHtml(sb, content, tags.htmlStart, tags.htmlEnd);
    }
}
