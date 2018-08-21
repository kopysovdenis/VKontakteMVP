package www.performancelab.com.vkontaktetest.rest.api;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import www.performancelab.com.vkontaktetest.model.Profile;
import www.performancelab.com.vkontaktetest.rest.model.response.Full;

public interface UsersApi {
    @GET(ApiMethods.USERS_GET)
    Observable<Full<List<Profile>>> get(@QueryMap Map<String, String> map);
}
