package www.performancelab.com.vkontaktetest.ui.holder;

import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.model.view.InfoLinksViewModel;

public class InfoLinksViewHolder extends BaseViewHolder<InfoLinksViewModel> {


    @BindView(R.id.rv_links)
    RelativeLayout rvLinks;

    public InfoLinksViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(InfoLinksViewModel infoLinksViewModel) {

    }

    @Override
    public void unBindViewHolder() {

    }
}