package com.wenjian.loopbannerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.wenjian.loopbanner.LoopAdapter;
import com.wenjian.loopbanner.LoopBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ${bruce}
 * @project: LoopBanner-master
 * @package: com.wenjian.loopbannerdemo
 * @description:
 * @date: 2019/7/5
 * @time: 16:10
 */
public class TestActivity extends AppCompatActivity
{
    private String TAG = "TestActivity";
    LoopBanner mLoopBanner;
    private List<BannerEntity> mData=new ArrayList<>();
    private LoopAdapter myAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mLoopBanner=findViewById(R.id.lb_test);

        mData.add(new BannerEntity(0,"http://www.wanandroid.com/blogimgs/ab17e8f9-6b79-450b-8079-0f2287eb6f0f.png","1看看别人的面经，搞定面试"));
        mData.add(new BannerEntity(1,"http://www.wanandroid.com/blogimgs/fb0ea461-e00a-482b-814f-4faca5761427.png","2兄弟，要不要挑个项目学习下"));
        mData.add(new BannerEntity(2,"http://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png","3我们新增了一个常用导航Tab~"));
        mData.add(new BannerEntity(0,"http://www.wanandroid.com/blogimgs/00f83f1d-3c50-439f-b705-54a49fc3d90d.jpg","4公众号文章列表强势上线"));

        //滑动
        mLoopBanner.setOnPageSelectListener(new LoopBanner.OnPageSelectListener() {
            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected"+position);
            }
        });

        //自定义布局
         myAdapter= new LoopAdapter<BannerEntity>(mData, R.layout.lay_banner_test_item) {
             @Override
            protected void onBindView(final ViewHolder holder, BannerEntity data, final int position) {
                ImageView mImageView = holder.getView(R.id.iv_image);
//                        Glide.with(holder.getContext()).load(data.getUrl()).into(mImageView);
                 //网关，智能锁
                 switch (data.getId()) {
                     case 0:
                         mImageView.setImageResource(R.mipmap.ic_main_device_add);
                         break;
                     case 1:
                         mImageView.setImageResource(R.mipmap.ic_main_devce_gateway);
                         break;
                     case 2:
                         mImageView.setImageResource(R.mipmap.ic_main_device_lock);
                         break;
                 }

                holder.setText(R.id.tv_title,data.getTitle());


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(holder.getContext(), "position"+position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        mLoopBanner.setAdapter(myAdapter);
        mLoopBanner.setAutoLoop(false);

//        mLoopBanner.forceStop();
//        mLoopBanner.enableIndicator(false);

    }

    @Override
    protected void onStart() {
        super.onStart();
        myAdapter.setNewData(mData);
        mLoopBanner.setCurrentItem(2);
    }

    //    public class MyAdapter extends LoopAdapter<BannerEntity>{
//
//        @Override
//        protected void onBindView(ViewHolder holder, BannerEntity data, int position) {
//
//        }
//    }
}
