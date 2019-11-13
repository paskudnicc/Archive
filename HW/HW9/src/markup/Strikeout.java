package markup;

import java.util.List;

public class Strikeout extends Matryoshka {
    public Strikeout(List content) {
        super(content, new Tags("~", "\\textst{", "}", "s"));
    }
}
