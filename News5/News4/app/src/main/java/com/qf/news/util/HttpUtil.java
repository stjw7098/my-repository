package com.qf.news.util;

import android.content.Context;

import com.google.gson.Gson;
import com.qf.news.model.NavigationBean;
import com.qf.news.model.NewsBean;
import com.qf.news.model.VideoBean;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class HttpUtil {
    private static String title;
    private static int page;
    static Context mcontext;

    public static Cache provideCache() {
        return new Cache(mcontext.getCacheDir(), 10240*1024);
    }

    public static class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            Response response1 = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //cache for 30 days
                    .header("Cache-Control", "max-age=" + 3600 * 24 * 30)
                    .build();
            return response1;
        }
    }

    public static String getNavigation(Context context){
        mcontext=context;
        String json = getStrByOkhttp("https://route.showapi.com/109-34?showapi_appid=25827&showapi_sign=83bb39102571423b8814b8ba57e0291a");
        return json;
    }

    public static String getNews(String id,int page,Context context){
        mcontext=context;
      //  https://route.showapi.com/109-35?channelId=5572a108b3cdc86cf39001cf&channelName=&maxResult=10&needAllList=0&needContent=0&needHtml=0&page=1&showapi_appid=25827&title=&showapi_sign=83bb39102571423b8814b8ba57e0291a
        String json = getStrByOkhttp("https://route.showapi.com/109-35?channelId=" + id + "&channelName=&maxResult=30&needAllList=0&needContent=0&needHtml=0&page=" + page + "&showapi_appid=25827&title=&showapi_sign=83bb39102571423b8814b8ba57e0291a");
        return json;
    }

    public static String getSearch(String title,int page){

        String json = getStrByOkhttp("https://route.showapi.com/109-35?channelId=&channelName=&maxResult=10&needAllList=0&needContent=0&needHtml=0&page="+page+"&showapi_appid=25827&title=" + title + "&showapi_sign=83bb39102571423b8814b8ba57e0291a");
        return json;
    }

    public static String getVideo(int page,Context context){
        mcontext=context;
        String json = getStrByOkhttp("https://route.showapi.com/255-1?page=" + page + "&showapi_appid=26088&title=&type=41&showapi_sign=2e6d2736b6484554b35468db3d9d5f1e");
        return json;
    }

    public static String getStrByOkhttp(String json){
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient newClient = okHttpClient.newBuilder()
                .addNetworkInterceptor(new CacheInterceptor())
                .cache(provideCache())
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(json)
                .tag("tag")
                .build();


        try {
            Response response = newClient.newCall(request).execute();
            if(response.isSuccessful()){
                json=response.body().string();
            }else{
                json="response is fail";
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        return json;
    }


    public static NavigationBean getNavigationBean(String navJson) {
        NavigationBean navigationBean=null;
        try {
            if(navigationBean==null){
                navigationBean = new Gson().fromJson(navJson, NavigationBean.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return navigationBean;
    }

    public static NewsBean getNewsBean(String newsJson) {
        NewsBean newsBean=null;
        try {
            if(newsBean==null){
                newsBean = new Gson().fromJson(newsJson, NewsBean.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static VideoBean getVideoBean(String videoJson) {
        VideoBean videoBean=null;
        try {
            if(videoBean==null){
                videoBean = new Gson().fromJson(videoJson, VideoBean.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videoBean;
    }
}
