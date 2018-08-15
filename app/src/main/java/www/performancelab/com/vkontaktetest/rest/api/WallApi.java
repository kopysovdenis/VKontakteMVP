package www.performancelab.com.vkontaktetest.rest.api;




import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import www.performancelab.com.vkontaktetest.rest.model.response.BaseItemResponse;
import www.performancelab.com.vkontaktetest.rest.model.response.Full;
import www.performancelab.com.vkontaktetest.rest.model.response.WallGetResponse;

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<WallGetResponse> get(@QueryMap Map<String, String> map);
}
