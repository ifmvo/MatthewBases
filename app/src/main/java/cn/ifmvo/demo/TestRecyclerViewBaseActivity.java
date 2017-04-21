package cn.ifmvo.demo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.ifmvo.bases.R;
import cn.ifmvo.bases.RecyclerViewBaseActivity;

/**
 * Created by 陈序员 on 2017/4/20.
 * Email: Matthew_Chen_1994@163.com
 * Blog: https://blog.ifmvo.cn
 */

public class TestRecyclerViewBaseActivity extends RecyclerViewBaseActivity {

    TestAdapter adapter;

    @Override
    protected void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    List<String> list = new ArrayList<>();
                    list.add("1");
                    list.add("2");
                    list.add("3");
                    list.add("4");
                    list.add("5");
                    list.add("6");
                    adapter.addDatas(list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected RecyclerView.Adapter getAdapter(List list) {
        return new TestAdapter(list);
    }


    class TestAdapter extends RecyclerView.Adapter<TestViewHolder>{

        List<String> list;

        public void addDatas(List<String> datas){
            list.addAll(datas);
            notifyDataSetChanged();
        }

        public TestAdapter(List<String> list) {
            this.list = list;
        }

        @Override
        public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(TestRecyclerViewBaseActivity.this).inflate(R.layout.list_item_main, null);
            return new TestViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(TestViewHolder holder, int position) {
            holder.tv.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class TestViewHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public TestViewHolder(View itemView) {
            super(itemView);
            itemView.findViewById(R.id.tvTitle);
        }
    }

}
