package markup;

import java.util.List;

public class Emphasis extends Matryoshka {
    public Emphasis(List content) {
        super(content, new Type("*", "emph", "em"));
    }
}
