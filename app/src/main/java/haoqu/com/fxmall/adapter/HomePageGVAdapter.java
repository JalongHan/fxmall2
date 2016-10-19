package haoqu.com.fxmall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import haoqu.com.fxmall.JSONModel.HomePageBean;
import haoqu.com.fxmall.R;

/**
 * 主页8个导航的gridview的adapter
 * Created by apple on 16/9/19.
 */
public class HomePageGVAdapter extends BaseAdapter {

    private List<HomePageBean.NavigationBean> navigationBar;
    private Context context;
    private LayoutInflater layoutInflater;

    public HomePageGVAdapter(Context context, List<HomePageBean.NavigationBean> navigationBar) {
        this.context = context;
        this.navigationBar = navigationBar;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return navigationBar.size();
    }

    @Override
    public Object getItem(int i) {
        return navigationBar.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        viewHolder viewHolder;
        if (view == null) {
            viewHolder = new viewHolder();
            view = layoutInflater.inflate(R.layout.homepage_gridview_item, null);
            viewHolder.ivIcon = (ImageView) view.findViewById(R.id.HomePage_gv_iv_icon);
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.HomePage_gv_tv_title);

            view.setTag(viewHolder);


        } else {
            viewHolder = (HomePageGVAdapter.viewHolder) view.getTag();
        }
        HomePageBean.NavigationBean navigationBean = (HomePageBean.NavigationBean) getItem(i);

        Glide.with(context).load(navigationBean.getThumb()).into(viewHolder.ivIcon);
        viewHolder.tvTitle.setText(navigationBean.getTitle());

        return view;
    }


    class viewHolder {
        //标签图片
        ImageView ivIcon;
        //标题
        TextView tvTitle;


    }


}
