package com.example.dllo.yuweifood.local.map.sec.mapfragment;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapTouchListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;
import com.example.dllo.yuweifood.tool.Values;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/5.
 */
public class MapFragment extends BaseFragment implements OnClickListener, OnPageChangeListener {
    private static final String TAG = "MapFragment --> ***********";


    private ViewPager mViewPager;
    private SecMapAdapter mAdapter;
    private List<ViewPagerBean> mList;

    private TextView all, local, northFood, seafood, japanFood, tese, xican, zizhu, bar, dessert, barbecue, xiangcai, hangbangcai, shangwu, oneself, person, family, team;
    private TextView[] mTextViews = {all, local, northFood, seafood, japanFood, tese, xican, zizhu, bar, dessert, barbecue, xiangcai, hangbangcai, shangwu, oneself, person, family, team};
    private Integer[] ids = {R.id.activity_map_fragment_all, R.id.activity_map_fragment_local, R.id.activity_map_fragment_northFood, R.id.activity_map_fragment_seafood, R.id.activity_map_fragment_japanFood, R.id.activity_map_fragment_tese, R.id.activity_map_fragment_xican, R.id.activity_map_fragment_zizhu, R.id.activity_map_fragment_bar, R.id.activity_map_fragment_dessert, R.id.activity_map_fragment_barbecue, R.id.activity_map_fragment_xiangcai, R.id.activity_map_fragment_hangbangcai, R.id.activity_map_fragment_shangwu, R.id.activity_map_fragment_oneself, R.id.activity_map_fragment_person, R.id.activity_map_fragment_family, R.id.activity_map_fragment_team};

    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private OverlayOptions mOption;
    private Marker mMarker;

    private List<Marker> mMarkers;
    private SecMapBean mBean;
    private Integer position;
    private InfoWindow mMInfoWindow;

    @Override
    protected int initLayout() {
        return R.layout.map_fragment;
    }

    @Override
    protected void initView(View view) {


        mViewPager = (ViewPager) view.findViewById(R.id.activity_map_fragment_viewPager);

        for (int i = 0; i < ids.length; i++) {
            mTextViews[i] = (TextView) view.findViewById(ids[i]);
        }

        mMapView = (MapView) view.findViewById(R.id.activity_map_fragment_mapview);
    }

