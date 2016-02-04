package cn.edu.nju.lock_wz_02_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2016/2/1.
 *
 */

public class Preview extends Activity {
    private ViewFlipper flipper;
    private float startX;
    private List<Integer> listAll;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview);
        listAll = new ArrayList<>();
        listAll.add(R.drawable.hodo);
        if(SPUtil.getInstance(Preview.this).get("sw_ad",true)){
            listAll.add(R.drawable.ad1);
        }
        if(SPUtil.getInstance(Preview.this).get("sw_sales",true)){
            listAll.add(R.drawable.sales1);
        }
        if(SPUtil.getInstance(Preview.this).get("sw_info",true)){
            listAll.add(R.drawable.info1);
        }

        /**
         *循环播放图片
         */
        //动态导入的方式加入子View
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        for (int i=0; i <listAll.size() ; i++) {
            flipper.addView(getImageView(listAll.get(i)));
        }

        // TODO 这里的间隔时间待调整
        flipper.setFlipInterval(1000);
        flipper.startFlipping();

        /**
         *从预览菜单到选择菜单
         */
        Button PreviewToChoose = (Button) findViewById(R.id.PreviewToChoose);
        PreviewToChoose.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            //手指落下
            case MotionEvent.ACTION_DOWN:{
                startX = event.getX();
                break;
            }
            //手指滑动
            case MotionEvent.ACTION_MOVE:{
                //向右滑动看上一页
                // TODO 这里最佳滑动距离还待测试
                if (event.getX() - startX > 100){
                    flipper.showPrevious();
                }
                //向左滑动看下一页
                // TODO 这里最佳滑动距离还待测试
                if (startX - event.getX() > 100){
                    flipper.showNext();
                }
                break;
            }
            //手指离开
            case MotionEvent.ACTION_UP:{
                break;
            }
        }
        return super.onTouchEvent(event);
    }

    private ImageView getImageView(int resId){
        ImageView image = new ImageView(this);
        image.setBackgroundResource(resId);
        return  image;
    }
}
