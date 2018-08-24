package www.performancelab.com.vkontaktetest.ui.holder;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.model.view.InfoStatusViewModel;

public class InfoStatusViewHolder extends BaseViewHolder<InfoStatusViewModel> {

    @BindView(R.id.tv_status_text)
    public TextView tvStatusText;

    @BindView(R.id.tv_description_text)
    TextView tvDescriptionText;

    @BindView(R.id.tv_site_text)
    TextView tvSiteText;


    public InfoStatusViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(InfoStatusViewModel infoStatusViewModel) {
        tvStatusText.setText(infoStatusViewModel.getStatus());
        tvDescriptionText.setText(infoStatusViewModel.getDescription());
        tvSiteText.setText(infoStatusViewModel.getSite());
    }

    @Override
    public void unBindViewHolder() {
        tvStatusText.setText(null);
        tvDescriptionText.setText(null);
        tvSiteText.setText(null);
    }
}
