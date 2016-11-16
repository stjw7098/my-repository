package com.qf.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.qf.news.R;
import com.qf.news.ShowNewsActivity;
import com.qf.news.SurfaceActivityToBig;
import com.qf.news.model.VideoBean;
import com.qf.news.util.DateTimeUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by weidie on 2016/10/23.
 */
public class VideoBeanAdapter extends BaseAdapter {
    private final MediaPlayer mediaPlayer;
    private final LayoutInflater inflater;
    Context context;
    public static final String TAG = "test";
    private List<VideoBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist = new ArrayList<>();

    private int currentPosition = -1;
    long currentTime, lastTime = 0;
    boolean isPlaying;
    private boolean playStop = true;

    private Handler handler = new Handler();
    private Runnable runnable;
    private int duration;
    private int progress;
    private String video_uri;
    private String realvideourl;
    private String title;

    public VideoBeanAdapter(Context context, List<VideoBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist) {
        this.context = context;
        this.contentlist = contentlist;
        inflater = LayoutInflater.from(context);
        mediaPlayer = new MediaPlayer();
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
        final Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.play_video_item, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = ((Holder) convertView.getTag());
        }

        String love = contentlist.get(position).getLove();
        Log.e(TAG, "love " + love);
        String hate = contentlist.get(position).getHate();
        String name = contentlist.get(position).getName();
        String text = contentlist.get(position).getText();
        final String weixin_url = contentlist.get(position).getWeixin_url();
        String profile_image = contentlist.get(position).getProfile_image();
        video_uri = contentlist.get(position).getVideo_uri();

        holder.sdv.setImageURI(profile_image);
        //      holder.ivBg.setImageURI(images[new Random().nextInt(images.length - 1)]);

