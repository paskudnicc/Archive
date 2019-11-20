package markup;

import java.util.List;

public class Emphasis extends WrapperAll {
    public Emphasis(List content) {
        super(content, new Tags("*", "\\emph{", "}", "em"));
    }
}