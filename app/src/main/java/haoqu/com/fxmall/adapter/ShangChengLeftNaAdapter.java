package haoqu.com.fxmall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import haoqu.com.fxmall.JSONModel.GoodsListBean;
import haoqu.com.fxmall.R;

/**
 * 商城页面左边的导航表的adapter
 * Created by apple on 16/9/20.
 */
public class ShangChengLeftNaAdapter extends RecyclerView.Adapter<ShangChengLeftNaAdapter.ViewHolder> {

    private List<GoodsListBean.ListBean> listBeen;
    private Context context;

    public ShangChengLeftNaAdapter(Context context, List<GoodsListBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.shangcheng_leftnavigation_tv);
            //如果需要在此处写点击监听
        }


        public TextView getName() {
            return name;
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.scfragment_leftnavigation_tv, parent,false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (listBeen.get(position).getName() != null && listBeen.get(position).getName().length() > 0) {
            holder.getName().setText(listBeen.get(position).getName());

        }
    }


    @Override
    public int getItemCount() {
        return listBeen.size();
    }
}
