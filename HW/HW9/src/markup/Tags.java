package markup;

public class Tags {
    public String md;
    public String texStart;
    public String texEnd;
    public StringBuilder htmlStart;
    public StringBuilder htmlEnd;

    public Tags() {
        this.md = "";
        this.texStart = "";
        this.texEnd = "";
        this.htmlStart = new StringBuilder();
        this.htmlEnd = new StringBuilder();
    }

    public Tags(String texStart, String texEnd, String html) {
        this.md = "";
        this.texStart = texStart;
        this.texEnd = texEnd;
        this.htmlStart = new StringBuilder("<").append(html).append(">");
        this.htmlEnd = new StringBuilder("</").append(html).append(">");
    }

    public Tags(String md, String texStart, String texEnd, String html) {
        this.md = md;
        this.texStart = texStart;
        this.texEnd = texEnd;
        if (!html.isEmpty()) {
            this.htmlStart = new StringBuilder("<").append(html).append(">");
            this.htmlEnd = new StringBuilder("</").append(html).append(">");
        } else {
            this.htmlStart = new StringBuilder();
            this.htmlEnd = new StringBuilder();
        }
    }
}
