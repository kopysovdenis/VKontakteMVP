package www.performancelab.com.vkontaktetest.ui.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.model.view.NewsItemHeaderViewModel;

public class NewsItemHeaderHolder extends BaseViewHolder<NewsItemHeaderViewModel> {

    @BindView(R.id.civ_profile_image)
    public CircleImageView civProflieImage;

    @BindView(R.id.tv_profile_name)
    public TextView tvName;

    @BindView(R.id.iv_reposted_icon)
    public ImageView ivRepostedIcon;

    @BindView(R.id.tv_reposted_profile_name)
    public TextView tvReposdedProfileName;

    public NewsItemHeaderHolder (View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(NewsItemHeaderViewModel item) {
        Context context = itemView.getContext();

        Glide.with(context)
                .load(item.getProfilePhoto())
                .into(civProflieImage);

        tvName.setText(item.getProfileName());

        if (item.isRepost()){
            ivRepostedIcon.setVisibility(View.VISIBLE);
            tvReposdedProfileName.setText(item.getRepostProfileName());
        } else {
            ivRepostedIcon.setVisibility(View.GONE);
            tvReposdedProfileName.setText(null);
        }
    }

    @Override
    public void unBindViewHolder() {
        civProflieImage.setImageBitmap(null);
        tvName.setText(null);
        tvReposdedProfileName.setText(null);

    }
}
