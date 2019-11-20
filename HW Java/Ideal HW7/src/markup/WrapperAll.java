package markup;

import java.util.List;

public abstract class WrapperAll implements Markable, Texable, Htmlable {
    List content;
    Tags tags;

    public WrapperAll(List content, Tags tags) {
        this.content = content;
        this.tags = tags;
    }

    public void toMarkdown(StringBuilder sb) {
        ToAnyLayout.toMarkdown(sb, content, tags.md);
    }

    public void toTex(StringBuilder sb) {
        ToAnyLayout.toTex(sb, content, tags.texStart, tags.texEnd);
    }

    public void toHtml(StringBuilder sb) {
        ToAnyLayout.toHtml(sb, content, tags.htmlStart, tags.htmlEnd);
    }
}
