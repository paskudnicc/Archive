package markup;

import java.util.List;

public class ListItem extends Matryoshka {
    public ListItem(List<Object> content) {
        super(content, new Type("", "", "li"));
    }

    @Override
    public void toTex(StringBuilder sb) {
        recursiveTex(sb.append("\\item "));
    }
}
