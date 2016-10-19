package haoqu.com.fxmall.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import haoqu.com.fxmall.R;

/**
 *
 * 商品详情的商品页面
 * Created by apple on 16/10/15.
 */

public class GoodsGoodFragment extends Fragment{

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.goodsgood_fragment,null);
        return view;
    }
}
