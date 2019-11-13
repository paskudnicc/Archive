package markup;

import java.util.List;

public class Strong extends Matryoshka {
    public Strong(List content) {
        super(content, new Tags("__", "\\textbf{", "}", "strong"));
    }
}
