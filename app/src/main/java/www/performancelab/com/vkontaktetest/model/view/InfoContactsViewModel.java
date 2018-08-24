package www.performancelab.com.vkontaktetest.model.view;

import android.view.View;

import www.performancelab.com.vkontaktetest.ui.holder.BaseViewHolder;
import www.performancelab.com.vkontaktetest.ui.holder.InfoContactsViewHolder;

public class InfoContactsViewModel extends BaseViewModel {
    @Override
    public LayoutTypes getType() {
        return LayoutTypes.InfoContacts;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(View view) {
        return new InfoContactsViewHolder(view);
    }
}