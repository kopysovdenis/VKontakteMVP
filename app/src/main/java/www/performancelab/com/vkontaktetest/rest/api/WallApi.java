package www.performancelab.com.vkontaktetest.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import www.performancelab.com.vkontaktetest.rest.model.response.WallGetResponse;

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Observable<WallGetResponse> get(@QueryMap Map<String, String> map);
}
