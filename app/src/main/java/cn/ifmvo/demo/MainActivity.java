package cn.ifmvo.demo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.ifmvo.bases.R;

/**
 * Created by 陈序员 on 2017/4/20.
 * Email: Matthew_Chen_1994@163.com
 * Blog: https://blog.ifmvo.cn
 */

public class MainActivity extends ListActivity {

    private String[] texts = new String[]{
            TestTopBarBaseActivity.class.getSimpleName(),
            TestBottomTabBaseActivity.class.getSimpleName(),
            TestRecyclerViewBaseActivity.class.getSimpleName()
    };

    private Class[] activityClasses = new Class[]{
        TestTopBarBaseActivity.class,
        TestBottomTabBaseActivity.class,
        TestRecyclerViewBaseActivity.class
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, R.layout.list_item_main, texts));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, activityClasses[position]));
    }
}
