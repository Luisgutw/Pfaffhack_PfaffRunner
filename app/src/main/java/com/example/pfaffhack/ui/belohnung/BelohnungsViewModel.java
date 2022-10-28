package com.example.pfaffhack.ui.belohnung;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BelohnungsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BelohnungsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}