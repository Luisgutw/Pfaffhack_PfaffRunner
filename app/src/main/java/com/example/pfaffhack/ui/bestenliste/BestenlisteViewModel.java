package com.example.pfaffhack.ui.bestenliste;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BestenlisteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BestenlisteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}