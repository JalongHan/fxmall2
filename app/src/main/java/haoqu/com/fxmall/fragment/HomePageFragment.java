package haoqu.com.fxmall.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import haoqu.com.fxmall.Consts;
import haoqu.com.fxmall.JSONModel.HomePageBean;
import haoqu.com.fxmall.R;
import haoqu.com.fxmall.Tools.VolleyListenerInterface;
import haoqu.com.fxmall.Tools.VolleyRequestTool;
import haoqu.com.fxmall.activity.GoodsDetailsActivity;
import haoqu.com.fxmall.adapter.HomePageGVAdapter;
import haoqu.com.fxmall.adapter.HomePageVPAdapter;

/**
 * Created by apple on 16/9/18.
 */
public class HomePageFragment extends Fragment {


    private final String TAG = "HomePageFragment";

    //本fragment的根布局
    private View view;
    ////顶部广播轮播ViewPager
    private ViewPager viewPager;
    //第二部分,八个按钮GridView
    private GridView gridView;
    //HomePage_leftImg
    private ImageView HomePage_leftImg;
    //HomePage_rightImg
    private ImageView HomePage_rightImg;
    //HomePage_leftbigImg 低部左侧大图.
    private ImageView HomePage_leftbigImg;
    //HomePage_rightsmallImg1 低部右侧上小图
    private ImageView HomePage_rightsmallImg1;
    //HomePage_rightsmallImg2 低部右侧下小衅
    private ImageView HomePage_rightsmallImg2;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

        }
    };

    //viewpager需要的imageview数据
    private ArrayList<ImageView> imgBanners;
    //下面的显示ADimg的imageview
    private ArrayList<ImageView> ADViews;
    private HomePageVPAdapter homePageVPAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.homepage_fragment, null);
        imgBanners = new ArrayList<ImageView>();


        //初始化控件
        initViews();
        setListener();
        getHomePageJson();

        return view;
    }

    /**
     * 发请求去获得首页数据
     */
    private void getHomePageJson() {


        VolleyRequestTool.RequestPost(getActivity(),
                Consts.baseUrl + Consts.appIndex + Consts.weid,
                Consts.appIndex,
                null,
                new VolleyListenerInterface(getActivity(), VolleyListenerInterface.mListener, VolleyListenerInterface.mErrorListener) {
                    @Override
                    public void onMySuccess(String result) {
                        Log.i(TAG, result);
                        try {
                            //解析json变为homePageBean
                            HomePageBean homePageBean = JSON.parseObject(result, HomePageBean.class);
                            //顶部viewpager的图片的list
                            List<HomePageBean.CarouselBean> imgBanner = homePageBean.getCarousel();

                            //中部的导航8个位置.
                            List<HomePageBean.NavigationBean> navigationBar = homePageBean.getNavigation();

                            //底部宣传图5个.
                            List<HomePageBean.RecommendBean> ADImgs = homePageBean.getRecommend();



                            //给顶部viewpager循环加载图片
                            for (int i = 0; i < imgBanner.size(); i++) {
                                ImageView imageView = new ImageView(getActivity());
                                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                Glide.with(HomePageFragment.this).load(imgBanner.get(i).getThumb()).placeholder(R.mipmap.ic_launcher).into(imageView);
                                //将这imageview放入list中
                                imgBanners.add(imageView);
                            }
                            //将imgBanners显示到viewpager上
                            Log.i(TAG,String.valueOf(imgBanners.size()));
                            homePageVPAdapter = new HomePageVPAdapter(imgBanners);
                            viewPager.setAdapter(homePageVPAdapter);


                            //中部导航的8个位置 .显示在gridView上

                            HomePageGVAdapter homePageGVAdapter = new HomePageGVAdapter(getActivity(),navigationBar);
                            gridView.setAdapter(homePageGVAdapter);

                            //显示底部的五个画

                            for (int i = 0; i < ADViews.size(); i++) {
                                Glide.with(getActivity()).load(ADImgs.get(i).getThumb()).into(ADViews.get(i));
                            }



                        } catch (Exception e) {

                        }


                    }

                    @Override
                    public void onMyError(VolleyError error) {
                        Log.i(TAG, error.getMessage());
                    }
                });


    }

    /**
     * 初始化控件
     */
    private void initViews() {
        //顶部广播轮播ViewPager
        viewPager = (ViewPager) view.findViewById(R.id.HomePage_viewpager);
        //viewpager中的轮播小点放在此控件中


        //第二部分,八个按钮GridView
        gridView = (GridView) view.findViewById(R.id.HomePage_gridview);
        //HomePage_leftImg 左边图片
        HomePage_leftImg = (ImageView) view.findViewById(R.id.HomePage_leftImg);
        //HomePage_rightImg 右边图片
        HomePage_rightImg = (ImageView) view.findViewById(R.id.HomePage_rightImg);
        //HomePage_leftbigImg 最下面左侧大图.
        HomePage_leftbigImg = (ImageView) view.findViewById(R.id.HomePage_leftbigImg);
        //HomePage_rightsmallImg1 最下面右侧上小图1
        HomePage_rightsmallImg1 = (ImageView) view.findViewById(R.id.HomePage_rightsmallImg1);
        //HomePage_rightsmallImg2 最下面右侧下小图2
        HomePage_rightsmallImg2 = (ImageView) view.findViewById(R.id.HomePage_rightsmallImg2);
        //将底下ADimg的装在个数组中
        ADViews = new ArrayList<>();
        ADViews.add(HomePage_leftImg);
        ADViews.add(HomePage_rightImg);
        ADViews.add(HomePage_leftbigImg);
        ADViews.add(HomePage_rightsmallImg1);
        ADViews.add(HomePage_rightsmallImg2);

    }

    /**
     * 设置监听
     */

    private void setListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), GoodsDetailsActivity.class));
            }
        });

    }



}
