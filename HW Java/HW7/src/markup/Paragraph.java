package markup;

import java.util.List;

public class Paragraph extends Matryoshka {
    public Paragraph(List content) {
        super(content, new Tags());
    }
}
