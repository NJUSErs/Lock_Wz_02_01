package cn.edu.nju.lock_wz_02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        /**
         *从主菜单到选择菜单
         */
        Button MainToChoose = (Button) findViewById(R.id.MainToChoose);
        MainToChoose.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(MainMenu.this, ChooseMenu.class);
                startActivity(intent);
            }
        });
    }
}
