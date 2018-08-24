package www.performancelab.com.vkontaktetest.model.view;

import android.view.View;

import www.performancelab.com.vkontaktetest.model.Topic;
import www.performancelab.com.vkontaktetest.ui.holder.BaseViewHolder;
import www.performancelab.com.vkontaktetest.ui.holder.TopicItemHolder;

public class TopicViewModel extends  BaseViewModel {

    private int mId;
    private int mGroupId;
    private String mTitle;

    private String mCommentsCount;

    public TopicViewModel() {

    }

    public TopicViewModel(Topic topic) {
        this.mId = topic.getId();
        this.mGroupId = topic.getGroupId();

        this.mTitle = topic.getTitle();

        this.mCommentsCount = topic.getComments() + " сообщений";
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.Topic;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new TopicItemHolder(view);
    }

    public int getId() {
        return mId;
    }

    public int getGroupId() {
        return mGroupId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getCommentsCount() {
        return mCommentsCount;
    }
}
