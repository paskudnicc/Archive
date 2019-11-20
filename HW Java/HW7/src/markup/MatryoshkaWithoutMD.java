package markup;

import java.util.List;

abstract class MatryoshkaWithoutMD implements Texable, Htmlable {
    protected List<Object> content;
    protected Tags tags;

    public MatryoshkaWithoutMD(List content, Tags tags){
        this.content = content;
        this.tags = tags;
    }

    public void toTex(StringBuilder sb) {
        sb.append(tags.texStart);
        for (Object c : content) {
            ((Texable) c).toTex(sb);
        }
        sb.append(tags.texEnd);
    }

    public void toHtml(StringBuilder sb) {
        sb.append(tags.htmlStart);
        for (Object c : content) {
            ((Htmlable) c).toHtml(sb);
        }
        sb.append(tags.htmlEnd);
    }
}
