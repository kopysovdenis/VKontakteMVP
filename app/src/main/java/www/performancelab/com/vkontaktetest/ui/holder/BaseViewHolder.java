package www.performancelab.com.vkontaktetest.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import www.performancelab.com.vkontaktetest.model.view.BaseViewModel;

public abstract class BaseViewHolder<Item extends BaseViewModel> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(Item item);

    public abstract void unBindViewHolder();
}
