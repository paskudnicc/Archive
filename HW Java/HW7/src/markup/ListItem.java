package markup;

import java.util.List;

public class ListItem extends MatryoshkaWithoutMD {
    public ListItem(List content) {
        super(content, new Tags("", "\\item ", "", "li"));
    }
}