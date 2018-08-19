package www.performancelab.com.vkontaktetest.ui.holder;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.model.view.NewsItemBodyViewModel;

public class NewsItebBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    @BindView(R.id.tv_text)
    public TextView mText;
    @BindView(R.id.tv_attachments)
    public TextView mAttacments;

    @Inject
    protected Typeface mFontGoogle;

    public NewsItebBodyHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        MyApplication.getsApplicationComponent().inject(this);

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
