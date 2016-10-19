package haoqu.com.fxmall.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import haoqu.com.fxmall.R;

/**
 * 个人中心的fragment
 * Created by apple on 16/9/21.
 */

public class MyCenterFragment extends Fragment{

    //当页的根布局
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mycenter_fragment,null);

        initViews();


        return view;
    }

    private void initViews() {

    }
}
