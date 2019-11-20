package markup;

import java.util.List;

abstract class Matryoshka extends MatryoshkaWithoutMD implements Markable {
    public Matryoshka(List content, Tags tags){
        super(content, tags);
    }

    public void toMarkdown(StringBuilder sb) {
        sb.append(super.tags.md);
        for (Object c : super.content) {
            ((Markable) c).toMarkdown(sb);
        }
        sb.append(super.tags.md);
    }
}
