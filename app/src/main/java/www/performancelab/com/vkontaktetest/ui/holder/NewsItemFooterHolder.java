package www.performancelab.com.vkontaktetest.ui.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.common.utils.Utils;
import www.performancelab.com.vkontaktetest.model.view.NewsItemFooterViewModel;
import www.performancelab.com.vkontaktetest.model.view.counter.CommentCounterVievModel;
import www.performancelab.com.vkontaktetest.model.view.counter.LikeCounterViewModel;
import www.performancelab.com.vkontaktetest.model.view.counter.RepostCounterVievModel;

public class NewsItemFooterHolder extends BaseViewHolder<NewsItemFooterViewModel> {
    @BindView(R.id.tv_date)
    public TextView tvDate;

    @BindView(R.id.tv_likes_count)
    public TextView tvLikesCount;

    @BindView(R.id.tv_likes_icon)
    public TextView tvLikesIcon;

    @BindView(R.id.tv_comments_count)
    public TextView tvCommentsCount;

    @BindView(R.id.tv_comments_icon)
    public TextView tvCommentsIcon;

    @BindView(R.id.tv_reposts_count)
    public TextView tvRepostCount;

    @BindView(R.id.tv_reposts_icon)
    public TextView tvRepostIcon;

    @Inject
    Typeface mGoogleFontTypeface;

    private Resources mResource;
    private Context mContext;

    public NewsItemFooterHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        MyApplication.getsApplicationComponent().inject(this);

        mContext = itemView.getContext();
        mResource = mContext.getResources();

        tvLikesIcon.setTypeface(mGoogleFontTypeface);
        tvCommentsIcon.setTypeface(mGoogleFontTypeface);
        tvRepostIcon.setTypeface(mGoogleFontTypeface);
    }


    @Override
    public void bindViewHolder(NewsItemFooterViewModel item) {
        tvDate.setText(Utils.parseDate(item.getDateLong(), mContext));

        bindComments(item.getComments());
        bindRepost(item.getReposts());
        bindLikes(item.getLike());
    }

    private void bindLikes(LikeCounterViewModel likes){
        tvLikesCount.setText(String.valueOf(likes.getCounter()));
        tvLikesCount.setTextColor(mResource.getColor(likes.getTextColor()));
        tvLikesIcon.setTextColor(mResource.getColor(likes.getIconColor()));
    }

    private void bindComments(CommentCounterVievModel comments){
        tvCommentsCount.setText(String.valueOf(comments.getCounter()));
        tvCommentsCount.setTextColor(mResource.getColor(comments.getTextColor()));
        tvCommentsIcon.setTextColor(mResource.getColor(comments.getIconColor()));
    }

    private void bindRepost(RepostCounterVievModel repost){
        tvRepostCount.setText(String.valueOf(repost.getCounter()));
        tvRepostCount.setTextColor(mResource.getColor(repost.getTextColor()));
        tvRepostIcon.setTextColor(mResource.getColor(repost.getIconColor()));
    }

    @Override
    public void unBindViewHolder() {
        tvDate.setText(null);
        tvLikesCount.setText(null);
        tvCommentsCount.setText(null);
        tvRepostCount.setText(null);
    }
}
