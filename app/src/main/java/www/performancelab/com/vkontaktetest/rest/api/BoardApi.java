package www.performancelab.com.vkontaktetest.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import www.performancelab.com.vkontaktetest.model.Topic;
import www.performancelab.com.vkontaktetest.rest.model.response.BaseItemResponse;
import www.performancelab.com.vkontaktetest.rest.model.response.Full;

public interface BoardApi {
    @GET(ApiMethods.BOARD_GET_TOPICS)
    Observable<Full<BaseItemResponse<Topic>>> getTopics(@QueryMap Map<String, String> map);
}
