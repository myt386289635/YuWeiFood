package com.example.dllo.yuweifood.local;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dllo on 16/9/3.
 */
public class LocalBean {
    private static final String TAG = "LocalBean --> ***********";


    private DataBean data;

    private int is_array;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getIs_array() {
        return is_array;
    }

    public void setIs_array(int is_array) {
        this.is_array = is_array;
    }

    public static class DataBean {


        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String type;

            private Object content;
            private String title;
            private String subtitle;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getContent() {
                return content;
            }

            public void setContent(Object content) {
                this.content = content;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

        }
    }
}
