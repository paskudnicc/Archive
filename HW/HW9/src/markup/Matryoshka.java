package markup;

import java.util.List;

abstract class Matryoshka {
    List<Object> content;
    Type type;

    public Matryoshka(List<Object> content){
        this.content = content;
    }

    public Matryoshka(List<Object> content, Type type){
        this.content = content;
        this.type = type;
    }

    public void toMarkdown(StringBuilder sb) {
        recursiveMarkdown(sb.append(type.md));
        sb.append(type.md);
    }

    public void toTex(StringBuilder sb) {
        recursiveTex(sb.append("\\").append(type.tex).append("{"));
        sb.append("}");
    }

    public void toHtml(StringBuilder sb) {
        recursiveHtml(sb.append(Tag.startTag(type.html)));
        sb.append(Tag.endTag(type.html));
    }

    public void recursiveMarkdown(StringBuilder sb) {
        for (Object c : content){
            ((Matryoshka) c).toMarkdown(sb);
        }
    }

    public void recursiveTex(StringBuilder sb) {
        for (Object c : content){
            ((Matryoshka) c).toTex(sb);
        }
    }

    public void recursiveHtml(StringBuilder sb) {
        for (Object c : content){
            ((Matryoshka) c).toHtml(sb);
        }
    }
}
