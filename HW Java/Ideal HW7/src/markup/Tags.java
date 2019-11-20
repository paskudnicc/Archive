package markup;

public class Tags {
    public String md = "";
    public String texStart = "";
    public String texEnd = "";
    public StringBuilder htmlStart = new StringBuilder();
    public StringBuilder htmlEnd = new StringBuilder();

    public Tags() {}

    public Tags(String md, String texStart, String texEnd, String html) {
        this.md = md;
        this.texStart = texStart;
        this.texEnd = texEnd;
        if (!html.isEmpty()) {
            this.htmlStart = new StringBuilder("<").append(html).append(">");
            this.htmlEnd = new StringBuilder("</").append(html).append(">");
        }
    }
}
