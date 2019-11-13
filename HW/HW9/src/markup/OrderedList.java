package markup;

import java.util.List;

public class OrderedList extends Matryoshka {
    public OrderedList(List<Object> content) {
        super(content, new Type("", "", "ol"));
    }

    @Override
    public void toTex(StringBuilder sb) {
        recursiveTex(sb.append("\\begin{enumerate}"));
        sb.append("\\end{enumerate}");
    }
}
