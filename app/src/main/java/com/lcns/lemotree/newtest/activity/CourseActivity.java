package com.lcns.lemotree.newtest.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.lcns.lemotree.newtest.R;
import com.lcns.lemotree.newtest.model.Course;
import com.lcns.lemotree.newtest.service.CourseService;
import com.lcns.lemotree.newtest.util.CommonUtil;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Lemotree on 2016/6/20.
 * 课程表页面
 */

public class CourseActivity extends Activity {
    private static Context mContext;

    //课程页面的button引用，6行7列
    private int[][] lessons = {
            {R.id.lesson11, R.id.lesson12, R.id.lesson13, R.id.lesson14, R.id.lesson15, R.id.lesson16, R.id.lesson17},
            {R.id.lesson21, R.id.lesson22, R.id.lesson23, R.id.lesson24, R.id.lesson25, R.id.lesson26, R.id.lesson27},
            {R.id.lesson31, R.id.lesson32, R.id.lesson33, R.id.lesson34, R.id.lesson35, R.id.lesson36, R.id.lesson37},
            {R.id.lesson41, R.id.lesson42, R.id.lesson43, R.id.lesson44, R.id.lesson45, R.id.lesson46, R.id.lesson47},
            {R.id.lesson51, R.id.lesson52, R.id.lesson53, R.id.lesson54, R.id.lesson55, R.id.lesson56, R.id.lesson57},
            {R.id.lesson61, R.id.lesson62, R.id.lesson63, R.id.lesson64, R.id.lesson65, R.id.lesson66, R.id.lesson67},
    };
    //某节课的背景图,用于随机获取
    private int[] bg = {R.drawable.kb1, R.drawable.kb2, R.drawable.kb3, R.drawable.kb4, R.drawable.kb5, R.drawable.kb6, R.drawable.kb7};
    private CourseService courseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        mContext = getApplicationContext();
        initValue();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 初始化变量
     */
    private void initValue() {
        //courseService= CourseService.getCourseService();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        //这里有逻辑问题，只是简单的显示了下数据，数据并不一定是显示在正确位置
        //课程可能有重叠
        //课程可能有1节课的，2节课的，3节课的，因此这里应该改成在自定义View上显示更合理
        //List<Course> courses;//获得数据库中的课程
        Course course = null;
//        RequestQueue mQueue = Volley.newRequestQueue(mContext);
//        GsonRequest<Course> gsonRequest = new GsonRequest<Course>(
//                "http://192.168.3.104:8080/test/index.do", Course.class,
//                new Response.Listener<Course>() {
//                    @Override
//                    public void onResponse(Course course) {
//                        //Course course = courseinfo.getCourse();
//                        Log.d("TAG", "Name is " + course);
//                        Log.d("TAG", "teacher is " + course.getTeacher());
//                        Log.d("TAG", "dayofweek is " + course.getDayOfWeek());
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("TAG", error.getMessage(), error);
//            }
//        });
//        mQueue.add(gsonRequest);

//创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
        final Request request = new Request.Builder()
                .url("https://github.com/hongyangAndroid")
                .build();
//new call
        Call call = mOkHttpClient.newCall(request);
//请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String htmlStr =  response.body().string();
                Log.d("TAG111", "Name is " + htmlStr);

            }
        });


//        GsonRequest<Courseinfo> gsonRequest = new GsonRequest<Courseinfo>(
//                "http://192.168.3.104:8080/test/index.do", Courseinfo.class,
//                new Response.Listener<Courseinfo>() {
//                    @Override
//                    public void onResponse(Courseinfo courseinfo) {
//                        List<Course> course = courseinfo.getCourses();
//                        Log.d("TAG", "courseinfo is " + courseinfo.toString()+"num"+course.size() );
//                        for (int i = 0; i < course.size(); i++) {
//
//                            Log.d("TAG", "Name is " + course.get(i).getCourseName());
//                        }
//
//                        //Log.d("TAG", "teacher is " + course.getTeacher());
//                        //Log.d("TAG", "dayofweek is " + course.getDayOfWeek());
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("TAG", error.getMessage(), error);
//            }
//        });
//        mQueue.add(gsonRequest);


//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://192.168.3.104:8080/test/index.do", null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("TAG", response.toString());
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("TAG", error.getMessage(), error);
//            }
//        });
//        mQueue.add(jsonObjectRequest);

        for (int i = 0; i < 10; i++) {
            //course=courses.get(i);//拿到当前课程
            //int dayOfWeek = course.getDayOfWeek()-1;//转换为lessons数组对应的下标
            //int section=course.getStartSection()/2;//转换为lessons数组对应的下标
            Button lesson = (Button) findViewById(lessons[1][2]);//获得该节课的button
            int bgRes = bg[CommonUtil.getRandom(bg.length - 1)];//随机获取背景色
            lesson.setBackgroundResource(bgRes);//设置背景
            lesson.setText("语文@一班");//设置文本为课程名+“@”+教室
        }
    }
}

