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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import haoqu.com.fxmall.Consts;
import haoqu.com.fxmall.JSONModel.CartBean;
import haoqu.com.fxmall.R;
import haoqu.com.fxmall.TApplication;
import haoqu.com.fxmall.Tools.VolleyListenerInterface;
import haoqu.com.fxmall.Tools.VolleyRequestTool;
import haoqu.com.fxmall.adapter.CartItemRVAdapter;

/**
 * 购物车fragment
 * <p>
 * Created by apple on 16/9/22.
 */

public class CartFragment extends Fragment {
    private final String TAG = "CartFragment";
    private View view;
    private View mCartNocollect;
    private View mCartFreight;
    private RecyclerView mRcView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cart_fragment, null);

        initViews();

        setListeners();

        getJson();
        return view;
    }

    /**
     * 获取本页数据
     */
    private void getJson() {
        Map<String, String> map = new HashMap<>();
        map.put("uid", TApplication.uid);
        map.put("token", TApplication.token);

        VolleyRequestTool.RequestPost(
                getActivity(),
                Consts.baseUrl + Consts.appCart + Consts.weid,
                Consts.appCart,
                map,
                new VolleyListenerInterface(getActivity(),
                        VolleyListenerInterface.mListener, VolleyListenerInterface.mErrorListener) {
                    @Override
                    public void onMySuccess(String result) {
                        Log.i(TAG, "onMySuccess: " + result);

                        try {
                            CartBean cartBean = JSON.parseObject(result, CartBean.class);
                            if (cartBean != null) {
                                switch (Integer.valueOf(cartBean.getError())) {
                                    case 0:
                                        List<CartBean.ListBean> listBean = cartBean.getList();
                                        CartItemRVAdapter mCartItemRVAdapter = new CartItemRVAdapter(listBean,getActivity());
                                        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                                        mRcView.setLayoutManager(manager);
                                        mRcView.setAdapter(mCartItemRVAdapter);


                                        break;


                                    case -1:

                                        break;

                                    case -100:
                                        break;
                                    default:
                                        break;
                                }
                            }


                        } catch (Exception e) {

                        }

                    }

                    @Override
                    public void onMyError(VolleyError error) {

                    }
                });


    }


    /**
     * 初始化控件
     */
    private void initViews() {
        //无收藏时显示的view
        mCartNocollect = view.findViewById(R.id.cart_nocollect);

        //cart_freight结算view
        mCartFreight = view.findViewById(R.id.cart_freight);

        //recyclerview显示收藏的物品列表
        mRcView = (RecyclerView) view.findViewById(R.id.cartFragment_rv_collectItem);


    }


    /**
     * 设置监听
     */
    private void setListeners() {

    }
}
