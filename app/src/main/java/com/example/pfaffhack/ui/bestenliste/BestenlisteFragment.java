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

    private int[] werte = {462, 501, 510, 548, 646, 713, 727, 787, 807, 853, 933, 961, 998, 1086, 1108, 1152, 1161, 1194, 1228, 1299, 1358, 1534, 1560, 1607, 1630, 1661, 1729, 1767, 1800, 1915, 1976, 1979, 1995, 2076, 2102, 2104, 2298, 2340, 2377, 2393, 2407, 2409, 2423, 2450, 2463, 2513, 2598, 2634, 2640, 2672, 2700, 2785, 2789, 2837, 2872, 2878, 2932, 2958, 3050, 3058, 3069, 3111, 3287, 3324, 3378, 3451, 3501, 3567, 3590, 3647, 3671, 3749, 3766, 3787, 3864, 3919, 3921, 3928, 3971, 4071, 4081, 4096, 4209, 4234, 4325, 4430, 4434, 4502, 4629, 4642, 4806, 4884, 4904, 4981, 5198};
    private int myNumber = 42;
    private final String myName = "Max Mustermann";
    private final int myStrom = 3642;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bestenlisteViewModel =
                new ViewModelProvider(this).get(BestenlisteViewModel.class);

        myNumber = getNumber(myStrom);

        binding = FragmentBestenlisteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        List<userInfo> user_details = getListData();
        final ListView listView = (ListView) root.findViewById(R.id.listView);
        final TextView ownName = (TextView) root.findViewById(R.id.card_userName);
        final TextView ownStrom = (TextView) root.findViewById(R.id.card_stromAnzahl);
        final TextView ownNumber = (TextView) root.findViewById(R.id.card_number);


        ownName.setText(myName);
        ownStrom.setText(myStrom + " W");
        ownNumber.setText(myNumber + ".");


        listView.setAdapter(new CustomListAdapter(this.getContext(), user_details));


        return root;
    }

    private int getNumber(int number){
        int i = 0;
        while(number < werte[werte.length - 1 - i] && i < werte.length - 1){
            i++;
        }
        i++;
        return i;
    }

    private  List<userInfo> getListData() {

            String[] names = {"Asta Christoph",
                "Rebekka Ditschlerin-Misicher",
                "Yvette Schmidtke B.A.",
                "Antje Hahn",
                "Frederic Mude B.Sc.",
                "Prof. Elisabet Heinz B.Sc.",
                "Anni Huhn",
                "Dr. Gundi Holsten B.A.",
                "Ruthild Siering",
                "Emmy Hiller",
                "Anne-Kathrin Bonbach-Johann",
                "Herr Joachim Bloch",
                "Dr. Lea Gieß B.A.",
                "Ralph Rörricht-Scholz",
                "Birthe Kallert-Weitzel",
                "Sylvio Söding",
                "Reinhart Vollbrecht-Vogt",
                "Bernhardine Hecker B.A.",
                "Hassan Sontag-Bolander",
                "Harro Paffrath B.Sc.",
                "Frederik Löwer-Budig",
                "Birgit Patberg",
                "Hans-Friedrich Scheel MBA.",
                "Urszula Söding",
                "Karla Hübel B.Eng.",
                "Ariane Hermighausen",
                "Ing. Clara Trub",
                "Grit Gierschner",
                "Hasan Weller-Käster",
                "Goran Hartung B.A.",
                "Dr. Marlis Christoph",
                "Alicia Hänel",
                "Irmgard Jungfer",
                "Prof. Willibert Röhricht",
                "Univ.Prof. Ingelore Seidel",
                "Joerg Heydrich",
                "Donald Häring",
                "Maurice Säuberlich B.Eng.",
                "Phillip Lindau",
                "Aldo Wiek-Karge",
                "Blanka Rogner-Reichmann",
                "Carl-Heinz Kitzmann",
                "Aloisia Schmiedt",
                "Nick Zimmer",
                "Manja Hübel",
                "Dipl.-Ing. Timm Dobes",
                "Janine Römer",
                "Rochus Jähn",
                "Christopher Striebitz-Pohl",
                "Natalia Schaaf",
                "Hans-Uwe Klemt",
                "Andrey Sorgatz",
                "Dierk Rädel",
                "Agnieszka Trommler B.Sc.",
                "Greta Jäkel",
                "Bernt Barth",
                "Nicolai Henk",
                "Jiri Kade B.A.",
                "Prof. Karen Stoll",
                "Marlis Trüb",
                "Ing. Slawomir Biggen B.A.",
                "Ercan Neuschäfer",
                "Prof. Christel Roht",
                "Dr. Desiree Koch II",
                "Prof. Anne-Rose Hofmann",
                "Marika Killer",
                "Semra Klapp",
                "Arzu Liebelt",
                "Elly Gude",
                "Henryk Dörschner",
                "Ing. Gabi Scheuermann B.Eng.",
                "Sandor Ditschlerin",
                "Sylvie Putz",
                "Ing. Frederik Lübs",
                "Edelgard Ortmann B.Eng.",
                "Pawel Kobelt B.Sc.",
                "Anne Hauffer",
                "Michaela Pieper-Häring",
                "Rolf Fliegner",
                "Eberhard Neuschäfer",
                "Erdogan Seidel",
                "Karl Rosemann",
                "Frau Christine Pohl B.Sc.",
                "Jerzy Klapp",
                "Nikola Spieß",
                "Univ.Prof. Mario Gnatz",
                "Cordula Müller",
                "Ilka Köhler",
                "Loni Ernst",
                "Carla Adolph",
                "Catharina Herrmann",
                "Dipl.-Ing. Stjepan Krebs",
                "Univ.Prof. Leonie Köster",
                "Kira Gutknecht",
                "Anneliese Ditschlerin"};
        List<userInfo> list = new ArrayList<userInfo>();
        userInfo user1 = new userInfo("Max", 100930, 1);
        userInfo user2 = new userInfo("Adam", 10930, 2);
        userInfo user3 = new userInfo("Felix", 1030, 3);

        for(int i = 0; i < 94; i++){
            if(i == myNumber-1){
                list.add(new userInfo(myName, myStrom, myNumber));
            }
            else{
                list.add(new userInfo(names[i], werte[94-i], i+1));
            }
        }


        return list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}