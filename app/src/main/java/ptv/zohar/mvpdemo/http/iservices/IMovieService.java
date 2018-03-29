package ptv.zohar.mvpdemo.http.iservices;

import io.reactivex.Observable;
import ptv.zohar.mvpdemo.entity.Movie;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Zohar on 2018/3/29.
 * desc:
 */
public interface IMovieService {
    @GET("top250")
    Observable<Movie> getTopMovie(@Query("start") int start, @Query("count") int count);
}