    @Override
    protected void initData() {

        mMarkers = new ArrayList<>();
        mBaiduMap = mMapView.getMap();

        mViewPager.setPageMargin(40);
        ansys(0);
        mTextViews[0].setTextColor(0xffffa12c);
        for (int i = 0; i < ids.length; i++) {
            mTextViews[i].setOnClickListener(this);
        }

        mViewPager.addOnPageChangeListener(this);

        mBaiduMap.setOnMapTouchListener(new OnMapTouchListener() {
            @Override
            public void onTouch(MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:

                        if(mMInfoWindow != null){
                            mBaiduMap.hideInfoWindow();
                        }

                        break;
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        for (int i = 0; i < mTextViews.length; i++) {
            if (v.getId() == ids[i]) {
                mTextViews[i].setTextColor(0xffffa12c);
                ansys(i);
            } else {
                mTextViews[i].setTextColor(0xffc1c1c1);
            }
        }
    }

    public void ansys(final int pos) {

        //移除以前的marker.重新定位
        if (mMarkers.size() != 0 && mMarkers != null) {
            for (Marker marker : mMarkers) {
                marker.remove();
            }
        }

        mList = new ArrayList<>();
        mAdapter = new SecMapAdapter(context);
        NetTool.getInstance().startRequest(Values.Sec_MapActivity_url, SecMapBean.class, new onHttpCallBack<SecMapBean>() {
            @Override
            public void onSuccess(SecMapBean response) {

                mBean = response;
                position = pos;

                //设置地图启动后的默认位置
                LatLng cenpt = new LatLng(Double.parseDouble(response.getData().getList().get(pos).getRestlist().getList().get(0).getLat()), Double.parseDouble(response.getData().getList().get(pos).getRestlist().getList().get(0).getLng()));
                MapStatus mMapStatus = new MapStatus.Builder()
                        .target(cenpt).zoom(13).build();
                MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
                mBaiduMap.setMapStatus(mMapStatusUpdate);

                for (int i = 0; i < response.getData().getList().get(pos).getRestlist().getList().size(); i++) {
                    mList.add(new ViewPagerBean(response.getData().getList().get(pos).getRestlist().getList().get(i).getCover(), response.getData().getList().get(pos).getRestlist().getList().get(i).getName(), response.getData().getList().get(pos).getRestlist().getList().get(i).getCost(), response.getData().getList().get(pos).getRestlist().getList().get(i).getSummary()));
                    if (i == 0) {
                        setMap(Double.parseDouble(response.getData().getList().get(pos).getRestlist().getList().get(i).getLat()), Double.parseDouble(response.getData().getList().get(pos).getRestlist().getList().get(i).getLng()), R.mipmap.rest_select, i);
                    } else {
                        setMap(Double.parseDouble(response.getData().getList().get(pos).getRestlist().getList().get(i).getLat()), Double.parseDouble(response.getData().getList().get(pos).getRestlist().getList().get(i).getLng()), R.mipmap.rest_unselect, i);
                    }
                }
                mAdapter.setList(mList);
                mViewPager.setAdapter(mAdapter);


            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }

    public void setMap(Double x, Double y, final int id, final int pos) {
        //定义Maker坐标点
        LatLng point = new LatLng(x, y);
        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(id);
        //构建MarkerOption，用于在地图上添加Marker
        mOption = new MarkerOptions().position(point).icon(bitmap);
//        options.zoomControlsEnabled(false);
//        options.scaleControlEnabled(false);
        //在地图上添加Marker，并显示
        mMarker = (Marker) mBaiduMap.addOverlay(mOption);
        mMarkers.add(mMarker);

        mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
//
                if (id == R.mipmap.rest_select) {
                    //创建InfoWindow展示的view
                    View view = LayoutInflater.from(context).inflate(R.layout.map_popup, null);
                    TextView textView = (TextView) view.findViewById(R.id.map_popup_text);
                    TextView name = (TextView) view.findViewById(R.id.map_popup_name);
                    name.setText(mBean.getData().getList().get(position).getRestlist().getList().get(pos).getName() + ":");
                    textView.setText(mBean.getData().getList().get(position).getRestlist().getList().get(pos).getAddress());
                    //定义用于显示该InfoWindow的坐标点
                    LatLng pt = new LatLng(marker.getPosition().latitude, marker.getPosition().longitude);
                    //创建InfoWindow , 传入 view， 地理坐标， y 轴偏移量
                    mMInfoWindow = new InfoWindow(view, pt, -47);
                    //显示InfoWindow
                    mBaiduMap.showInfoWindow(mMInfoWindow);

                }
                return false;
            }
        });


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //改变地图位置
        LatLng cenpt = new LatLng(Double.parseDouble(mBean.getData().getList().get(this.position).getRestlist().getList().get(position).getLat()), Double.parseDouble(mBean.getData().getList().get(this.position).getRestlist().getList().get(position).getLng()));
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(cenpt).zoom(13).build();
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        mBaiduMap.setMapStatus(mMapStatusUpdate);

        //移除以前的marker.重新定位
        if (mMarkers.size() != 0 && mMarkers != null) {
            for (Marker marker : mMarkers) {
                marker.remove();
            }
        }

        for (int i = 0; i < mBean.getData().getList().get(this.position).getRestlist().getList().size(); i++) {
            if (i == position) {
                setMap(Double.parseDouble(mBean.getData().getList().get(this.position).getRestlist().getList().get(i).getLat()), Double.parseDouble(mBean.getData().getList().get(this.position).getRestlist().getList().get(i).getLng()), R.mipmap.rest_select, i);
            } else {
                setMap(Double.parseDouble(mBean.getData().getList().get(this.position).getRestlist().getList().get(i).getLat()), Double.parseDouble(mBean.getData().getList().get(this.position).getRestlist().getList().get(i).getLng()), R.mipmap.rest_unselect, i);
            }
        }

        if(mMInfoWindow != null){
            mBaiduMap.hideInfoWindow();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
