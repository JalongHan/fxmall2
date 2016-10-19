package haoqu.com.fxmall.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.android.volley.VolleyError;

import java.util.List;

import haoqu.com.fxmall.Consts;
import haoqu.com.fxmall.JSONModel.GoodsListBean;
import haoqu.com.fxmall.R;
import haoqu.com.fxmall.Tools.VolleyListenerInterface;
import haoqu.com.fxmall.Tools.VolleyRequestTool;
import haoqu.com.fxmall.adapter.ShangChengLeftNaAdapter;
import haoqu.com.fxmall.adapter.ShangChengRightRVAdapter;

/**
 *
 * 商城fragment
 * Created by apple on 16/9/13.
 */
public class ShangChengFragment extends Fragment{

    private final String TAG= "ShangChengFragment";
    private View view;
    private RecyclerView SCFragment_leftNavigation;
    private RecyclerView SCFragment_Content;
    private LinearLayoutManager layoutManager;
    private LinearLayoutManager rLayouManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shangcheng_fragment,null);
        initViews();
        getJSON();
        return view;
    }

    /**
     * 发请求去获得当页数据
     */
    private void getJSON() {
        VolleyRequestTool.RequestPost(
                getActivity(),
                Consts.baseUrl + Consts.appGoodList + Consts.weid,
                Consts.appGoodList,
                null,
                new VolleyListenerInterface(getActivity(),VolleyListenerInterface.mListener,VolleyListenerInterface.mErrorListener) {
                    @Override
                    public void onMySuccess(String result) {
                        Log.i(TAG, "onMySuccess: "+result);
                        GoodsListBean goodsListBean = JSON.parseObject(result,GoodsListBean.class);

                        List<GoodsListBean.ListBean> listBean = goodsListBean.getList();

                        Log.i(TAG, "onMySuccess: "+listBean.size());
                        ShangChengLeftNaAdapter shangChengLeftNaAdapter = new ShangChengLeftNaAdapter(getActivity(),listBean);

                        SCFragment_leftNavigation.setAdapter(shangChengLeftNaAdapter);

                        ShangChengRightRVAdapter shangChengRightRVAdapter = new ShangChengRightRVAdapter(getActivity(),listBean);

                        SCFragment_Content.setAdapter(shangChengRightRVAdapter);



                    }

                    @Override
                    public void onMyError(VolleyError error) {
                        Log.i(TAG, "onMyError");
                    }
                });
    }

    /**
     * 初始化控件
     */
    private void initViews() {
        //SCFragment_leftNavigation左侧的导航条
        SCFragment_leftNavigation = (RecyclerView) view.findViewById(R.id.SCFragment_leftNavigation);

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        SCFragment_leftNavigation.setLayoutManager(layoutManager);


        //SCFragment_Content右侧的内容
        SCFragment_Content = (RecyclerView)view.findViewById(R.id.SCFragment_Content);
        rLayouManager = new LinearLayoutManager(getActivity());
        SCFragment_Content.setLayoutManager(rLayouManager);
    }
}
