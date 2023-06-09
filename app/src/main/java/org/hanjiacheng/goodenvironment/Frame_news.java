package org.hanjiacheng.goodenvironment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frame_news extends Fragment implements AdapterView.OnItemClickListener{

    private ListView lv;

    String[] uriString;

    SimpleAdapter adapter;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.frame_news,container,false);
        lv=view.findViewById(R.id.lv);

//        跳转用的网址
        uriString=new String[]{"http://finance.people.com.cn/n1/2023/0525/c1004-32694458.html","http://env.people.com.cn/n1/2023/0524/c1010-32693116.html",
                "http://env.people.com.cn/n1/2023/0523/c1010-32692209.html","http://env.people.com.cn/n1/2023/0523/c1010-32692210.html",
                "http://env.people.com.cn/n1/2023/0523/c1010-32692211.html","http://finance.people.com.cn/n1/2023/0523/c1004-32692180.html",
                "https://www.hbzhan.com/news/detail/162689.html","https://www.hbzhan.com/news/detail/162715.html"};
        adapter=new SimpleAdapter(getActivity(),getData(),R.layout.news_item,new String[]{"picture","title","date"},new int[]{R.id.newsPhoto,R.id.title,R.id.data});
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);


        return view;
    }

    private List<Map<String,Object>> getData() {
        List<Map<String,Object>> data=new ArrayList<>();
        Map<String,Object> map1=new HashMap<>();
        map1.put("picture" ,R.drawable.earth);
        map1.put("title" ,"2025年底前 我国将基本实现垃圾分类全覆盖");
        map1.put("date","2023/5/25");

        Map<String,Object> map2=new HashMap<>();
        map2.put("picture" ,R.drawable.protectearth);
        map2.put("title" ,"种下红树林  添绿海岸线");
        map2.put("date","2023/5/25");

        Map<String,Object> map3=new HashMap<>();
        map3.put("picture" ,R.drawable.waterearth);
        map3.put("title" ,"黄河岸边  绽放“七彩之光”（美丽中国）");
        map3.put("date","2023/5/25");

        Map<String,Object> map4=new HashMap<>();
        map4.put("picture" ,R.drawable.earth);
        map4.put("title" ,"新版《中国生物多样性红色名录》发布");
        map4.put("date","2023/5/25");

        Map<String,Object> map5=new HashMap<>();
        map5.put("picture" ,R.drawable.protectearth);
        map5.put("title" ,"我国重点保护野生动植物种群持续恢复");
        map5.put("date","2023/5/25");

        Map<String,Object> map6=new HashMap<>();
        map6.put("picture" ,R.drawable.waterearth);
        map6.put("title" ,"长江禁渔，亮出“强基础”成绩单");
        map6.put("date","2023/5/25");

        Map<String,Object> map7=new HashMap<>();
        map7.put("picture" ,R.drawable.chouyang);
        map7.put("title" ,"开始征集！快来申报国家鼓励发展的重大环保技术装备");
        map7.put("date","2023/5/25");

        Map<String,Object> map8=new HashMap<>();
        map8.put("picture" ,R.drawable.turang);
        map8.put("title" ,"变废为宝，龙净环保首个煤矸石综合整治项目加速推进");
        map8.put("date","2023/6/09");

        data.add(map1);data.add(map2);data.add(map3);data.add(map4);data.add(map5);data.add(map6);data.add(map7);data.add(map8);
        return  data;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Uri uri= Uri.parse(uriString[i]);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        Log.i("ListInfo","当前点击的是"+i);
        Toast.makeText(getActivity(), "dianji", Toast.LENGTH_SHORT).show();
    }



}
