package markup;

import java.util.List;

public class OrderedList extends MatryoshkaWithoutMD {
    public OrderedList(List content) {
        super(content, new Tags("", "\\begin{enumerate}", "\\end{enumerate}", "ol"));
    }
}
