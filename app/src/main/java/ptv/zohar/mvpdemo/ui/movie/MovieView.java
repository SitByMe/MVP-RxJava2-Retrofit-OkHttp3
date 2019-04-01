package ptv.zohar.mvpdemo.ui.movie;

import ptv.zohar.mvpdemo.entity.Movie;
import ptv.zohar.mvpdemo.ui.base.mvp.BaseView;

/**
 * Created by lhZou on 2018/1/23.
 * desc:
 */
public interface MovieView extends BaseView {
    void showTopMovie(Movie movie);
}