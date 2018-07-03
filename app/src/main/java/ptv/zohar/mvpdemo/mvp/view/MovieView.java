package ptv.zohar.mvpdemo.mvp.view;

import ptv.zohar.mvpdemo.entity.Movie;

/**
 * Created by Zohar on 2018/1/23.
 * desc:
 */
public interface MovieView extends BaseView {
    void showTopMovie(Movie movie);
}