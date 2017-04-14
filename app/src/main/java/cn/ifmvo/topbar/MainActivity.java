package cn.ifmvo.topbar;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends TopBarBaseActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("陈序员");

        // 因为左上角的按钮 返回 功能用的比较多，所以可以重载一个方法。
        setTopLeftButton();

        setTopLeftButton(R.drawable.ic_return_white_24dp, new OnClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "陈序员点击了左上角按钮！", Toast.LENGTH_LONG).show();
            }
        });

        setTopRightButton("Button", R.drawable.ic_mine_white_24dp, new OnClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "点击了右上角按钮！", Toast.LENGTH_LONG).show();
            }
        });

//        setTopRightButton("陈序员", new OnClickListener() {
//            @Override
//            public void onClick() {
//
//            }
//        });
    }
}
