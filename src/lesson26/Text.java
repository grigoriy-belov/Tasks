package lesson26;

public class Text {

    private String text;

    private String previousText;

    public Text(String text) {
        this.text = text;
    }

    public void setText(String text) {
        previousText = this.text;
        this.text = text;
    }

    public boolean isUpdated() {
        return !text.equals(previousText);
    }

    public String getText() {
        return text;
    }

    public void setPreviousText(String previousText) {
        this.previousText = previousText;
    }
}
