package home.stanislavpoliakov.meet6_practice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = "meet6_logs";
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter intentFilter;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        startService(MyService.newIntent(MainActivity.this)); //запуск Service по onStartCommand
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }


    /**
     * В этот раз не имплиментирую интерфейс для изменения UI-компонент, а просто реализую метод onReceive
     * в теле Main Activity. Просто и лаконично
     */
    private void init() {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                editText.setText(intent.getStringExtra("Count"));
            }
        };

        intentFilter = new IntentFilter("Heartbeat");

        //Инициализируем глобальную переменную editText
        editText = fragmentManager.findFragmentById(R.id.fragment_1).getView().findViewById(R.id.editText);

        //Button button = findViewById(R.id.button);
        fragmentManager.beginTransaction()
                .add(R.id.layout_for_fragment_2, Fragment_2.newInstance())
                .commit();
    }


}
