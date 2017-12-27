package bean;

import java.util.List;

/**
 * Created by chenjunshan on 9/7/17.
 */

public class FgBean {
	/**
     * pakege : com.sanbao
     * author : chenjunshan
     * data : [{"path":"fragment/tab1","menu":[{"isList":false,"title":"娱乐豆","name":"yld"},{"isList":false,"title":"娱乐宝","name":"ylb"}]},{"path":"fragment/tab2","menu":[{"isList":false,"title":"娱乐豆","name":"yld"},{"isList":false,"title":"娱乐宝","name":"ylb"}]}]
     */

    private String pakege;
    private String author;
    private List<DataBean> data;

    public String getPakege() {
        return pakege;
    }

    public void setPakege(String pakege) {
        this.pakege = pakege;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * path : fragment/tab1
         * menu : [{"isList":false,"title":"娱乐豆","name":"yld"},{"isList":false,"title":"娱乐宝","name":"ylb"}]
         */

        private String path;
        private List<MenuBean> menu;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public List<MenuBean> getMenu() {
            return menu;
        }

        public void setMenu(List<MenuBean> menu) {
            this.menu = menu;
        }

        public static class MenuBean {
            /**
             * isList : false
             * title : 娱乐豆
             * name : yld
             */

            private boolean isList;
            private String title;
            private String name;

            public boolean isIsList() {
                return isList;
            }

            public void setIsList(boolean isList) {
                this.isList = isList;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
