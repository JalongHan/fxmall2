package haoqu.com.fxmall.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import haoqu.com.fxmall.R;

public class GoodsDetailsActivity extends BaseActivity implements View.OnClickListener {


    private Toolbar mGoodsGoodToolBar;
    private ImageView mMainIvHomepage;
    private TextView mMainTvHomepage;
    private RelativeLayout mMainRlHomepage;
    private ImageView mMainIvShangcheng;
    private TextView mMainTvShangcheng;
    private RelativeLayout mMainRlShangcheng;
    private ImageView mMainIvCart;
    private TextView mMainTvCart;
    private RelativeLayout mMainRlCart;
    private Button mBtAddCart;
    private Button mBtBuy;
    private LinearLayout mGoodsDetailsBottomNavigation;
    private LinearLayout mGoodsGoodFragment;
    private RelativeLayout mActivityGoodsDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details);
        initView();

    }

    private void initView() {
        mGoodsGoodToolBar = (Toolbar) findViewById(R.id.goodsGood_toolBar);
        mMainIvHomepage = (ImageView) findViewById(R.id.main_iv_homepage);
        mMainTvHomepage = (TextView) findViewById(R.id.main_tv_homepage);
        mMainRlHomepage = (RelativeLayout) findViewById(R.id.main_rl_homepage);
        mMainIvShangcheng = (ImageView) findViewById(R.id.main_iv_shangcheng);
        mMainTvShangcheng = (TextView) findViewById(R.id.main_tv_shangcheng);
        mMainRlShangcheng = (RelativeLayout) findViewById(R.id.main_rl_shangcheng);
        mMainIvCart = (ImageView) findViewById(R.id.main_iv_cart);
        mMainTvCart = (TextView) findViewById(R.id.main_tv_cart);
        mMainRlCart = (RelativeLayout) findViewById(R.id.main_rl_cart);
        mBtAddCart = (Button) findViewById(R.id.bt_addCart);
        mBtBuy = (Button) findViewById(R.id.bt_buy);
        mGoodsDetailsBottomNavigation = (LinearLayout) findViewById(R.id.goodsDetails_bottomNavigation);
        mGoodsGoodFragment = (LinearLayout) findViewById(R.id.goodsGood_fragment);
        mActivityGoodsDetails = (RelativeLayout) findViewById(R.id.activity_goods_details);

        mBtAddCart.setOnClickListener(this);
        mBtBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_addCart:

                break;
            case R.id.bt_buy:

                break;
        }
    }
}
