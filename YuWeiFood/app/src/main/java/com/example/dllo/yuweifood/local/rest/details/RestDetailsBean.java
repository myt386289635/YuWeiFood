package com.example.dllo.yuweifood.local.rest.details;

import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class RestDetailsBean {
    private static final String TAG = "RestDetailsBean --> ***********";

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
        private int has_more;
        private int offset;


        private RestinfoBean restinfo;

        private List<ListBean> list;

        public int getHas_more() {
            return has_more;
        }

        public void setHas_more(int has_more) {
            this.has_more = has_more;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public RestinfoBean getRestinfo() {
            return restinfo;
        }

        public void setRestinfo(RestinfoBean restinfo) {
            this.restinfo = restinfo;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class RestinfoBean {
            private String id;
            private String lng;
            private String lat;
            private String cityid;
            private String phone;
            private int in_china;
            private String name;
            private String name_origin;
            private String address;
            private String address_origin;
            private String open_time;
            private String type;
            private String sum;
            private String reason;
            private String desc;
            private String keyword;
            private String cost;
            private List<String> phones;
            private List<String> imgs;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getCityid() {
                return cityid;
            }

            public void setCityid(String cityid) {
                this.cityid = cityid;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public int getIn_china() {
                return in_china;
            }

            public void setIn_china(int in_china) {
                this.in_china = in_china;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getName_origin() {
                return name_origin;
            }

            public void setName_origin(String name_origin) {
                this.name_origin = name_origin;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAddress_origin() {
                return address_origin;
            }

            public void setAddress_origin(String address_origin) {
                this.address_origin = address_origin;
            }

            public String getOpen_time() {
                return open_time;
            }

            public void setOpen_time(String open_time) {
                this.open_time = open_time;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSum() {
                return sum;
            }

            public void setSum(String sum) {
                this.sum = sum;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getCost() {
                return cost;
            }

            public void setCost(String cost) {
                this.cost = cost;
            }

            public List<String> getPhones() {
                return phones;
            }

            public void setPhones(List<String> phones) {
                this.phones = phones;
            }

            public List<String> getImgs() {
                return imgs;
            }

            public void setImgs(List<String> imgs) {
                this.imgs = imgs;
            }
        }

        public static class ListBean {
            private String id;
            private String name;
            private String name_origin;
            private String summary;
            private String restid;
            private String cover;

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

            public String getName_origin() {
                return name_origin;
            }

            public void setName_origin(String name_origin) {
                this.name_origin = name_origin;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getRestid() {
                return restid;
            }

            public void setRestid(String restid) {
                this.restid = restid;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }
        }
    }
}
