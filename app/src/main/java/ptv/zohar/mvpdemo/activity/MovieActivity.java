package ptv.zohar.mvpdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ptv.zohar.mvpdemo.R;
import ptv.zohar.mvpdemo.entity.Movie;
import ptv.zohar.mvpdemo.entity.Subjects;
import ptv.zohar.mvpdemo.mvp.presenter.MoviePresenter;
import ptv.zohar.mvpdemo.mvp.view.MovieView;
import ptv.zohar.mvpdemo.utils.LogUtils;
import ptv.zohar.mvpdemo.utils.ToastUtils;

/**
 * Created by Zohar on 2018/1/22.
 * desc: 电影
 */
public class MovieActivity extends BaseActivity<MoviePresenter> implements MovieView {
    @BindView(R.id.tv_result)
    AppCompatTextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        TAG = "MovieActivity";

        presenter = new MoviePresenter(this);
        presenter.attachView(this);
    }

    /**
     * 获取热门电影
     *
     * @param view view
     */
    public void requestTopMovie(View view) {
        presenter.requestTopMovie(0, 10);
    }

    @Override
    public void showTopMovie(Movie movie) {
        LogUtils.i(TAG, "onNext: " + movie.getTitle());
        StringBuilder builder = new StringBuilder(movie.getTitle()).append("\n");
        List<Subjects> list = movie.getSubjects();
        for (Subjects sub : list) {
            LogUtils.i(TAG, "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
            builder.append(sub.getId()).append(",").append(sub.getYear()).append(",").append(sub.getTitle()).append("\n");
        }
        tvResult.setText(builder.toString());
        ToastUtils.showLongToast(this, "获取完成");
    }
}