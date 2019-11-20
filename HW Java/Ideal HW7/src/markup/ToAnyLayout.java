package markup;

import java.util.List;

public class ToAnyLayout {
    static public void toMarkdown(StringBuilder sb, List content, String md) {
        sb.append(md);
        for (Object c : content) {
            ((Markable) c).toMarkdown(sb);
        }
        sb.append(md);
    }

    static public void toTex(StringBuilder sb, List content, String texStart, String texEnd) {
        sb.append(texStart);
        for (Object c : content) {
            ((Texable) c).toTex(sb);
        }
        sb.append(texEnd);
    }

    static public void toHtml(StringBuilder sb, List content, StringBuilder htmlStart, StringBuilder htmlEnd) {
        sb.append(htmlStart);
        for (Object c : content) {
            ((Htmlable) c).toHtml(sb);
        }
        sb.append(htmlEnd);
    }
}
