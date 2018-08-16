package www.performancelab.com.vkontaktetest.model.view;

import android.view.View;

import www.performancelab.com.vkontaktetest.model.WallItem;
import www.performancelab.com.vkontaktetest.ui.holder.BaseViewHolder;
import www.performancelab.com.vkontaktetest.ui.holder.NewsItebBodyHolder;

public class NewsItemBodyViewModel extends BaseViewModel {

    private int mId;

    private String mText;

    private String mAttachmentString;

    private boolean mIsRepost;

    public NewsItemBodyViewModel(WallItem wallItem){
        this.mId = wallItem.getId();
        this.mIsRepost = wallItem.haveSharedRepost();

        if (mIsRepost){
            this.mText = wallItem.getSharedRepost().getText();
            this.mAttachmentString = wallItem.getSharedRepost().getAttachmentsString();
        } else {
            this.mText = wallItem.getText();
            this.mAttachmentString = wallItem.getAttachmentsString();
        }

    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItebBodyHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }

    public String getAttachmentString() {
        return mAttachmentString;
    }
}
