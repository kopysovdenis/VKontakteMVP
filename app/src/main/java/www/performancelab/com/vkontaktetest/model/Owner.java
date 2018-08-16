package www.performancelab.com.vkontaktetest.model;

import com.vk.sdk.api.model.Identifiable;

public interface Owner extends Identifiable {

    String getFullName();
    String getPhoto();
}
