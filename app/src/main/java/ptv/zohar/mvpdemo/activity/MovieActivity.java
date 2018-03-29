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
public class MovieActivity extends BaseActivity implements MovieView {
    private final String TAG = "MovieActivity";
    @BindView(R.id.tv_result)
    AppCompatTextView tvResult;

    private MoviePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        presenter = new MoviePresenter(this, this);
        presenter.attachView(this);
    }

    /**
     * 获取热门电影
     *
     * @param view
     */
    public void getTopMovie(View view) {
        presenter.getTopMovie(0, 10);
    }

    @Override
    public void onLoginResult(Movie movie) {
        LogUtils.i(TAG, "onNext: " + movie.getTitle());
        List<Subjects> list = movie.getSubjects();
        for (Subjects sub : list) {
            LogUtils.i(TAG, "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
        }
        tvResult.setText(movie.toString());
        ToastUtils.showLongToast(this, "获取完成");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.detachView();
    }
}