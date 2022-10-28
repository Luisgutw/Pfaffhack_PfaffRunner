package com.example.pfaffhack.ui.bestenliste;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pfaffhack.databinding.FragmentBestenlisteBinding;

import java.util.ArrayList;
import java.util.List;
import com.example.pfaffhack.R;

public class BestenlisteFragment extends Fragment {

    private BestenlisteViewModel bestenlisteViewModel;
    private FragmentBestenlisteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bestenlisteViewModel =
                new ViewModelProvider(this).get(BestenlisteViewModel.class);

        binding = FragmentBestenlisteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        List<userInfo> user_details = getListData();
        final ListView listView = (ListView) root.findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this.getContext(), user_details));


        return root;
    }

    private  List<userInfo> getListData() {
        List<userInfo> list = new ArrayList<userInfo>();
        userInfo user1 = new userInfo("Max", 100930, 1);
        userInfo user2 = new userInfo("Adam", 10930, 2);
        userInfo user3 = new userInfo("Felix", 1030, 3);


        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user1);
        list.add(user2);
        list.add(user3);


        return list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}