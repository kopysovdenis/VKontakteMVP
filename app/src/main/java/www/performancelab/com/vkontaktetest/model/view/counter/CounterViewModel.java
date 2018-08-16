package www.performancelab.com.vkontaktetest.model.view.counter;

import www.performancelab.com.vkontaktetest.R;

public class CounterViewModel {
    protected int mCounter;
    private int mIconColor = R.color.colorIconDis;
    private int mTextColor = R.color.colorIconDis;

    public CounterViewModel(int counter){
        this.mCounter = counter;

        if (counter > 0){
            setDefaultColor();
        } else {
            setDisableColor();
        }
    }

    private void setDisableColor() {
        mIconColor = R.color.colorIconDis;
        mTextColor = R.color.colorIconDis;
    }

    private void setDefaultColor() {
        mIconColor = R.color.colorIcon;
        mTextColor = R.color.colorIcon;
    }

    protected void setAccentColor(){
        mIconColor = R.color.colorAccent;
        mTextColor = R.color.colorAccent;
    }

    public int getCounter() {
        return mCounter;
    }

    public int getIconColor() {
        return mIconColor;
    }

    public int getTextColor() {
        return mTextColor;
    }
}
