package www.performancelab.com.vkontaktetest.ui.holder;

import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.model.view.InfoContactsViewModel;

public class InfoContactsViewHolder extends BaseViewHolder<InfoContactsViewModel> {
    @BindView(R.id.rv_contacts)
    RelativeLayout rvContacts;

    public InfoContactsViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(InfoContactsViewModel infoContactsViewModel) {
    }

    @Override
    public void unBindViewHolder() {
    }
}