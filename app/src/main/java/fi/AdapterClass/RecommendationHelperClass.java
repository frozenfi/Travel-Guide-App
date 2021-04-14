package fi.AdapterClass;

public class RecommendationHelperClass {
    private int img;
    private String items, itemDescription;

    public RecommendationHelperClass(int img, String items, String itemDescription) {
        this.img = img;
        this.items = items;
        this.itemDescription = itemDescription;
    }

    public int getImg() {
        return img;
    }

    public String getItems() {
        return items;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}
