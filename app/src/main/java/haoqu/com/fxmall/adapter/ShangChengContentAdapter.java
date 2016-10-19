package haoqu.com.fxmall.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import haoqu.com.fxmall.R;

/**
 * Created by apple on 16/9/20.
 */

public class ShangChengContentAdapter extends RecyclerView.Adapter<ShangChengContentAdapter.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView childThumb;


        public ViewHolder(View itemView) {
            super(itemView);
            childThumb = (ImageView) itemView.findViewById(R.id.SCFragment_rightcontent_iv);

        }

        public ImageView getChildThumb() {
            return childThumb;
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.scfragment_rightcontent_im, null);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 0;
    }
}
