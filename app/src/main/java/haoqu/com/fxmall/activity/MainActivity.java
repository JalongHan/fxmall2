package haoqu.com.fxmall.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import haoqu.com.fxmall.R;
import haoqu.com.fxmall.fragment.CartFragment;
import haoqu.com.fxmall.fragment.HomePageFragment;
import haoqu.com.fxmall.fragment.MyCenterFragment;
import haoqu.com.fxmall.fragment.ShangChengFragment;

public class MainActivity extends Activity {

    private Toolbar mToolbar;
    private View view;

    private ImageView toolbar_scan;
    private ImageView toolbar_options;
    private ImageView tollbar_message;
    private TextView toolbar_cart;
    private ImageView toolbar_search;
    private LinearLayout fragment;

    /**
     * 当前显示的fragment
     */

    int currentIndex = 0;

    /**
     * 选中的button,显示下一个fragment
     */

    int selectedIndex;

    private RelativeLayout[] mainRl = new RelativeLayout[4];

    ImageView[] ivArray = new ImageView[4];
    int[] ivID = new int[]{R.id.main_iv_homepage,R.id.main_iv_shangcheng,R.id.main_iv_cart,R.id.main_iv_mycneter};

    TextView[] tvArray = new TextView[4];
    int[] tvID = new int[]{R.id.main_tv_homepage,R.id.main_tv_shangcheng,R.id.main_tv_cart,R.id.main_tv_mycneter};

    //fragment数组
    Fragment[] fragments = null;
    private HomePageFragment homePageFragment;
    private MyCenterFragment mycenterFragment;
    private ShangChengFragment shangChengFragment;
    private CartFragment cartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        setListener();

    }

    /**
     * 设置监听
     */
    private void setListener() {
        MyListener myListener = new MyListener();
        for (int i = 0; i < mainRl.length; i++) {
            mainRl[i].setOnClickListener(myListener);
        }

    }

    /**
     * 初始化控件
     */
    private void initView() {
        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.Toolbar);
        //扫码按钮
        toolbar_scan = (ImageView)findViewById(R.id.toolbar_scan);
        //设置按钮
        toolbar_options = (ImageView) findViewById(R.id.toolbar_options);
        //消息按钮
        tollbar_message = (ImageView) findViewById(R.id.tollbar_message);
        //购物车的字
        toolbar_cart = (TextView) findViewById(R.id.toolbar_cart);
        //搜索的按钮
        toolbar_search = (ImageView) findViewById(R.id.toolbar_search);

        //fragment放置的位置
        fragment = (LinearLayout) findViewById(R.id.fragment);


        //底部的引入的navigation栏
        view = findViewById(R.id.main_bottom_navigation);

        mainRl[0] = (RelativeLayout)view.findViewById(R.id.main_rl_homepage);
        mainRl[1] = (RelativeLayout) view.findViewById(R.id.main_rl_shangcheng);
        mainRl[2] = (RelativeLayout) view.findViewById(R.id.main_rl_cart);
        mainRl[3] = (RelativeLayout) view.findViewById(R.id.main_rl_mycneter);

        //navigation中的图片
        for (int i = 0; i < ivID.length; i++) {
            ivArray[i] = (ImageView) view.findViewById(ivID[i]);
        }

        //navigation中的文字
        for (int i = 0; i < tvID.length; i++) {
            tvArray[i] = (TextView) view.findViewById(tvID[i]);
        }
        //设置默认状态
        ivArray[0].setSelected(true);
        tvArray[0].setSelected(true);

        homePageFragment = new HomePageFragment();
        shangChengFragment = new ShangChengFragment();
        cartFragment = new CartFragment();
        mycenterFragment = new MyCenterFragment();


        fragments = new Fragment[]{homePageFragment,shangChengFragment,cartFragment,mycenterFragment};

        //最开始显示第一个fragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment, fragments[0]);
        transaction.show(fragments[0]);
        transaction.commit();




    }


    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.main_rl_homepage:
                    selectedIndex = 0;
                    break;
                case R.id.main_rl_shangcheng:
                    selectedIndex = 1;
                    break;
                case R.id.main_rl_cart:
                    selectedIndex = 2;
                    break;
                case R.id.main_rl_mycneter:
                    selectedIndex = 3;
                    break;
            }

            //判断单击是不是当前的
            if (selectedIndex != currentIndex) {
                //不是当前的
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                //当前hide
                fragmentTransaction.hide(fragments[currentIndex]);
                Log.i("fragments", fragments.toString());
                //show你选中
                if (!fragments[selectedIndex].isAdded()) {
                    //以前没添加过

                    fragmentTransaction.add(R.id.fragment, fragments[selectedIndex]);
                }
                //事务显示
                fragmentTransaction.show(fragments[selectedIndex]);
                fragmentTransaction.commit();
                ivArray[selectedIndex].setSelected(true);
                ivArray[currentIndex].setSelected(false);

                tvArray[selectedIndex].setSelected(true);
                tvArray[currentIndex].setSelected(false);
                currentIndex = selectedIndex;
            }
        }
    }


}
