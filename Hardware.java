package org.yourapp;

import org.renpy.android.PythonActivity;
import android.content.Context;
import android.hardware.Key;
import android.hardware.KeyEvent;
import android.hardware.KeyListener;
import android.hardware.KeyEventDispatcher;


public class Hardware {

    KeyEvent keyEvt = KeyEventRecorder.getLastEvent();

    private class KeyEventRecorder implements KeyEventDispatcher { 
        private static KeyEvent lastEvent;
        private static KeyEventRecorder myInstance;

        private KeyEventRecorder() {
            super();
        }

        public static synchronized KeyEventRecorder getInstance() {
            if ( myInstance == null )
                myInstance = new KeyEventRecorder();
            return myInstance;
        }

        public static KeyEvent getLastEvent() {
            return lastEvent;
        }
        public boolean dispatchKeyEvent(KeyEvent event) {
            lastEvent = event;
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    return true;
                        
                case KeyEvent.KEYCODE_VOLUME_UP:
                    return true;
                        
                case KeyEvent.KEYCODE_HOME:
                    return true
    
                case KeyEvent.KEYCODE_BACK:
                    return true
                }
                        
            } return false
            return super.dispatchKeyEvent(event);
        }
    }
     
} 