package com.qf.news;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.qf.news.util.DateTimeUtil;

import java.io.IOException;

public class SurfaceActivityToBig extends AppCompatActivity {

    private static final String TAG = "test";
    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1;
    private SurfaceView surfaceView;
    private ImageView tv_play;
    private TextView tv_big;
    private SeekBar sb;
    private RelativeLayout rl;
    private MediaPlayer mediaPlayer;
    private int duration;
    private int currentPosition;
    private int progress;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private String path;
    long currentTime, lastTime = 0;
    private Runnable runnable;
    private TextView totalTime;
    private TextView updateTime;
    private String title;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_activity_to_big);

        progress = getIntent().getIntExtra("progress", -1);
        path = getIntent().getStringExtra("path");
        title = getIntent().getStringExtra("title");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Log.e(TAG, "path: " + path);

        surfaceView = ((SurfaceView) findViewById(R.id.sv));
        tv_play = ((ImageView) findViewById(R.id.tv_play));
        totalTime = ((TextView) findViewById(R.id.total_time));
        tvTitle = ((TextView) findViewById(R.id.tv_title));
        updateTime = ((TextView) findViewById(R.id.update_time));
        sb = ((SeekBar) findViewById(R.id.sb));
        rl = ((RelativeLayout) findViewById(R.id.rl));

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);

        }

        //       initMediaPlayer();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                initMediaPlayer();
                Log.e(TAG, "bigprogress" + progress);


                //1秒之后再来获取进度和时间，否则拿不到，因为播放器异步prepare
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        duration = mediaPlayer.getDuration();
//                        Log.e(TAG, "duration: " + duration);
//                        sb.setProgress(progress);
//                        mediaPlayer.seekTo((int) (progress / 100f * duration));
//                        repeatRefresh();
//                    }
//                }, 3000);

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e(TAG, "onStopTrackingTouch: big");
                int progress = seekBar.getProgress();
                mediaPlayer.seekTo((int) (progress / 100f * duration));
            }
        });

        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentTime = System.currentTimeMillis();
                Log.e(TAG, "currentTime: ");
                if (currentTime - lastTime < 3000 && lastTime != 0) {
                    return;
                }
                Log.e(TAG, "onClick: ");
                sb.setVisibility(View.VISIBLE);
                tv_play.setVisibility(View.VISIBLE);
                updateTime.setVisibility(View.VISIBLE);
                totalTime.setVisibility(View.VISIBLE);
                tvTitle.setVisibility(View.VISIBLE);
                totalTime.setText(DateTimeUtil.durationMillisToString(duration));

                tvTitle.setText(title);

                if (mediaPlayer.isPlaying()) {
                    tv_play.setImageResource(R.mipmap.pause);

                } else {
                    tv_play.setImageResource(R.mipmap.play2);

                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sb.setVisibility(View.GONE);
                        tv_play.setVisibility(View.GONE);
                        updateTime.setVisibility(View.GONE);
                        totalTime.setVisibility(View.GONE);
                        tvTitle.setVisibility(View.GONE);
                    }
                }, 3000);
                lastTime = currentTime;
            }
        });


        tv_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    tv_play.setImageResource(R.mipmap.play2);
                    mediaPlayer.pause();
                    //             handler.removeCallbacks(runnable);
                } else {
                    tv_play.setImageResource(R.mipmap.pause);
                    mediaPlayer.start();
                    repeatRefresh();

                }

            }
        });


    }

    private void repeatRefresh() {
        runnable = new Runnable() {
            @Override
            public void run() {
                currentPosition = mediaPlayer.getCurrentPosition();
                int progress = (int) (currentPosition * 100f / duration);
                sb.setProgress(progress);

                updateTime.setText(DateTimeUtil.durationMillisToString(currentPosition));

                repeatRefresh();
            }
        };
        handler.postDelayed(runnable, 1000);

    }

    private void initMediaPlayer() {
        try {
            mediaPlayer = new MediaPlayer();
            //        mediaPlayer.reset();
            mediaPlayer.setDataSource(this, Uri.parse(path));
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                    mediaPlayer.setDisplay(surfaceView.getHolder());

                    duration = mediaPlayer.getDuration();
                    Log.e(TAG, "duration: " + duration);
                    sb.setProgress(progress);
                    mediaPlayer.seekTo((int) (progress / 100f * duration));
                    repeatRefresh();
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
}
