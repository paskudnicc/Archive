package markup;

import java.util.List;

public class Strong extends Base {
    public Strong(List content) {
        super(content);
    }

    @Override
    public void toMarkdown(StringBuilder build) {
        super.toMarkdown(build.append("__"));
        build.append("__");
    }
}
