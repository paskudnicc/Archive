package markup;

import java.util.List;

public class ListItem extends WrapperTexHtml {
    public ListItem(List content) {
        super(content, new Tags("", "\\item ", "", "li"));
    }
}
