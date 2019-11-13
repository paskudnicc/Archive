package markup;

public class Tag {
    static StringBuilder startTag(String type) {
        return new StringBuilder("<").append(type).append(">");
    }

    static StringBuilder endTag(String type) {
        return new StringBuilder("</").append(type).append(">");
    }
}
