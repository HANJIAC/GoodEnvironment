package org.hanjiacheng.goodenvironment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/*
CODE BY HANJIACHENG
 ________  ________  ________  _______           ________      ___    ___
|\   ____\|\   __  \|\   ___ \|\  ___ \         |\   __  \    |\  \  /  /|
\ \  \___|\ \  \|\  \ \  \_|\ \ \   __/|        \ \  \|\ /_   \ \  \/  / /
 \ \  \    \ \  \\\  \ \  \ \\ \ \  \_|/__       \ \   __  \   \ \    / /
  \ \  \____\ \  \\\  \ \  \_\\ \ \  \_|\ \       \ \  \|\  \   \/  /  /
   \ \_______\ \_______\ \_______\ \_______\       \ \_______\__/  / /
    \|_______|\|_______|\|_______|\|_______|        \|_______|\___/ /
                                                             \|___|/


 ___  ___  ________  ________         ___  ___  ________  ________  ___  ___  _______   ________   ________
|\  \|\  \|\   __  \|\   ___  \      |\  \|\  \|\   __  \|\   ____\|\  \|\  \|\  ___ \ |\   ___  \|\   ____\
\ \  \\\  \ \  \|\  \ \  \\ \  \     \ \  \ \  \ \  \|\  \ \  \___|\ \  \\\  \ \   __/|\ \  \\ \  \ \  \___|
 \ \   __  \ \   __  \ \  \\ \  \  __ \ \  \ \  \ \   __  \ \  \    \ \   __  \ \  \_|/_\ \  \\ \  \ \  \  ___
  \ \  \ \  \ \  \ \  \ \  \\ \  \|\  \\_\  \ \  \ \  \ \  \ \  \____\ \  \ \  \ \  \_|\ \ \  \\ \  \ \  \|\  \
   \ \__\ \__\ \__\ \__\ \__\\ \__\ \________\ \__\ \__\ \__\ \_______\ \__\ \__\ \_______\ \__\\ \__\ \_______\
    \|__|\|__|\|__|\|__|\|__| \|__|\|________|\|__|\|__|\|__|\|_______|\|__|\|__|\|_______|\|__| \|__|\|_______|
 */
public class MainActivity extends AppCompatActivity {

     ImageView mine,news;
     FragmentManager manager;
     FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImage();

        MyListener myListener=new MyListener();
        mine.setOnClickListener(myListener);
        news.setOnClickListener(myListener);
        manager = getFragmentManager();
//        ft = manager.beginTransaction();
//        ft.replace(R.id.frame, new Frame_news());
//        ft.commit();//每次事务提交一次，把自己销毁
//        news.setImageResource(R.drawable.newschecked);
    }

    void initImage(){
        mine=findViewById(R.id.image_mine);
        news=findViewById(R.id.image_news);
    }

    void initimageRes(){
        mine.setImageResource(R.drawable.mine);
        news.setImageResource(R.drawable.news);

    }


    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.image_mine:
                    Toast.makeText(MainActivity.this, "我的", Toast.LENGTH_LONG).show();
                    //加载对应的碎片文件
                    ft =manager.beginTransaction();
                    ft.replace(R.id.frame, new Frame_mine());
                    ft.commit();//每次事务提交一次，把自己销毁
                    initimageRes();
                    mine.setImageResource(R.drawable.minechecked);
//                    MyFragment01 myFragment01=(MyFragment01) manager.findFragmentById(R.id.frag);
//                    myFragment01.setTextView("dddddddd");
                    break;
                case R.id.image_news:
                    Toast.makeText(MainActivity.this, "文章", Toast.LENGTH_LONG).show();
                    ft = manager.beginTransaction();
                    ft.replace(R.id.frame, new Frame_news());
                    ft.commit();//每次事务提交一次，把自己销毁
                    initimageRes();
                    news.setImageResource(R.drawable.newschecked);
                    break;

            }
        }
    }
}