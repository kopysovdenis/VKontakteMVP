package www.performancelab.com.vkontaktetest;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;

public class CurrecnUser {

    public static String getAccessTocen(){
        if (VKAccessToken.currentToken() == null){
            return null;
        }
        return VKAccessToken.currentToken().accessToken;
    }
    public static String getId(){
        if (VKAccessToken.currentToken() != null){
            return VKAccessToken.currentToken().userId;
        }
        return null;
    }

    public static boolean isAuthorized(){
        return VKSdk.isLoggedIn()
                && VKAccessToken.currentToken() != null
                && !VKAccessToken.currentToken().isExpired();
    }
}
