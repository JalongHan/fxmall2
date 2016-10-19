package haoqu.com.fxmall.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * HomePage页顶部viewpager的adapter
 * Created by apple on 16/9/18.
 */
public class HomePageVPAdapter extends PagerAdapter{


    private List<ImageView> imgs;

    public HomePageVPAdapter(List<ImageView> imgs) {
        this.imgs = imgs;
    }

    @Override
    public int getCount() {

        return imgs.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(imgs.get(position));

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(imgs.get(position));

        return imgs.get(position);
    }


}
