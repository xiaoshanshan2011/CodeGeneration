package bean;

import java.util.List;

/**
 * Created by chenjunshan on 9/22/17.
 */

public class StringBean {
    /**
     * log_id : 306637171
     * words_result : [{"words":"0●00中国移动合"},{"words":"1021AM"},{"words":"80%"},{"words":"应用"},{"words":"娱乐豆"},{"words":">"},{"words":"888.000"},{"words":"娱乐宝"},{"words":"上一期:201708258888259"},{"words":">"},{"words":"余额宝"},{"words":">"},{"words":"昨日收益:6.66元"},{"words":"奖"},{"words":"开奖期数"},{"words":"最新开奖:无"},{"words":">"},{"words":"回"},{"words":"首页"},{"words":"资产"},{"words":"应用"},{"words":"我的中心"}]
     * words_result_num : 22
     */

    private int log_id;
    private int words_result_num;
    private List<WordsResultBean> words_result;

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<WordsResultBean> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResultBean> words_result) {
        this.words_result = words_result;
    }

    public static class WordsResultBean {
        /**
         * words : 0●00中国移动合
         */

        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
