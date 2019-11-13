package markup;

import java.util.List;

public class UnorderedList extends Matryoshka {
    public UnorderedList(List content) {
        super(content, new Tags("\\begin{itemize}", "\\end{itemize}", "ul"));
    }
}
