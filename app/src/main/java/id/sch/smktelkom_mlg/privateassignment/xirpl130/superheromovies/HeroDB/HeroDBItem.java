package id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.HeroDB;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Nugrahanto on 14/05/2017.
 */

public class HeroDBItem extends SugarRecord implements Serializable {
    public String imageUrl;
    public String title;
    public String year;

    public HeroDBItem(String imageUrl, String title, String year) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.year = year;
    }
}
