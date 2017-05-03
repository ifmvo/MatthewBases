package cn.ifmvo.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.ifmvo.bases.R;

/**
 * Created by 陈序员 on 2017/5/3.
 * Email: Matthew_Chen_1994@163.com
 * Blog: https://blog.ifmvo.cn
 */

public class TabFragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_tab, null);
        TextView tv = (TextView) inflate.findViewById(R.id.txt);
        tv.setBackgroundColor(Color.YELLOW);
        return inflate;
    }
}
