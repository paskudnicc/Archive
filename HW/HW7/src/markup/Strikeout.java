package markup;

import java.util.List;

public class Strikeout extends Base {
    public Strikeout(List content) {
        super(content);
    }

    @Override
    public void toMarkdown(StringBuilder build) {
        super.toMarkdown(build.append("~"));
        build.append("~");
    }
}
