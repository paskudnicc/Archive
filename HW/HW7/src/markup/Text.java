package markup;

public class Text implements All{
    private String text;
    public Text(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }

    @Override
    public void toMarkdown(StringBuilder build) {
        build.append(text);
    }
}
