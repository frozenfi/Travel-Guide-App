package fi.AdapterClass;

public class FavEventHelper {
    String nameOfEvent;
    String placeOfEvent;
   String desOfEvent;
    int imgURL;

    public FavEventHelper(String nameOfEvent, String placeOfEvent, String desOfEvent, int imgURL) {
        this.nameOfEvent = nameOfEvent;
        this.placeOfEvent = placeOfEvent;
        this.desOfEvent = desOfEvent;
        this.imgURL = imgURL;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public String getPlaceOfEvent() {
        return placeOfEvent;
    }

    public String getDesOfEvent() {
        return desOfEvent;
    }

    public int getImgURL() {
        return imgURL;
    }
}
