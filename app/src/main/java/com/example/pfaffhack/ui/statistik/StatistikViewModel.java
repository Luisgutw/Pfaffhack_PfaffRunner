package com.example.pfaffhack.ui.statistik;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StatistikViewModel extends ViewModel{
    private MutableLiveData<String> mText;

    public StatistikViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is statistik fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
