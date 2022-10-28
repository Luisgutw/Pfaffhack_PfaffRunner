package com.example.pfaffhack.ui.statistik;

import android.graphics.Color;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pfaffhack.R;
import com.example.pfaffhack.databinding.FragmentStatistikBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatistikViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public StatistikViewModel() {
        //mText = new MutableLiveData<>();
        //mText.setValue("Hier siehst du deine Statistiken");

    }

    public LiveData<String> getText() {
        return mText;
    }

}
