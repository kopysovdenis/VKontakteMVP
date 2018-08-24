package www.performancelab.com.vkontaktetest.model.view;

import android.view.View;

import www.performancelab.com.vkontaktetest.ui.holder.BaseViewHolder;
import www.performancelab.com.vkontaktetest.ui.holder.InfoLinksViewHolder;

public class InfoLinksViewModel extends BaseViewModel {

    @Override
    public BaseViewModel.LayoutTypes getType() {
        return BaseViewModel.LayoutTypes.InfoLinks;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(View view) {
        return new InfoLinksViewHolder(view);
    }
}