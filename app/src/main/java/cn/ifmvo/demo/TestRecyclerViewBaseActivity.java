package cn.ifmvo.demo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.List;

import cn.ifmvo.bases.R;
import cn.ifmvo.bases.RecyclerViewBaseActivity;
import cn.ifmvo.bean.GankBean;
import cn.ifmvo.bean.ResponseBean;
import okhttp3.Call;
import okhttp3.Response;

/**
 * This is a Hello World .
 * Created by Matthew_Chen on 2018/3/15.
 */

public class TestRecyclerViewBaseActivity extends RecyclerViewBaseActivity<GankBean>{
    @Override
    protected void initBeforeGetData() {
        setTitle("快速实现列表");
        setTopLeftButton();
        setTopRightButton("陈序员", new OnClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(TestRecyclerViewBaseActivity.this, "快速实现列表", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected BaseQuickAdapter<GankBean, BaseViewHolder> getAdapter() {
        adapter = new BaseQuickAdapter<GankBean, BaseViewHolder>(R.layout.list_item_test_recycler_view) {
            @Override
            protected void convert(BaseViewHolder helper, GankBean item) {
                helper.setText(R.id.tv_text, item.desc);
            }
        };
        return adapter;
    }

    @Override
    protected void getData(final int pageIndex) {
        OkHttpUtils
                .get()
                .url("http://gank.io/api/data/Android/10/1")
                .build()
                .execute(new Callback<List<GankBean>>(){
                    @Override
                    public List<GankBean> parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        ResponseBean responseBean = new Gson().fromJson(string, ResponseBean.class);
                        return responseBean.results;
                    }
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        handleError();
                        Toast.makeText(TestRecyclerViewBaseActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(List<GankBean> response, int id) {
                        handleListData(response, pageIndex);
                    }
                });
    }
}
