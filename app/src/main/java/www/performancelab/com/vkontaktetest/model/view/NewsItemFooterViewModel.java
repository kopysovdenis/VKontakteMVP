package www.performancelab.com.vkontaktetest.model.view;

import android.view.View;

import www.performancelab.com.vkontaktetest.model.WallItem;
import www.performancelab.com.vkontaktetest.model.view.counter.CommentCounterVievModel;
import www.performancelab.com.vkontaktetest.model.view.counter.LikeCounterViewModel;
import www.performancelab.com.vkontaktetest.model.view.counter.RepostCounterVievModel;
import www.performancelab.com.vkontaktetest.ui.holder.BaseViewHolder;
import www.performancelab.com.vkontaktetest.ui.holder.NewsItemFooterHolder;

public class NewsItemFooterViewModel extends BaseViewModel {

    private int mId;
    private int ownerId;
    private long mDateLong;

    private LikeCounterViewModel mLike;
    private CommentCounterVievModel mComments;
    private RepostCounterVievModel mReposts;

    public NewsItemFooterViewModel(WallItem wallItem){
        this.mId = wallItem.getId();
        this.ownerId = wallItem.getOwnerId();
        this.mDateLong = wallItem.getDate();
        this.mLike = new LikeCounterViewModel(wallItem.getLikes());
        this.mComments = new CommentCounterVievModel(wallItem.getComments());
        this.mReposts = new RepostCounterVievModel(wallItem.getReposts());
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemFooter;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemFooterHolder(view);
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public long getDateLong() {
        return mDateLong;
    }

    public void setDateLong(long mDateLong) {
        this.mDateLong = mDateLong;
    }

    public LikeCounterViewModel getLike() {
        return mLike;
    }

    public void setLike(LikeCounterViewModel mLike) {
        this.mLike = mLike;
    }

    public CommentCounterVievModel getComments() {
        return mComments;
    }

    public void setComments(CommentCounterVievModel mComments) {
        this.mComments = mComments;
    }

    public RepostCounterVievModel getReposts() {
        return mReposts;
    }

    public void setReposts(RepostCounterVievModel mReposts) {
        this.mReposts = mReposts;
    }

    @Override
    public boolean isItemDecorator() {
        return true;
    }
}
