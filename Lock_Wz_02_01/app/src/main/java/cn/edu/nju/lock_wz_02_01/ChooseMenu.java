package cn.edu.nju.lock_wz_02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2016/2/1.
 */
public class ChooseMenu extends Activity {
    /**
     * @param MAX_NUM 代表图片的数量
     */
    public static int MAX_NUM = 4;
    public int[] resId = new int[MAX_NUM];
    private Switch sw_ad;
    private Switch sw_sales;
    private Switch sw_info;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_menu);



        /**
         * TODO Switch在切换到其他界面后再切换回来后仍然是默认的状态
         */
        sw_ad = (Switch) findViewById(R.id.sw_ad);
        sw_sales = (Switch) findViewById(R.id.sw_sales);
        sw_info = (Switch) findViewById(R.id.sw_info);


        sw_ad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPUtil.getInstance(ChooseMenu.this).save("sw_ad",isChecked);
            }
        });

        sw_sales.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPUtil.getInstance(ChooseMenu.this).save("sw_sales",isChecked);
            }
        });

        sw_info.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPUtil.getInstance(ChooseMenu.this).save("sw_info",isChecked);
            }
        });


//        /**
//         * 将ArrayList转成数组，方便在Preview里使用
//         */
//        for (int i = 0; i < listAll.size(); i++) {
//            resId[i] = listAll.get(i);
//        }
        /**
         *从选择菜单到主菜单
         */
        final Button ChooseToMain = (Button) findViewById(R.id.ChooseToMain);
        ChooseToMain.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        /**
         * 从选择菜单到预览界面
         */
        Button ChooseToPreview = (Button) findViewById(R.id.ChooseToPreview);
        ChooseToPreview.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ChooseMenu.this, Preview.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        sw_ad.setChecked(SPUtil.getInstance(ChooseMenu.this).get("sw_ad",true));
        sw_sales.setChecked(SPUtil.getInstance(ChooseMenu.this).get("sw_sales",true));
        sw_info.setChecked(SPUtil.getInstance(ChooseMenu.this).get("sw_info",true));
        super.onResume();
    }
}
