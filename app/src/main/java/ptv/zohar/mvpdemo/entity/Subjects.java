package ptv.zohar.mvpdemo.entity;

/**
 * Created by Zohar on 2018/3/29.
 * desc:
 */
public class Subjects {
    private String title, year, id;

    public Subjects(String title, String year, String id) {
        this.title = title;
        this.year = year;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
