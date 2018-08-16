package www.performancelab.com.vkontaktetest.ui.holder;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.model.view.NewsItemBodyViewModel;

public class NewsItebBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    private TextView mText;

    private TextView mAttacments;

    @Inject
    protected Typeface mFontGoogle;

    public NewsItebBodyHolder(View itemView) {
        super(itemView);
        MyApplication.getsApplicationComponent().inject(this);

        mText = itemView.findViewById(R.id.tv_text);
        mAttacments = itemView.findViewById(R.id.tv_attachments);

        if (mAttacments != null){
            mAttacments.setTypeface(mFontGoogle);
        }
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel newsItemBodyViewModel) {
        mText.setText(newsItemBodyViewModel.getText());
        mAttacments.setText(newsItemBodyViewModel.getAttachmentString());
    }

    @Override
    public void unBindViewHolder() {
        mText.setText(null);
        mAttacments.setText(null);
    }
}
