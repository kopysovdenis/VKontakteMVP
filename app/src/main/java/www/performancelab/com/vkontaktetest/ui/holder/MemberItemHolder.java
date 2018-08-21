package www.performancelab.com.vkontaktetest.ui.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.model.view.MemberViewModel;

public class MemberItemHolder extends BaseViewHolder<MemberViewModel> {

    @BindView(R.id.civ_profile_image)
    public CircleImageView civProfilePhoto;

    @BindView(R.id.tv_profile_name)
    public TextView civProfileName;

    public MemberItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    @Override
    public void bindViewHolder(MemberViewModel memberViewModel) {
        Context context = itemView.getContext();

        Glide.with(context)
                .load(memberViewModel.getPhoto())
                .into(civProfilePhoto);
        civProfileName.setText(memberViewModel.getFullName());
    }

    @Override
    public void unBindViewHolder() {
        civProfileName.setText(null);
        civProfilePhoto.setImageBitmap(null);
    }
}
