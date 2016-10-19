package haoqu.com.fxmall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import haoqu.com.fxmall.JSONModel.GoodsListBean;
import haoqu.com.fxmall.R;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


/**
 * 商城右侧用到的recyclerView的adapter
 * Created by apple on 16/9/22.
 */

public class ShangChengRightRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<GoodsListBean.ListBean> listBean;
    private LayoutInflater layoutInflater;
    private Context context;

    public ShangChengRightRVAdapter(Context context, List<GoodsListBean.ListBean> listBean) {
        this.layoutInflater = LayoutInflater.from(context);
        this.listBean = listBean;
        this.context = context;
    }

    // 标题类型
    private static final int TYPE_CATEGORY_ITEM = 0;
    // 子项类型
    private static final int TYPE_ITEM = 1;

    /**
     * 确定item的类型.
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        //异常处理,没有的时候返回子项.
        if (listBean == null || position < 0 || position > getItemCount()) {

            return TYPE_ITEM;
        }

        //初始遍历位置
        int listbeanFristIndex = 0;
        //遍历这个list
        for (GoodsListBean.ListBean mListBean : listBean) {

            int size;
            if(mListBean.getChildren() != null){
                size = mListBean.getChildren().size() + 1;
            }else {
                size = 1;
            }

            //当前的索引
            int mListBeanIndex = position - listbeanFristIndex;
            //如果是首项,返回标题类型
            if (mListBeanIndex == 0) {
                return TYPE_CATEGORY_ITEM;
            }
            //如果是子项,返回子项类型.
            if (mListBeanIndex > 0 && mListBeanIndex < size) {

                return TYPE_ITEM;
            }
            listbeanFristIndex += size;
        }


        return TYPE_ITEM;
    }


    public class titleViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        public titleViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.scfragment_rightheader);
        }

        public TextView getTitle() {
            return title;
        }
    }

    public class contentViewHolder extends RecyclerView.ViewHolder {

        private final ImageView contentiv;

        public contentViewHolder(View itemView) {
            super(itemView);
            contentiv = (ImageView) itemView.findViewById(R.id.SCFragment_rightcontent_iv);
        }

        public ImageView getContentiv() {
            return contentiv;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = null;


        switch (viewType) {

            case TYPE_CATEGORY_ITEM:
                View tv = layoutInflater.inflate(R.layout.scfragment_rightheader, null);
                holder = new titleViewHolder(tv);
                break;
            case TYPE_ITEM:

                View iv = layoutInflater.inflate(R.layout.scfragment_rightcontent_im, null);
                holder = new contentViewHolder(iv);
                break;
            default:
                break;

        }


        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {

            case TYPE_CATEGORY_ITEM:
                Log.i(TAG, "onBindViewHolder:category "+"执行了");

                ((titleViewHolder) holder).getTitle().setText((String)getItem(position));

                break;
            case TYPE_ITEM:
                Log.i(TAG, "onBindViewHolder: "+getItem(position));
                Log.i(TAG, "getItemViewType(position)"+getItemViewType(position));
                Glide.with(context).load((String)getItem(position)).into(((contentViewHolder) holder).getContentiv());

                break;
            default:

                break;
        }
    }

    /**
     * 获得当前position的内容
     *
     * @param position
     * @return
     */
    public Object getItem(int position) {
        // 异常情况处理
        if (listBean == null || position < 0 || position > getItemCount()) {
            return null;
        }
        // 同一分类内，第一个元素的索引值
        int litBeanFirstIndex = 0;
        for (GoodsListBean.ListBean mListBean : listBean) {
            int size;
            if(mListBean.getChildren() == null){
                size = 1;
            }else {
                size = mListBean.getChildren().size() + 1;
            }

            // 在当前分类中的索引值
            int mListBeanIndex = position - litBeanFirstIndex;
            // item在当前分类内
            if(mListBeanIndex == 0){
                return mListBean.getName();
            }


            if (mListBeanIndex < size && mListBeanIndex >0) {
                return mListBean.getChildren().get(mListBeanIndex-1).getThumb();
            }
            // 索引移动到当前分类结尾，即下一个分类第一个元素索引
            litBeanFirstIndex += size;
        }
        return null;
    }

    /**
     * 获取所有分类的总数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        int count = 0;
        if (listBean != null) {
            count += listBean.size();
        }
        for (int i = 0; i < listBean.size(); i++) {
            if (listBean.get(i).getChildren() != null) {
                count += listBean.get(i).getChildren().size();
            }
        }

        return count;
    }
}
