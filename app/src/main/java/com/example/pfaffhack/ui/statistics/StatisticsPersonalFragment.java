package com.example.pfaffhack.ui.statistics;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pfaffhack.MainActivity;
import com.example.pfaffhack.databinding.FragmentStatisticsBinding;
import com.example.pfaffhack.databinding.FragmentStatisticsPersonalBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatisticsPersonalFragment extends Fragment {
    private FragmentStatisticsPersonalBinding binding;

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentStatisticsPersonalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        barChart = binding.idBarChart;

        getBarEntries();
        barDataSet = new BarDataSet(barEntries, "");
        barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getBarEntries() {
        barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1f, 400));
        barEntries.add(new BarEntry(2f, 600));
        barEntries.add(new BarEntry(3f, 800));
        barEntries.add(new BarEntry(4f, 500));
        barEntries.add(new BarEntry(5f, 0));
        barEntries.add(new BarEntry(6f, 1000));
        barEntries.add(new BarEntry(7f, MainActivity.energy/4));
    }
}
