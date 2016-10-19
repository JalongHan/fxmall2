package haoqu.com.fxmall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import haoqu.com.fxmall.JSONModel.CartBean;
import haoqu.com.fxmall.R;

/**
 * Created by apple on 16/9/27.
 */

public class CartItemRVAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<CartBean.ListBean> mCartBeanList;

    public CartItemRVAdapter(List<CartBean.ListBean> mCartBeanList, Context mContext) {
        this.mCartBeanList = mCartBeanList;
        this.mContext = mContext;
    }


    public class viewHolder extends RecyclerView.ViewHolder {

        private CheckBox storePick, goodPick;
        private LinearLayout store;
        private RelativeLayout good;
        private ImageView storeLogo, goodImg;
        private Button subtract, add;
        private TextView storeName, goodTitle, sellPrice, marketPrice, goodOptions, freightPrice,total;

        public viewHolder(View itemView) {
            super(itemView);
            storePick = (CheckBox) itemView.findViewById(R.id.cartFragment_cb_storePick);
            goodPick = (CheckBox) itemView.findViewById(R.id.cartFragment_cb_goodPick);
            store = (LinearLayout) itemView.findViewById(R.id.cartFragment_ll_store);
            good = (RelativeLayout) itemView.findViewById(R.id.cartFragment_rl_good);
            storeLogo = (ImageView) itemView.findViewById(R.id.cartFragment_iv_storeLogo);
            goodImg = (ImageView) itemView.findViewById(R.id.cartFragment_iv_goodImg);
            subtract = (Button) itemView.findViewById(R.id.cartFragment_bt_subtract);
            add = (Button) itemView.findViewById(R.id.cartFragment_bt_add);
            storeName = (TextView) itemView.findViewById(R.id.cartFragment_tv_storeName);
            goodTitle = (TextView) itemView.findViewById(R.id.cartFragment_tv_goodTitle);
            sellPrice = (TextView) itemView.findViewById(R.id.cartFragment_tv_sellPrice);
            marketPrice = (TextView) itemView.findViewById(R.id.cartFragment_tv_marketPrice);
            goodOptions = (TextView) itemView.findViewById(R.id.cartFragment_tv_goodOptions);
            freightPrice = (TextView) itemView.findViewById(R.id.cartFragment_tv_freightPrice);
            total = (TextView) itemView.findViewById(R.id.cartFragment_tv_total);
        }

        public Button getAdd() {
            return add;
        }

        public TextView getFreightPrice() {
            return freightPrice;
        }

        public RelativeLayout getGood() {
            return good;
        }

        public ImageView getGoodImg() {
            return goodImg;
        }

        public TextView getGoodOptions() {
            return goodOptions;
        }

        public CheckBox getGoodPick() {
            return goodPick;
        }

        public TextView getGoodTitle() {
            return goodTitle;
        }

        public TextView getMarketPrice() {
            return marketPrice;
        }

        public TextView getSellPrice() {
            return sellPrice;
        }

        public LinearLayout getStore() {
            return store;
        }

        public ImageView getStoreLogo() {
            return storeLogo;
        }

        public TextView getStoreName() {
            return storeName;
        }

        public CheckBox getStorePick() {
            return storePick;
        }

        public Button getSubtract() {
            return subtract;
        }

        public TextView getTotal() {
            return total;
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_collectitem, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CartBean.ListBean listBean = mCartBeanList.get(position);

        Glide.with(mContext).load(listBean.getThumb()).into(((viewHolder) holder).getGoodImg());
        ((viewHolder) holder).getGoodTitle().setText(listBean.getId());
        ((viewHolder) holder).getGoodOptions().setText(listBean.getOptions());
        ((viewHolder) holder).getTotal().setText(listBean.getTotal());
        ((viewHolder) holder).getMarketPrice().setText(listBean.getMarketprice());

    }

    @Override
    public int getItemCount() {
        return mCartBeanList.size();
    }
}
