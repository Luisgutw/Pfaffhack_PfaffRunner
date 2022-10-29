package com.example.pfaffhack;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.pfaffhack.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pfaffhack.databinding.ActivityMainBinding;

import de.fraunhofer.iese.platform_dev.enstadtpfaff_platform_mock_api.Event;
import de.fraunhofer.iese.platform_dev.enstadtpfaff_platform_mock_api.EventBroker;
import de.fraunhofer.iese.platform_dev.enstadtpfaff_platform_mock_api.PlatformMockApi;
import de.fraunhofer.iese.platform_dev.enstadtpfaff_platform_mock_api.PlatformMockApiFactory;
import de.fraunhofer.iese.platform_dev.enstadtpfaff_platform_mock_api.util.TopicUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PlatformMockApi platformMockApi;
    private EventBroker eventBroker;
    private int x,y;
    public static int energy;

    //Test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            platformMockApi = PlatformMockApiFactory.getDefault().mqtt(
                    "ssl://broker.platform.pfaffhack.de:8883",
                    "pfaffhack",
                    "kaiserslautern",
                    "gruppenname",
                    this::handler,
                    null
            );
            eventBroker = platformMockApi.getEventBroker();
            energy = 2642;
        } catch (EventBroker.CommunicationFailedException e) {
            System.err.println(e.getMessage());
        }
        try {
            eventBroker.subscribe("platform-mock/services/plate-detection/#");
        } catch (EventBroker.CommunicationFailedException e) {
            e.printStackTrace();
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_bestenliste, R.id.navigation_belohnung, R.id.navigation_statistics)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }

    private void handler(Event event) {
        System.out.println(event);
        String payload = event.getPayload();
        String topic = event.getTopic();
        String cut;
        try{
            if(!payload.substring(payload.length() -3).equals("se}")) {
                cut = topic.substring(topic.length() - 5);
                int n1 = Integer.parseInt(cut.split("_")[0]);
                int n2 = Integer.parseInt(cut.split("_")[1]);

                x = n1 -53;
                y = n2 -28;

                System.out.println(x);
                System.out.println(y);
                HomeFragment.test(x,y);
                energy += 10;
                System.out.println(energy);
                eventBroker.publish(
                        Event.of(
                                // TopicUtil helps you in forming valid topic named that comply to Topic Management
                                TopicUtil.sharedTopic("running-energy"),
                                // The Payload is always a String
                                String.valueOf(energy + 55800) + "Wh"
                        )
                );

            }
        }
        catch (Exception e) {
            System.out.print("didnt cut");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
}