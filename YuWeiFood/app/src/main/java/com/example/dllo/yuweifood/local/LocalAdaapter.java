package com.example.dllo.yuweifood.local;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapTouchListener;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.local.dish.DishAdapter;
import com.example.dllo.yuweifood.local.map.MapAdapter;
import com.example.dllo.yuweifood.local.map.sec.MapActivity;
import com.example.dllo.yuweifood.local.map.sec.mapfragment.MapFragment;
import com.example.dllo.yuweifood.local.note.NoteAdapter;
import com.example.dllo.yuweifood.local.rest.RestAdapter;
import com.example.dllo.yuweifood.local.strategy.StrategyAdapter;
import com.example.dllo.yuweifood.tool.MyGridView;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/9/3.
 */
public class LocalAdaapter extends RecyclerView.Adapter {
    private static final String TAG = "LocalAdaapter --> ***********";

    private Context mContext;
    private LocalBean mBean;

    public LocalAdaapter(Context context) {
        mContext = context;
    }

    public void setBean(LocalBean bean) {
        mBean = bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder holder = null;

        switch (viewType){
            case 0:

                View headView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_head_item,parent,false);
                holder = new HeadViewHolder(headView);

                break;

            case 1:

                View mapView  =  LayoutInflater.from(mContext).inflate(R.layout.local_fragment_map_item,parent,false);
                holder = new MapViewHolder(mapView);

                break;
            case 2:

                View strategyView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_strategy_item,parent,false);
                holder = new StrategyViewHolder(strategyView);

                break;
            case 3:

