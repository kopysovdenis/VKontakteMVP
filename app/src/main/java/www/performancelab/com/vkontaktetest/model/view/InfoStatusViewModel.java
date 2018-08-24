package www.performancelab.com.vkontaktetest.model.view;

import android.view.View;

import www.performancelab.com.vkontaktetest.model.Group;
import www.performancelab.com.vkontaktetest.ui.holder.BaseViewHolder;
import www.performancelab.com.vkontaktetest.ui.holder.InfoStatusViewHolder;

public class InfoStatusViewModel extends BaseViewModel {
    private String mStatus;

    private String mDescription;

    private String mSite;


    public InfoStatusViewModel(Group group) {
        this.mStatus = group.getStatus();

        this.mDescription = group.getDescription();

        this.mSite = group.getSite();

    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.InfoStatus;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(View view) {
        return new InfoStatusViewHolder(view);
    }


    public String getStatus() {
        return mStatus;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getSite() {
        return mSite;
    }

}