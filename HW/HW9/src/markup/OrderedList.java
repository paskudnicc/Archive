package markup;

import java.util.List;

public class OrderedList extends Matryoshka {
    public OrderedList(List content) {
        super(content, new Tags("\\begin{enumerate}", "\\end{enumerate}", "ol"));
    }
}
