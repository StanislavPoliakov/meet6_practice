package home.stanislavpoliakov.meet6_practice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = "meet6_logs";
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        Button button = findViewById(R.id.button);
        fragmentManager.beginTransaction()
                .add(R.id.layout_for_fragment_2, Fragment_2.newInstance())
                .commit();
    }
}
