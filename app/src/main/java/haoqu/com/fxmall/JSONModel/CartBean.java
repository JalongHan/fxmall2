package haoqu.com.fxmall.JSONModel;

import java.util.List;

/**
 * 购物车fragment获取的购物车收藏的商品的实体类.
 * Created by apple on 16/9/27.
 */

public class CartBean {


    /**
     * error : 0
     * list : [{"thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/08/bXBuIXRUfgMrF5d32XruirZXduxD2R.png","id":"54","options":"标准规格","total":"1","marketprice":"1.00"},{"thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/08/FeHzPokoUVP55puIcVof05FO5oKjcj.png","id":"53","options":"2","total":"1","marketprice":"0.01"},{"thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/08/KSouGugcSAT4gz4fv1sW6w1A1oOzz4.png","id":"55","options":"红色+小+极品","total":"1","marketprice":"0.00"}]
     */

    private String error;
    /**
     * thumb : http://192.168.0.148/newokgo/resource/attachment/images/2016/08/bXBuIXRUfgMrF5d32XruirZXduxD2R.png
     * id : 54
     * options : 标准规格
     * total : 1
     * marketprice : 1.00
     */

    private List<ListBean> list;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String thumb;
        private String id;
        private String options;
        private String total;
        private String marketprice;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOptions() {
            return options;
        }

        public void setOptions(String options) {
            this.options = options;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getMarketprice() {
            return marketprice;
        }

        public void setMarketprice(String marketprice) {
            this.marketprice = marketprice;
        }
    }
}
