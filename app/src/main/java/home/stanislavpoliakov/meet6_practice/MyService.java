package home.stanislavpoliakov.meet6_practice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        serviceWork();
        return START_NOT_STICKY;
    }

    private void serviceWork() {
        new Thread(new Runnable() {
            private StringBuilder stringBuilder = new StringBuilder();

            /**
             * Новая "игрушка" в вечном цикле
             */
            @Override
            public void run() {
                while (true) {
                    try {
                        String message = "Heartbeat";
                        for (int i = 0; i <= message.length(); i++) {
                            stringBuilder.append(message.toCharArray()[i]);
                            Intent intent = new Intent();
                            intent.setAction("Heartbeat");
                            intent.putExtra("Count", stringBuilder.toString());
                            sendBroadcast(intent);
                            Thread.sleep(1000);
                            if ("Heartbeat".equals(stringBuilder.toString())) {
                                stringBuilder.setLength(0);
                                i = -1;
                            }
                        }
                    } catch (InterruptedException ex) {

                    }
                }
            }
        }).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MyService.class);
    }
}
