package www.performancelab.com.vkontaktetest.model.view.counter;

import www.performancelab.com.vkontaktetest.model.Comments;

public class CommentCounterVievModel extends CounterViewModel {

    private Comments mComments;

    public CommentCounterVievModel(Comments comments) {
        super(comments.getCount());

        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}
