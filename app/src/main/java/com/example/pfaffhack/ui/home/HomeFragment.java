package com.example.pfaffhack.ui.home;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pfaffhack.R;
import com.example.pfaffhack.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    static View root;
    static Draw draw;

    public static void test(int x, int y) {
        System.out.print("test");
        ImageView img = root.findViewById(R.id.imageView);
        img.setLayoutParams(new LinearLayout.LayoutParams(100, 100));

        draw.inv(x,y);



    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        root = binding.getRoot();




        /*final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/



        //LinearLayOut Setup
        ImageView img = root.findViewById(R.id.imageView);
        img.setLayoutParams(new LinearLayout.LayoutParams(100, 100));


        //ImageView Setup
        //ImageView imageView = new ImageView(draw.getContext());

        //setting image resource
        //imageView.setImageResource(R.drawable.green_tile);

        //setting image position
        //adding view to layout
        //make visible to program
        //setContentView(linearLayout);
        //linearLayout.addView(imageView);



        draw = new Draw(img.getContext(), 1760,1290,1760+65,1290+65);

        /*
        Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        imageView.setImageBitmap(bitmap);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        Canvas canvas = new Canvas(bitmap);
        canvas.drawRect(
                100/5-30, 100/2-30,
                100/5+30, 100/2+30, paint
        );
        */
        draw.setBackgroundResource(R.drawable.map_pfaff);
        //return root;
        return draw;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}