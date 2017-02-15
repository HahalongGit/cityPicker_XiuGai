package com.lll.mycitypicker;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lll.mycitypicker.view.widget.CityPickerDialog;
import com.lll.mycitypicker.view.widget.CityPickerPopWindow;

public class MainActivity extends AppCompatActivity implements CityPickerPopWindow.CityPickListener {

    private Activity mContext;
    private LinearLayout rootView;
    private TextView cityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        rootView = (LinearLayout) findViewById(R.id.root_layout);
        cityView = (TextView) findViewById(R.id.city);
    }

    public void selectCity(View view) {
        CityPickerDialog.Builder cityPickerDialog = new CityPickerDialog.Builder(mContext);
        cityPickerDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(dialog!=null){
                    dialog.dismiss();
                }
            }
        });
        cityPickerDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(dialog!=null){
                    dialog.dismiss();
                }
            }
        });
        CityPickerDialog pickerDialog = cityPickerDialog.create();
        pickerDialog.show();
        cityPickerDialog.setCityPickListener(new CityPickerDialog.Builder.CityPickListener() {
            @Override
            public void pickValue(String value) {
                Log.e("TAG","value:"+value);
                cityView.setText(value);
            }
        });

        //popwindow 选择器
        /*CityPickerPopWindow mPopWindow = new CityPickerPopWindow(mContext);
        mPopWindow.showPopupWindow(rootView);
        mPopWindow.setCityPickListener(this);*/
    }

    @Override
    public void pickValue(String value) {
        cityView.setText(value);
    }
}
