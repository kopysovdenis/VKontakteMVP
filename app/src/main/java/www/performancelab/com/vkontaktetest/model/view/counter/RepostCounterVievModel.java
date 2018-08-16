package www.performancelab.com.vkontaktetest.model.view.counter;

import www.performancelab.com.vkontaktetest.model.Reposts;

public class RepostCounterVievModel extends CounterViewModel {

    private Reposts mReposts;

    public RepostCounterVievModel (Reposts reposts){
        super(reposts.getCount());

        this.mReposts = reposts;

        if (mReposts.getUserReposted() ==1){
            setAccentColor();
        }
    }

    public Reposts getReposts() {
        return mReposts;
    }
}
