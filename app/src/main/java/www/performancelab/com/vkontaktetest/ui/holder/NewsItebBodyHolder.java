package www.performancelab.com.vkontaktetest.ui.holder;

import android.view.View;
import android.widget.TextView;

import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.model.view.NewsFeedItemBodyViewModel;

public class NewsItebBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel> {

    public TextView mText;

    public NewsItebBodyHolder(View itemView) {
        super(itemView);

        mText = itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel newsFeedItemBodyViewModel) {
        mText.setText(newsFeedItemBodyViewModel.getText());
    }

    @Override
    public void unBindViewHolder() {
        mText.setText(null);
    }
}
