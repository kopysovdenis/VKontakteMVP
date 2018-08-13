package www.performancelab.com.vkontaktetest.rest.api;




import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import www.performancelab.com.vkontaktetest.rest.model.response.BaseItemResponse;
import www.performancelab.com.vkontaktetest.rest.model.response.Full;

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<Full<BaseItemResponse>> get(@Query("owner_id") String ownerId,
                                     @Query("access_tocen") String accessToken,
                                     @Query("extended") Integer extended,
                                     @Query("v") String version);
}
