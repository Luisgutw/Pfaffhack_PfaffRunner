package com.example.pfaffhack.ui.statistik;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pfaffhack.databinding.FragmentStatistikBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatistikFragment extends Fragment {
    private StatistikViewModel statistikViewModel;
    private FragmentStatistikBinding binding;

    TextView textView;

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        statistikViewModel = new ViewModelProvider(this).get(StatistikViewModel.class);

        binding = FragmentStatistikBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textStatistik;
        /*statistikViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });*/

        textView = binding.titleStatistik;
        textView.setTextSize(22f);

        barChart = binding.idBarChart;

        getBarEntries();
        barDataSet = new BarDataSet(barEntries, "");
        barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);

        XAxis xA = barChart.getXAxis();
        xA.disableGridDashedLine();

        YAxis yA = barChart.getAxisLeft();
        yA.disableGridDashedLine();

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
        barEntries.add(new BarEntry(7f, 800));
    }
}
