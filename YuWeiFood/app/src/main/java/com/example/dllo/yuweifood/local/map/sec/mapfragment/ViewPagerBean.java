package com.example.dllo.yuweifood.local.map.sec.mapfragment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dllo on 16/9/5.
 */
public class ViewPagerBean implements Parcelable{
    private static final String TAG = "ViewPagerBean --> ***********";
    private String image;
    private String name,price,content;

    public ViewPagerBean(String image, String name, String price, String content) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.content = content;
    }

    protected ViewPagerBean(Parcel in) {
        image = in.readString();
        name = in.readString();
        price = in.readString();
        content = in.readString();
    }

    public static final Creator<ViewPagerBean> CREATOR = new Creator<ViewPagerBean>() {
        @Override
        public ViewPagerBean createFromParcel(Parcel in) {
            return new ViewPagerBean(in);
        }

        @Override
        public ViewPagerBean[] newArray(int size) {
            return new ViewPagerBean[size];
        }
    };

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(name);
        dest.writeString(price);
        dest.writeString(content);
    }
}
