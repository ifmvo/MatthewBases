package cn.ifmvo.bases;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by 陈序员 on 2017/4/19.
 * Email: Matthew_Chen_1994@163.com
 * Blog: https://blog.ifmvo.cn
 */
public abstract class RecyclerViewBaseActivity<T> extends TopBarBaseActivity{

    RecyclerView rv;

    @Override
    protected int getContentView() {
        return R.layout.activity_base_recyclerview;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.setAdapter(getAdapter());

    }

    protected abstract void getData();

    protected abstract RecyclerView.Adapter getAdapter(List<T> list);

}
