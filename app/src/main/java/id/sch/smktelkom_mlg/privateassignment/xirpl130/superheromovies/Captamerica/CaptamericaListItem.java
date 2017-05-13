package id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.Captamerica;

import java.io.Serializable;

/**
 * Created by Nugrahanto on 13/05/2017.
 */

public class CaptamericaListItem implements Serializable {
    private String imageUrl;
    private String title;
    private String year;

    public CaptamericaListItem(String imageUrl, String title, String year) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.year = year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
}
