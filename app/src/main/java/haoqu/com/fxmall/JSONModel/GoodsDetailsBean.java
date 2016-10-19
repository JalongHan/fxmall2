package haoqu.com.fxmall.JSONModel;

import java.util.List;

/**
 * 商品详情
 * Created by apple on 16/10/13.
 */

public class GoodsDetailsBean {


    /**
     * error : 0
     * title : 测试商品1
     * thumb : http://192.168.0.148/newokgo/resource/attachment/images/2016/08/KSouGugcSAT4gz4fv1sW6w1A1oOzz4.png
     * productprice : 10.00
     * marketprice : 1.00
     * total : 2021
     * content : <p>这是商品详情</p><p><br/></p><p>1111<br/></p>
     * specs : [{"id":"1","title":"颜色","items":[{"id":"1","title":"红色","specid":"1","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/09/zckVFrcchZZk7vrHVgzvZVHf57fF55.jpg"},{"id":"2","title":"绿色","specid":"1","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/09/w29S8ouw15SRrc1g29RbH22og2U22S.jpg"}]},{"id":"2","title":"尺寸","items":[{"id":"3","title":"大","specid":"2","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/09/uDPnIND47K44PErxjDKYDKDUJPCdXP.jpg"},{"id":"4","title":"中","specid":"2","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/09/yNO5Z5f6DmRNvnMnTo10H51V1GnFOh.jpg"},{"id":"5","title":"小","specid":"2","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/09/Xtwi2zhi0miXmKT0It2m222lmmkKHK.jpg"}]},{"id":"4","title":"品质","items":[{"id":"8","title":"极品","specid":"4","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/09/P0JG1ZpGgZgedG3j2jQAE7Q5OQQ6jd.jpg"},{"id":"9","title":"普通","specid":"4","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/09/U4slNn757XX5mjT4njx7mNX7MJ77zx.jpg"},{"id":"10","title":"次品","specid":"4","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/09/BkqCKE1c14dd6d1Kk4EQQkqScDtwDn.jpg"}]}]
     * options : [{"id":"9","title":"绿色+中+普通","marketprice":"0.00","productprice":"0.00","stock":"0","specs":"2_4_9"},{"id":"10","title":"绿色+中+次品","marketprice":"0.00","productprice":"0.00","stock":"0","specs":"2_4_10"},{"id":"11","title":"绿色+小+极品","marketprice":"0.00","productprice":"0.00","stock":"0","specs":"2_5_8"},{"id":"12","title":"绿色+小+普通","marketprice":"0.00","productprice":"0.00","stock":"0","specs":"2_5_9"},{"id":"13","title":"绿色+小+次品","marketprice":"0.00","productprice":"0.00","stock":"0","specs":"2_5_10"},{"id":"14","title":"红色+大+极品","marketprice":"99.09","productprice":"0.00","stock":"21","specs":"1_3_8"},{"id":"15","title":"红色+大+普通","marketprice":"88.00","productprice":"0.00","stock":"-1","specs":"1_3_9"},{"id":"16","title":"红色+大+次品","marketprice":"0.01","productprice":"0.00","stock":"1970","specs":"1_3_10"},{"id":"17","title":"红色+中+极品","marketprice":"0.00","productprice":"0.00","stock":"2","specs":"1_4_8"},{"id":"18","title":"红色+中+普通","marketprice":"0.00","productprice":"0.00","stock":"3","specs":"1_4_9"},{"id":"19","title":"红色+中+次品","marketprice":"0.00","productprice":"0.00","stock":"5","specs":"1_4_10"},{"id":"20","title":"红色+小+极品","marketprice":"0.00","productprice":"0.00","stock":"6","specs":"1_5_8"},{"id":"21","title":"红色+小+普通","marketprice":"0.00","productprice":"0.00","stock":"6","specs":"1_5_9"},{"id":"22","title":"红色+小+次品","marketprice":"0.00","productprice":"0.00","stock":"9","specs":"1_5_10"},{"id":"23","title":"绿色+大+极品","marketprice":"0.00","productprice":"0.00","stock":"0","specs":"2_3_8"},{"id":"24","title":"绿色+大+普通","marketprice":"0.00","productprice":"0.00","stock":"0","specs":"2_3_9"},{"id":"25","title":"绿色+大+次品","marketprice":"0.00","productprice":"0.00","stock":"0","specs":"2_3_10"},{"id":"26","title":"绿色+中+极品","marketprice":"0.00","productprice":"0.00","stock":"0","specs":"2_4_8"}]
     */

    private int error;
    private String title;
    private String thumb;
    private String productprice;
    private String marketprice;
    private String total;
    private String content;
    /**
     * id : 1
     * title : 颜色
     * items : [{"id":"1","title":"红色","specid":"1","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/09/zckVFrcchZZk7vrHVgzvZVHf57fF55.jpg"},{"id":"2","title":"绿色","specid":"1","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/09/w29S8ouw15SRrc1g29RbH22og2U22S.jpg"}]
     */

    private List<SpecsBean> specs;
    /**
     * id : 9
     * title : 绿色+中+普通
     * marketprice : 0.00
     * productprice : 0.00
     * stock : 0
     * specs : 2_4_9
     */

    private List<OptionsBean> options;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(String marketprice) {
        this.marketprice = marketprice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<SpecsBean> getSpecs() {
        return specs;
    }

    public void setSpecs(List<SpecsBean> specs) {
        this.specs = specs;
    }

    public List<OptionsBean> getOptions() {
        return options;
    }

    public void setOptions(List<OptionsBean> options) {
        this.options = options;
    }

    public static class SpecsBean {
        private String id;
        private String title;
        /**
         * id : 1
         * title : 红色
         * specid : 1
         * thumb : http://192.168.0.148/newokgo/resource/attachment/images/2016/09/zckVFrcchZZk7vrHVgzvZVHf57fF55.jpg
         */

        private List<ItemsBean> items;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            private String id;
            private String title;
            private String specid;
            private String thumb;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSpecid() {
                return specid;
            }

            public void setSpecid(String specid) {
                this.specid = specid;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }
        }
    }

    public static class OptionsBean {
        private String id;
        private String title;
        private String marketprice;
        private String productprice;
        private String stock;
        private String specs;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMarketprice() {
            return marketprice;
        }

        public void setMarketprice(String marketprice) {
            this.marketprice = marketprice;
        }

        public String getProductprice() {
            return productprice;
        }

        public void setProductprice(String productprice) {
            this.productprice = productprice;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public String getSpecs() {
            return specs;
        }

        public void setSpecs(String specs) {
            this.specs = specs;
        }
    }
}
