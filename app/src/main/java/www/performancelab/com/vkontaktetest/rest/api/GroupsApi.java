package www.performancelab.com.vkontaktetest.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import www.performancelab.com.vkontaktetest.model.Member;
import www.performancelab.com.vkontaktetest.rest.model.response.BaseItemResponse;
import www.performancelab.com.vkontaktetest.rest.model.response.Full;

public interface GroupsApi {
    @GET(ApiMethods.GROUPS_GET_MEMBERS)
    Observable<Full<BaseItemResponse<Member>>> getMembers(@QueryMap Map<String, String> map);
}
