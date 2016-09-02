package com.example.dllo.yuweifood.food.hot;

import java.util.List;

/**
 * Created by dllo on 16/9/1.
 */
public class HotBean {
    private static final String TAG = "HotBean --> ***********";

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
        private int offset;
        private int has_more;
        /**
         * id : 12846
         * name : #暑你最会浪#
         * url : http://www.youyuwei.com/note/activity/activityshujia
         * isFavour : 0
         * isCollect : 0
         * cover : http://cdn.youyuwei.com/o_1aqrdpo8j18efqm71fjj1apo5jlf.jpg?imageView2/1/w/1080/h/1080
         * city :
         * rest :
         * time : 1471410928
         * vote : 561
         * fav : 116
         * plnum : 50
         * imgnum : 4
         * readnum : 9425
         * text :
         * author : {"uid":"10258","uname":"味道君","header":"http://cdn.youyuwei.com/9C13E4B15E9F7B22D57F2E8DDA5AF409.jpg","gender":"1","location":"","desc":"","score":"614","v":"0","vname":"","url":"yuwei://user/10258","label":"","level":"7"}
         * type : note
         */

        private List<ListBean> list;

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getHas_more() {
            return has_more;
        }

        public void setHas_more(int has_more) {
            this.has_more = has_more;
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
            private String url;
            private String isFavour;
            private String isCollect;
            private String cover;
            private String city;
            private String rest;
            private int time;
            private int vote;
            private int fav;
            private int plnum;
            private int imgnum;
            private int readnum;
            private String text;
            /**
             * uid : 10258
             * uname : 味道君
             * header : http://cdn.youyuwei.com/9C13E4B15E9F7B22D57F2E8DDA5AF409.jpg
             * gender : 1
             * location :
             * desc :
             * score : 614
             * v : 0
             * vname :
             * url : yuwei://user/10258
             * label :
             * level : 7
             */

            private AuthorBean author;
            private String type;

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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getIsFavour() {
                return isFavour;
            }

            public void setIsFavour(String isFavour) {
                this.isFavour = isFavour;
            }

            public String getIsCollect() {
                return isCollect;
            }

            public void setIsCollect(String isCollect) {
                this.isCollect = isCollect;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getRest() {
                return rest;
            }

            public void setRest(String rest) {
                this.rest = rest;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public int getVote() {
                return vote;
            }

            public void setVote(int vote) {
                this.vote = vote;
            }

            public int getFav() {
                return fav;
            }

            public void setFav(int fav) {
                this.fav = fav;
            }

            public int getPlnum() {
                return plnum;
            }

            public void setPlnum(int plnum) {
                this.plnum = plnum;
            }

            public int getImgnum() {
                return imgnum;
            }

            public void setImgnum(int imgnum) {
                this.imgnum = imgnum;
            }

            public int getReadnum() {
                return readnum;
            }

            public void setReadnum(int readnum) {
                this.readnum = readnum;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public static class AuthorBean {
                private String uid;
                private String uname;
                private String header;
                private String gender;
                private String location;
                private String desc;
                private String score;
                private String v;
                private String vname;
                private String url;
//                private Object label;
                private String level;

//                public Object getLabel() {
//                    return label;
//                }
//
//                public void setLabel(Object label) {
//                    this.label = label;
//                }

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public String getUname() {
                    return uname;
                }

                public void setUname(String uname) {
                    this.uname = uname;
                }

                public String getHeader() {
                    return header;
                }

                public void setHeader(String header) {
                    this.header = header;
                }

                public String getGender() {
                    return gender;
                }

                public void setGender(String gender) {
                    this.gender = gender;
                }

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getScore() {
                    return score;
                }

                public void setScore(String score) {
                    this.score = score;
                }

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getVname() {
                    return vname;
                }

                public void setVname(String vname) {
                    this.vname = vname;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

//

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }
            }
        }
    }
}
