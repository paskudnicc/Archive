package markup;

import java.util.List;

abstract class Base implements All {
    List<All> content;
    public Base(List<All> content){
        this.content = content;
    }

    @Override
    public void toMarkdown(StringBuilder build) {
        for (All e : content){
            e.toMarkdown(build);
        }
    }
}
