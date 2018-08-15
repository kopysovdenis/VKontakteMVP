package www.performancelab.com.vkontaktetest.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import www.performancelab.com.vkontaktetest.model.view.BaseViewModel;
import www.performancelab.com.vkontaktetest.ui.holder.BaseViewHolder;

public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder<BaseViewModel>>{

    private List<BaseViewModel> list = new ArrayList<>();

    private ArrayMap<Integer, BaseViewModel> mTypeInstanse = new ArrayMap<>();

    @NonNull
    @Override
    public BaseViewHolder<BaseViewModel> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mTypeInstanse.get(viewType).createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<BaseViewModel> holder, int position) {
        holder.bindViewHolder(getItem(position));
    }

    @Override
    public void onViewRecycled(@NonNull BaseViewHolder<BaseViewModel> holder) {
        super.onViewRecycled(holder);
        holder.unBindViewHolder();
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType().getValue();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public BaseViewModel getItem (int position){
        return list.get(position);
    }

    public void registerTypeInstance(BaseViewModel item){
        if (!mTypeInstanse.containsKey(item.getType().getValue())){
            mTypeInstanse.put(item.getType().getValue(), item);
        }
    }

    public void addItems(List<BaseViewModel> newItems){
        for (BaseViewModel newItem : newItems) {
            registerTypeInstance(newItem);
        }

        list.addAll(newItems);

        notifyDataSetChanged();
    }


}
