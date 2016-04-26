package pl.edu.agh.model;

/**
 * Created by Ace on 26.04.2016.
 */
public class UiDto {
    private double fromX;
    private double fromY;
    private double toX;
    private double toY;
    private String titleForm;
    private String descriptionFrom;
    private String titleTo;
    private String descriptionTo;

    public double getFromX() {
        return fromX;
    }

    public void setFromX(double fromX) {
        this.fromX = fromX;
    }

    public double getFromY() {
        return fromY;
    }

    public void setFromY(double fromY) {
        this.fromY = fromY;
    }

    public double getToX() {
        return toX;
    }

    public void setToX(double toX) {
        this.toX = toX;
    }

    public double getToY() {
        return toY;
    }

    public void setToY(double toY) {
        this.toY = toY;
    }

    public String getTitleForm() {
        return titleForm;
    }

    public void setTitleForm(String titleForm) {
        this.titleForm = titleForm;
    }

    public String getDescriptionFrom() {
        return descriptionFrom;
    }

    public void setDescriptionFrom(String descriptionFrom) {
        this.descriptionFrom = descriptionFrom;
    }

    public String getTitleTo() {
        return titleTo;
    }

    public void setTitleTo(String titleTo) {
        this.titleTo = titleTo;
    }

    public String getDescriptionTo() {
        return descriptionTo;
    }

    public void setDescriptionTo(String descriptionTo) {
        this.descriptionTo = descriptionTo;
    }
}
