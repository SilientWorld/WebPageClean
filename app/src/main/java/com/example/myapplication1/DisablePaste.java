package com.example.myapplication1;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.EditText;
public class DisablePaste {

    // 禁止键盘粘贴，当检测到粘贴键按下时，返回 true 阻止粘贴操作
    @SuppressLint("ClickableViewAccessibility")
    public static void disablePaste(EditText editText) {
        editText.setOnKeyListener((v, keyCode, event) -> {
            return event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_PASTE; // 阻止粘贴
        });

        // 禁止触摸粘贴，当检测到一根手指抬起时，返回 true 阻止粘贴操作
        editText.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                return event.getPointerCount() == 1 && event.getX() <= v.getWidth() && event.getY() <= v.getHeight(); // 阻止粘贴
            }
            return false; // 允许其他事件
        });
    }
}
