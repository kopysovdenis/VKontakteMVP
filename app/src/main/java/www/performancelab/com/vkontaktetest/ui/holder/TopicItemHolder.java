package www.performancelab.com.vkontaktetest.ui.holder;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.model.view.TopicViewModel;

public class TopicItemHolder extends BaseViewHolder<TopicViewModel> {

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    @BindView(R.id.tv_comments_count)
    public TextView tvCommentsCount;

    public TopicItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(TopicViewModel topicViewModel) {
        tvTitle.setText(topicViewModel.getTitle());
        tvCommentsCount.setText(topicViewModel.getCommentsCount());
    }

    @Override
    public void unBindViewHolder() {
        tvTitle.setText(null);
        tvCommentsCount.setText(null);
    }
}
