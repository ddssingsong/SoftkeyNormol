package cn.key;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

import com.dds.softkeynormol.R;

import cn.key.view.KeyboardNormal;

public class NormolActivity extends Activity {
    private Context ctx;
    private Activity act;
    private EditText edit;
    private EditText edit1;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normol);
        ctx = this;
        act = this;

        edit = (EditText) this.findViewById(R.id.edit);
        edit.setInputType(InputType.TYPE_NULL);// 不显示光标

        edit1 = (EditText) this.findViewById(R.id.edit1);

        edit.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                new KeyboardNormal(act, ctx, edit).showKeyboard();
                return false;
            }
        });

        edit1.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inputback = edit1.getInputType();
                edit1.setInputType(InputType.TYPE_NULL);
                new KeyboardNormal(act, ctx, edit1).showKeyboard();
                edit1.setInputType(inputback);
                return false;
            }
        });

    }
}