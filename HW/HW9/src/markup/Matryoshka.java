package markup;

import java.util.List;

abstract class Matryoshka implements ToAnything {
    List<ToAnything> content;
    Tags tags;

    public Matryoshka(List<ToAnything> content, Tags tags){
        this.content = content;
        this.tags = tags;
    }

    public void toMarkdown(StringBuilder sb) {
        sb.append(tags.md);
        for (ToAnything c : content) {
            c.toMarkdown(sb);
        }
        sb.append(tags.md);
    }

    public void toTex(StringBuilder sb) {
        sb.append(tags.texStart);
        for (ToAnything c : content) {
            c.toTex(sb);
        }
        sb.append(tags.texEnd);
    }

    public void toHtml(StringBuilder sb) {
        sb.append(tags.htmlStart);
        for (ToAnything c : content) {
            c.toHtml(sb);
        }
        sb.append(tags.htmlEnd);
    }
}
