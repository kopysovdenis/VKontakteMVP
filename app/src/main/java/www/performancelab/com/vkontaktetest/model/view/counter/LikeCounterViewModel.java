package www.performancelab.com.vkontaktetest.model.view.counter;

import www.performancelab.com.vkontaktetest.model.Likes;

public class LikeCounterViewModel extends CounterViewModel {

    private Likes mLike;

    public LikeCounterViewModel(Likes likes ) {
        super(likes.getCount());

        this.mLike = likes;

        if (mLike.getUserLikes() == 1){
            setAccentColor();
        }
    }

    public Likes getLike() {
        return mLike;
    }
}
