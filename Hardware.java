package org.yourapp; //надо этот файл закинуть в эту папку

import org.renpy.android.PythonActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;


public class Hardware {
    // храним последнее событие, которое мы получили от пользователя
    static public SensorEvent lastEvent = null;

    // Определяем нового пользователя
    static class AccelListener implements SensorEventListener {
        public void onSensorChanged(SensorEvent ev) {
            lastEvent = ev;
        }
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    // Создаем нашего пользователя
    static AccelListener accelListener = new AccelListener();

    // Метод включения/отключения акселерометра сервис и пользователь
    static void accelerometerEnable(boolean enable) {
        Context context = (Context) PythonActivity.mActivity;
        SensorManager sm = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        Sensor accel = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (accel == null) 
            return;

        if (enable)
            sm.registerListener(accelListener, accel, SensorManager.SENSOR_DELAY_GAME);
        else    
            sm.unregisterListener(accelListener, accel);
    }
}