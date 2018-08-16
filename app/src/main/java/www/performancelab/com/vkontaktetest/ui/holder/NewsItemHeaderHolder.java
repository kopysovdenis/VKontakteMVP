package www.performancelab.com.vkontaktetest.ui.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.model.view.NewsItemHeaderViewModel;

public class NewsItemHeaderHolder extends BaseViewHolder<NewsItemHeaderViewModel> {

    private CircleImageView civProflieImage;
    private TextView tvName;
    private ImageView ivRepostedIcon;
    private TextView tvReposdedProfileName;

    public NewsItemHeaderHolder (View itemView){
        super(itemView);

        this.civProflieImage = itemView.findViewById(R.id.civ_profile_image);
        this.tvName = itemView.findViewById(R.id.tv_profile_name);
        this.ivRepostedIcon = itemView.findViewById(R.id.iv_reposted_icon);
        this.tvReposdedProfileName = itemView.findViewById(R.id.tv_reposted_profile_name);
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
