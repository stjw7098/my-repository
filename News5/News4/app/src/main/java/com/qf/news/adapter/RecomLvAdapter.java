package com.qf.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;
import com.facebook.drawee.view.SimpleDraweeView;
import com.qf.news.R;
import com.qf.news.ShowNewsActivity;
import com.qf.news.model.Care;
import com.qf.news.model.MyUser;
import com.qf.news.model.NewsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobRelation;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Administrator on 2016/10/22 0022.
 */
public class RecomLvAdapter extends BaseAdapter implements GlideModule{

    private static final String TAG = "test";
    private final LayoutInflater inflater;
    int[] heads = new int[]{R.mipmap.head1, R.mipmap.head3};
    Context context;
    private View view;
    List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist=new ArrayList<>();

    private Holder holder;

    public RecomLvAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setContentlist(List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist) {
        this.contentlist = contentlist;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return contentlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.recommend_item, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }else{
            holder=((Holder) convertView.getTag());
        }
        Log.e(TAG, "position: "+position );

        final String title = contentlist.get(position).getTitle();
        final String pubDate = contentlist.get(position).getPubDate();
        String source = contentlist.get(position).getSource();
        final String link = contentlist.get(position).getLink();
        String imageUrl = null;

        if(contentlist.get(position).getImageurls().size()>0){

            Log.e(TAG, "有图: " );
            holder.sdv2.setVisibility(View.VISIBLE);
             imageUrl= contentlist.get(position).getImageurls().get(0).getUrl();

            Glide.with(context).load(Uri.parse(imageUrl)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.sdv2);
            holder.sdv.setImageURI(imageUrl);
//            holder.sdv2.setImageURI(imageUrl);
        }
//        else {

//            holder.sdv2.setVisibility(View.GONE);
//            Log.e(TAG, "无图: " );
//            int imageId = heads[new Random().nextInt(2)];
//            holder.sdv.setBackgroundResource(imageId);
//        }

        holder.tvTitile.setText(title);
        holder.tvAuthor.setText(pubDate);

       holder.llRoot.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, ShowNewsActivity.class);
               Log.e(TAG, "onClick: "+position );
               intent.putExtra("link", link);
               context.startActivity(intent);
           }
       });

        final String finalImageUrl = imageUrl;
        holder.tvCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MyUser user = MyUser.getCurrentUser(MyUser.class);
//
//                Care post = new Care();
//                post.setDate(pubDate);
//
//                post.save(new SaveListener<String>() {
//
//                    @Override
//                    public void done(String objectId,BmobException e) {
//                        if(e==null){
//                            Log.i("bmob","保存成功");
//                        }else{
//                            Log.i("bmob","保存失败："+e.getMessage());
//                        }
//                    }
//                });

                final MyUser user = MyUser.getCurrentUser(MyUser.class);
                final Care care = new Care();
                care.setDate(pubDate);
                care.setTitle(title);
                care.setUrl(link);
                care.setImage(finalImageUrl);


                BmobQuery<Care> query = new BmobQuery<Care>();
                //查询playerName叫“比目”的数据
                query.addWhereEqualTo("url",link);
                //返回50条数据，如果不加上这条语句，默认返回10条数据
                query.setLimit(50);
                //执行查询方法
                query.findObjects(new FindListener<Care>() {
                    @Override
                    public void done(List<Care> object, BmobException e) {
                        if(e==null){
                            if(object!=null&&object.size()>0){
                                sameNews(object);

                            }else{
                                noSameNews(user, care);
                                Log.e(TAG, "noSameNews: " );
                            }

                        }else{
                            Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                        }
                    }
                });




            }
        });


        return convertView;
    }

    private void sameNews(List<Care> object) {
        String objectId=object.get(0).getObjectId();

        Care care = new Care();
        care.setObjectId(objectId);
        //将用户B添加到Post表中的likes字段值中，表明用户B喜欢该帖子
        BmobRelation relation = new BmobRelation();
        //构造用户B
        String userId = (String) BmobUser.getObjectByKey("objectId");
        MyUser user = new MyUser();
        user.setObjectId(userId);
        //将用户B添加到多对多关联中
        relation.add(user);
        //多对多关联指向`post`的`likes`字段
        care.setLikes(relation);
        care.update(new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if(e==null){
                    Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "收藏失败", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void noSameNews(final MyUser user, final Care care) {
        care.save(new SaveListener<String>() {

            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    Log.i("bmob","保存成功");
                    saveCare(user, care,objectId);
                }else{
                    Log.i("bmob","保存失败："+e.getMessage());
                }
            }
        });
    }

    private void saveCare(MyUser user, Care care,String objectId) {
        care.setObjectId(objectId);
        //将当前用户添加到Post表中的likes字段值中，表明当前用户喜欢该帖子
        BmobRelation relation = new BmobRelation();
        //将当前用户添加到多对多关联中
        relation.add(user);
        //多对多关联指向`post`的`likes`字段
        care.setLikes(relation);
        care.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // set size & external vs. internal
        int cacheSize100MegaBytes = 104857600;

//            builder.setDiskCache(
//                    new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes)
//            );

    //    String downloadDirectoryPath = Environment.getDownloadCacheDirectory().getPath();
        String downloadDirectoryPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath();
        builder.setDiskCache(
                new DiskLruCacheFactory( downloadDirectoryPath, cacheSize100MegaBytes )
        );

        //builder.setDiskCache(
        //new ExternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }

    static class Holder {
        @BindView(R.id.tv_titile)
        TextView tvTitile;
        @BindView(R.id.sdv)
        SimpleDraweeView sdv;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.tv_care)
        TextView tvCare;
        @BindView(R.id.sdv2)
        ImageView sdv2;
        @BindView(R.id.llRoot)
        LinearLayout llRoot;
        @BindView(R.id.cardview)
        CardView cardview;

        Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
