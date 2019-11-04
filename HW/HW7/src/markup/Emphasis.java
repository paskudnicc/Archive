package markup;

import java.util.List;

public class Emphasis extends Base {

    public Emphasis(List content) {
        super(content);
    }

    @Override
    public void toMarkdown(StringBuilder build) {
        super.toMarkdown(build.append("*"));
        build.append("*");
    }
}
