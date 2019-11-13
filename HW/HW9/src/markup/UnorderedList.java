package markup;

import java.util.List;

public class UnorderedList extends Matryoshka {
    public UnorderedList(List<Object> content) {
        super(content, new Type("", "", "ul"));
    }

    @Override
    public void toTex(StringBuilder sb) {
        recursiveTex(sb.append("\\begin{itemize}"));
        sb.append("\\end{itemize}");
    }
}
