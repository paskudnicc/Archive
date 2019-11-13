package markup;

import java.util.List;

public class Text extends Matryoshka{

    public Text(String str){
        super(List.of(str));
    }

    public void toMarkdown(StringBuilder sb) {
        sb.append(content.get(0));
    }

    public void toTex (StringBuilder sb) {
        sb.append(content.get(0));
    }

    public void toHtml(StringBuilder sb) {
        sb.append(content.get(0));
    }
}
