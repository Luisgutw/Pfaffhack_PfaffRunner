package com.example.pfaffhack.ui.belohnung;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pfaffhack.R;
import com.example.pfaffhack.databinding.FragmentBelohnungBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BelohnungFragment extends Fragment implements View.OnClickListener {

    private BelohnungsViewModel belohnungsViewModel;
    private FragmentBelohnungBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        belohnungsViewModel =
                new ViewModelProvider(this).get(BelohnungsViewModel.class);

        binding = FragmentBelohnungBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout scooter_layer = (LinearLayout) root.findViewById(R.id.ll_scooter);
        LinearLayout gartenschau_layer = (LinearLayout) root.findViewById(R.id.ll_gartenschau);
        LinearLayout hannen_layer = (LinearLayout) root.findViewById(R.id.ll_hannen);
        LinearLayout kino_layer = (LinearLayout) root.findViewById(R.id.ll_kino);

        scooter_layer.setOnClickListener(this);
        gartenschau_layer.setOnClickListener(this);
        hannen_layer.setOnClickListener(this);
        kino_layer.setOnClickListener(this);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_scooter:
                System.out.println("Scooter");
                break;
            case R.id.ll_gartenschau:
                // do your code
                System.out.println("Gartenschau");
                break;
            case R.id.ll_hannen:
                // do your code
                System.out.println("Hannenfass");
                break;
            case R.id.ll_kino:
                // do your code
                System.out.println("Kino");
                break;
            default:
                break;
        }
    }
}