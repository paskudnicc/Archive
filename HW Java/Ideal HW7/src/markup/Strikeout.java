package markup;

import java.util.List;

public class Strikeout extends WrapperAll {
    public Strikeout(List content) {
        super(content, new Tags("~", "\\textst{", "}", "s"));
    }
}