                View dishView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_dish_item,parent,false);
                holder = new DishViewHolder(dishView);

                break;

            case 4:

                View restView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_rest_item,parent,false);
                holder = new RestViewHolder(restView);

                break;

            case 5:

                View noteView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_note_item,parent,false);
                holder = new NoteViewHolder(noteView);

                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int type = getItemViewType(position);

        switch (type){

            case 0:

                HeadViewHolder headViewHolder = (HeadViewHolder) holder;
                Object content = mBean.getData().getList().get(position).getContent();
                if(content instanceof Map){

                    Map<String,String> map  = (Map<String, String>) content;
                    Glide.with(mContext).load(map.get("cover")).into(headViewHolder.mImageView);
                }

                break;
            case 1:

                MapViewHolder mapViewHolder = (MapViewHolder) holder;
                mapViewHolder.mAdapter.setBean(mBean);
                mapViewHolder.mMyGridView.setAdapter(mapViewHolder.mAdapter);

                mapViewHolder.mBaiduMap = mapViewHolder.mMapView.getMap();

                Object content_map = mBean.getData().getList().get(position).getContent();

                if(content_map instanceof List){
                    List<Map<String,String>> local = (List<Map<String, String>>) content_map;
                    //设置地图启动后的默认位置
                    LatLng cenpt = new LatLng(Double.parseDouble(local.get(1).get("lat")),Double.parseDouble(local.get(1).get("lng")));
                    MapStatus mMapStatus = new MapStatus.Builder()
                            .target(cenpt).zoom(13).build();
                    MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
                    mapViewHolder.mBaiduMap.setMapStatus(mMapStatusUpdate);

                    for (int i = 0; i < local.size(); i++) {
                        if(i == 0){
                            mapViewHolder.setMap(Double.parseDouble(local.get(i).get("lat")),Double.parseDouble(local.get(i).get("lng")),R.mipmap.loc_1);
                        }else if(i == 1){
                            mapViewHolder.setMap(Double.parseDouble(local.get(i).get("lat")),Double.parseDouble(local.get(i).get("lng")),R.mipmap.loc_2);
                        }else if(i == 2){
                            mapViewHolder.setMap(Double.parseDouble(local.get(i).get("lat")),Double.parseDouble(local.get(i).get("lng")),R.mipmap.loc_3);
                        }else {
                            mapViewHolder.setMap(Double.parseDouble(local.get(i).get("lat")),Double.parseDouble(local.get(i).get("lng")),R.mipmap.rest_unselect);
                        }
                    }

                }

                mapViewHolder.mBaiduMap.setOnMapTouchListener(new OnMapTouchListener() {
                    @Override
                    public void onTouch(MotionEvent motionEvent) {
                        switch (motionEvent.getAction()){
                            case MotionEvent.ACTION_DOWN:
                                Intent intent = new Intent(mContext, MapActivity.class);
                                mContext.startActivity(intent);
                                break;
                        }
                    }
                });

                UiSettings settings=mapViewHolder.mBaiduMap.getUiSettings();
                settings.setAllGesturesEnabled(false);   //关闭一切手势操作

                break;
            case 2:

                StrategyViewHolder strategyViewHolder = (StrategyViewHolder) holder;
                strategyViewHolder.title.setText(mBean.getData().getList().get(position).getTitle());
                strategyViewHolder.mAdapter.setBean(mBean);
                strategyViewHolder.mMyGridView.setAdapter(strategyViewHolder.mAdapter);

                break;
            case 3:

                final DishViewHolder dishViewHolder = (DishViewHolder) holder;
                dishViewHolder.title.setText(mBean.getData().getList().get(position).getTitle());
                dishViewHolder.mAdapter.setBean(mBean);
                dishViewHolder.mMyGridView.setAdapter(dishViewHolder.mAdapter);
                dishViewHolder.shown.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(dishViewHolder.user){
                            dishViewHolder.mAdapter.setInShown(true);
                            dishViewHolder.user = false;
                            dishViewHolder.shown.setText("已经全部展开,可收回!");
                        }else {
                            dishViewHolder.mAdapter.setInShown(false);
                            dishViewHolder.user  = true;
                            dishViewHolder.shown.setText("展开全部4道特色菜");
                        }

                    }
                });

                break;

            case 4:

                RestViewHolder restViewHolder = (RestViewHolder) holder;
                restViewHolder.title.setText(mBean.getData().getList().get(position).getTitle());
                restViewHolder.mAdapter.setBean(mBean);
                restViewHolder.mMyGridView.setAdapter(restViewHolder.mAdapter);

                break;

            case 5:

                NoteViewHolder noteViewHolder = (NoteViewHolder) holder;
                noteViewHolder.title.setText(mBean.getData().getList().get(position).getTitle());
                noteViewHolder.mNoteAdapter.setBean(mBean);
                noteViewHolder.mMyGridView.setAdapter(noteViewHolder.mNoteAdapter);

                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mBean.getData().getList().size();
    }

    //第一个holder
    class HeadViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;
        public HeadViewHolder(View itemView) {
            super(itemView);
            mImageView  = (ImageView) itemView.findViewById(R.id.local_fragment_head_item_image);
        }
    }

    //第二个holder
    class MapViewHolder extends RecyclerView.ViewHolder{

        private MyGridView mMyGridView;
        private MapAdapter mAdapter;
        private MapView mMapView;
        private RelativeLayout mLayout;
        private BaiduMap mBaiduMap;
        private OverlayOptions mOption;

        public MapViewHolder(View itemView) {
            super(itemView);
            mMyGridView = (MyGridView) itemView.findViewById(R.id.local_fragment_map_item_gridView);
            mAdapter = new MapAdapter(mContext);
            mLayout = (RelativeLayout) itemView.findViewById(R.id.local_fragment_map_item_map);

            BaiduMapOptions options = new BaiduMapOptions();
            options.zoomControlsEnabled(false);
            options.scaleControlEnabled(false);
            mMapView = new MapView(mContext, options);
            RelativeLayout.LayoutParams params_map = new RelativeLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            mLayout.addView(mMapView, params_map);

            //显示定为后的当前位置latitude为x longitude为Y
//            LatLng p = new LatLng(latitude,longitude);
//            MapStatus mMapStatus = new MapStatus.Builder().target(p).zoom(18)
//                    .build();
//            MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory
//                    .newMapStatus(mMapStatus);

//            mBaiduMap = mMapView.getMap();
//            mBaiduMap.setMapStatus(mMapStatusUpdate);
        }

        //设置位置点
        public void setMap(Double x,Double y,int id){
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
            mBaiduMap.addOverlay(mOption);
        }

    }

    //第三个holder
    class StrategyViewHolder extends RecyclerView.ViewHolder{

        private MyGridView mMyGridView;
        private TextView title;
        private StrategyAdapter mAdapter;

        public StrategyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.local_fragment_strategy_item_title);
            mMyGridView = (MyGridView) itemView.findViewById(R.id.local_fragment_strategy_item_gridview);
            mAdapter = new StrategyAdapter(mContext);
        }
    }

    class DishViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView shown;
        private MyGridView mMyGridView;
        private DishAdapter mAdapter;
        private Boolean user = true;//判断是否是第一次点击

        public DishViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.local_fragment_dish_item_title);
            shown = (TextView) itemView.findViewById(R.id.local_fragment_dish_item_shown);
            mMyGridView = (MyGridView) itemView.findViewById(R.id.local_fragment_dish_item_gridview);
            mAdapter = new DishAdapter(mContext);
        }
    }

    class RestViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private MyGridView mMyGridView;
        private RestAdapter mAdapter;

        public RestViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.local_fragment_rest_item_title);
            mAdapter = new RestAdapter(mContext);
            mMyGridView = (MyGridView) itemView.findViewById(R.id.local_fragment_rest_item_gridview);
        }
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private MyGridView mMyGridView;
        private NoteAdapter mNoteAdapter;

        public NoteViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.local_fragment_note_item_title);
            mMyGridView = (MyGridView) itemView.findViewById(R.id.local_fragment_note_item_gridview);
            mNoteAdapter = new NoteAdapter(mContext);
        }
    }
}
