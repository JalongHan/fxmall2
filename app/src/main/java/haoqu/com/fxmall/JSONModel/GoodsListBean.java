package haoqu.com.fxmall.JSONModel;

import java.util.List;

/**
 * 商城页面返回的数据
 * Created by apple on 16/9/20.
 */
public class GoodsListBean {


    /**
     * error : 0
     * type : list
     * list : [{"id":"1","name":"测试分类1","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/01/g8pp3cc83p9t9Z99hM9dM90b399DdH.png","children":[{"id":"3","name":"测试子分类1","thumb":"http://192.168.0.148/newokgo/resource/attachment/"},{"id":"4","name":"测试子分类2","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/01/a75cR3UicSVy3vci5WCcchK05XsY2C.png"}]},{"id":"2","name":"测试分类2","thumb":"http://192.168.0.148/newokgo/resource/attachment/","children":[{"id":"6","name":"4个字啊","thumb":"http://192.168.0.148/newokgo/resource/attachment/"}]},{"id":"7","name":"测试分类333","thumb":"http://192.168.0.148/newokgo/resource/attachment/"},{"id":"8","name":"fffffff","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/03/u72dgUZ2ugmdDP762kNod7PGu26Udp.png"}]
     */

    private String error;
    private String type;
    /**
     * id : 1
     * name : 测试分类1
     * thumb : http://192.168.0.148/newokgo/resource/attachment/images/2016/01/g8pp3cc83p9t9Z99hM9dM90b399DdH.png
     * children : [{"id":"3","name":"测试子分类1","thumb":"http://192.168.0.148/newokgo/resource/attachment/"},{"id":"4","name":"测试子分类2","thumb":"http://192.168.0.148/newokgo/resource/attachment/images/2016/01/a75cR3UicSVy3vci5WCcchK05XsY2C.png"}]
     */

    private List<ListBean> list;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String id;
        private String name;
        private String thumb;
        /**
         * id : 3
         * name : 测试子分类1
         * thumb : http://192.168.0.148/newokgo/resource/attachment/
         */

        private List<ChildrenBean> children;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }




        /**
         *  获取Item内容
         * @param pPosition
         * @return
         */
        public Object getItem(int pPosition) {
            // 标题排在第一位
            if (pPosition == 0) {
                return name;
            }  else  {
                return children.get(pPosition - 1);
            }
        }

        public static class ChildrenBean {
            private String id;
            private String name;
            private String thumb;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }
        }
    }
}
