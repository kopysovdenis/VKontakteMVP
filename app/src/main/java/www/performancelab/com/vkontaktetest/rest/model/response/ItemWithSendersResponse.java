package www.performancelab.com.vkontaktetest.rest.model.response;

import java.util.ArrayList;
import java.util.List;

import www.performancelab.com.vkontaktetest.model.Group;
import www.performancelab.com.vkontaktetest.model.Owner;
import www.performancelab.com.vkontaktetest.model.Profile;

public class ItemWithSendersResponse<T> extends BaseItemResponse<T> {

    private List<Profile> profile = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    private List<Profile> getProfile() {
        return profile;
    }

    private List<Group> getGroups() {
        return groups;
    }

    private List<Owner> getAllSenders(){
        List<Owner> all = new ArrayList<>();
        all.addAll(profile);
        all.addAll(groups);

        return all;
    }

    public Owner getSender(int id){
        for (Owner owner : getAllSenders()){
            if (owner.getId() == Math.abs(id)){
                return owner;
            }
        }
        return null;
    }
}
