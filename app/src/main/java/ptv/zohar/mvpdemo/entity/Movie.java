package ptv.zohar.mvpdemo.entity;

import java.util.List;

/**
 * Created by Zohar on 2018/3/29.
 * desc:
 */
public class Movie {
    private String title;
    private List<Subjects> subjects;

    public String getTitle() {
        return title;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