        Glide.with(context).load(Uri.parse(profile_image))
                .override(20, 20)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivBg);
        Glide.with(context).load(Uri.parse(profile_image)).into(holder.ivImg);

        holder.tvAhthor.setText(name);
        holder.tvHate.setText(hate);
        holder.tvLove.setText(love);
        holder.tvTitle.setText(text);




        //点击封面开始播放
        holder.ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = position;
                notifyDataSetChanged();
            }
        });
        Log.e(TAG, "position: " + position);
        Log.e(TAG, "currentposition: " + currentPosition);

        holder.svVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressaBarForAWhile(holder);
            }
        });


        holder.ivPlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (mediaPlayer.isPlaying()) {
//                    holder.ivPlay2.setImageResource(R.mipmap.pause);
//                } else {
//
//                    holder.ivPlay2.setImageResource(R.mipmap.play2);
//                }
                if (mediaPlayer.isPlaying()) {
                    holder.ivPlay2.setImageResource(R.mipmap.play2);
                    mediaPlayer.pause();
                    //             handler.removeCallbacks(runnable);

                } else {
                    holder.ivPlay2.setImageResource(R.mipmap.pause);

                    mediaPlayer.start();
                    repeatRefresh(holder);
                }
            }
        });

        if (position == currentPosition) {
            holder.ivImg.setVisibility(View.INVISIBLE);
            holder.svVideo.setVisibility(View.VISIBLE);
            holder.ivBg.setVisibility(View.INVISIBLE);
            holder.ivPlay.setVisibility(View.GONE);
            holder.ivImg.setVisibility(View.GONE);
            holder.tvTitle.setVisibility(View.GONE);
            Log.e("weidie", "getView: " + holder);
//            holder.sb.setVisibility(View.VISIBLE);
//            holder.ivPlay2.setVisibility(View.VISIBLE);

            playVideo(video_uri, holder);

            realvideourl=video_uri;
            title=text;

            showProgressaBarForAWhile(holder);
        } else {
            holder.ivImg.setVisibility(View.VISIBLE);
            holder.ivBg.setVisibility(View.VISIBLE);
            holder.ivPlay.setVisibility(View.VISIBLE);
            holder.tvTitle.setVisibility(View.VISIBLE);
            holder.svVideo.setVisibility(View.INVISIBLE);
            holder.rl.setVisibility(View.GONE);
//
//            holder.sb.setVisibility(View.GONE);
//            holder.ivPlay2.setVisibility(View.GONE);
        }

        //一旦播放当前播放条目离开屏幕，就停止播放，并将当前播放位置重新置为-1
        Integer formerPosition = (Integer) holder.svVideo.getTag();//前世
        if (formerPosition != null && position != currentPosition && formerPosition == currentPosition) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            currentPosition = -1;
        }
        holder.svVideo.setTag(position);


        holder.sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                Log.e(TAG, "progress" + progress);
                mediaPlayer.seekTo((int) (progress / 100f * duration));
            }
        });


        holder.tvWb.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                currentPosition = -1;
                notifyDataSetChanged();

                Intent intent = new Intent(context, ShowNewsActivity.class);
                Log.e(TAG, "onClick: " + position);
                intent.putExtra("link", weixin_url);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    private void showProgressaBarForAWhile(final Holder _holder) {
        Log.d(TAG, "showProgressaBarForAWhile: ");
        currentTime=System.currentTimeMillis();
        if(currentTime-lastTime>5000){
            _holder.rl.setVisibility(View.VISIBLE);
            _holder.totalTime.setText(DateTimeUtil.durationMillisToString(duration));
            _holder.tvTitle.setVisibility(View.VISIBLE);
            if (mediaPlayer.isPlaying()) {
                _holder.ivPlay2.setImageResource(R.mipmap.pause);

            } else {
                _holder.ivPlay2.setImageResource(R.mipmap.play2);
            }

            lastTime=currentTime;


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    _holder.rl.setVisibility(View.GONE);
                    _holder.tvTitle.setVisibility(View.GONE);
                    Log.d(TAG, "run: now gone");
                }
            }, 5000);
        }

    }

    public void playVideo(final String videoUrl, final Holder holder) {
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(context, Uri.parse(videoUrl));
            mediaPlayer.setDisplay(holder.svVideo.getHolder());
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                    repeatRefresh(holder);
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    handler.removeCallbacks(runnable);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void repeatRefresh(final Holder _holder) {
        runnable = new Runnable() {
            @Override
            public void run() {

                duration = mediaPlayer.getDuration();
                currentPosition = mediaPlayer.getCurrentPosition();

                _holder.updateTime.setText(DateTimeUtil.durationMillisToString(currentPosition));

                progress = (int) (currentPosition * 100f / duration);
                Log.e(TAG, "duration: " + duration + "/currentPosition" + currentPosition + "/prgress" + progress);
                _holder.sb.setProgress(progress);
                repeatRefresh(_holder);

            }
        };
        handler.postDelayed(runnable, 1000);

        _holder.ivBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context,SurfaceActivityToBig.class);
                intent.putExtra("progress",progress);
                intent.putExtra("path",realvideourl);
                intent.putExtra("title",title);
                context.startActivity(intent);
                handler.removeCallbacks(runnable);

                mediaPlayer.stop();
                mediaPlayer.reset();
                currentPosition = -1;
                notifyDataSetChanged();

            }
        });
    }

    static class Holder {
        @BindView(R.id.iv_bg)
        ImageView ivBg;
        @BindView(R.id.sb)
        SeekBar sb;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_wb)
        TextView tvWb;
        @BindView(R.id.sdv)
        SimpleDraweeView sdv;
        @BindView(R.id.tv_ahthor)
        TextView tvAhthor;
        @BindView(R.id.iv_love)
        TextView ivLove;
        @BindView(R.id.tv_love)
        TextView tvLove;
        @BindView(R.id.iv_hate)
        TextView ivHate;
        @BindView(R.id.tv_hate)
        TextView tvHate;
        @BindView(R.id.ll)
        LinearLayout ll;
        @BindView(R.id.rl_progress)
        RelativeLayout rl;
        @BindView(R.id.rlRoot)
        RelativeLayout rlRoot;
        @BindView(R.id.svVideo)
        SurfaceView svVideo;
        @BindView(R.id.ivImg)
        ImageView ivImg;
        @BindView(R.id.iv_play)
        ImageView ivPlay;
        @BindView(R.id.iv_play2)
        ImageView ivPlay2;
        @BindView(R.id.iv_big)
        ImageView ivBig;
        @BindView(R.id.update_time)
        TextView updateTime;
        @BindView(R.id.total_time)
        TextView totalTime;

        Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }



}
