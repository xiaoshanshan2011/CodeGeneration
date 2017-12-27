package bean;

import java.util.List;

/**
 * Created by chenjunshan on 9/6/17.
 */

public class UrlBean {
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 全球资产配置钱包
         * url : api/ReGlbWallet
         */

        private String name;
        private String url;
        private String type;
       
     
        public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
