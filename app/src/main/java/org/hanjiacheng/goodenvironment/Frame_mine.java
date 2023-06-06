package org.hanjiacheng.goodenvironment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Frame_mine extends Fragment {

    private TextView nameText,sexText,ageText, hobbyText, usernameT,passwordT;
    private Button changeInfo,delInfo,changeRec,delAllRec;

    private int USER_INFO_REQUEST_CODE =11;

    private String valSex="";
    private String nameStr="";
    private String hobbyStr="";
    private String ageStr="";
    private String all="";


    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view= inflater.inflate(R.layout.frame_mine,null);
        initLayout(view);
        String username1=LoginActivity.myVariable;
        String password=LoginActivity.myVariable2;
        Log.i("username",username1);
        usernameT.setText(username1);
        passwordT.setText(password);


//todo 无法接收从输入页面传递来的信息，可能是先加载了页面，可以试试换成onCreate()方法

//        Intent intentGet=new Intent();
////        调用方法获取界面输入的信息
//        onActivityResult(USER_INFO_REQUEST_CODE,22,intentGet);
//
////        Log.i("onCreatViewInfo",valSex+"1");
////        在输入的界面输入的信息将会在这里显示
//        nameText.setText(nameStr);
//        sexText.setText(valSex);
//        ageText.setText(ageStr);
//        hobbyText.setText(hobbyStr);



        return view;
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        initLayout(view);


//        changeInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Todo 跳转到信息输入页面
//                Intent intent=new Intent(getActivity(),InformationInput.class);
//                startActivityForResult(intent, 11);
//                Log.i("button","xiugaigerenxinxi----------");
//            }
//        });
//
//        delInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Todo 清空名片中的所有的个人信息
//                nameText.setText("");
//                sexText.setText("");
//                ageText.setText("");
//                hobbyText.setText("");
//            }
//        });
//        Intent intentGet=new Intent();
//        onActivityResult(11,22,intentGet);
//        System.out.println(nameStr+"-"+valSex+"-"+ageStr+"-"+hobbyStr);
////        Log.i("onCreatViewInfo",valSex+"1");
////        在输入的界面输入的信息将会在这里显示
//        nameText.setText(nameStr);
//        sexText.setText(valSex);
//        ageText.setText(ageStr);
//        hobbyText.setText(hobbyStr);

    }

    //我也真是服了，多了个Fragment就麻烦这么多，界面渲染和事件监听居然不在一个方法里写，谷歌工程师给点力啊！   --韩佳成 2023/06/04 20：45
//I'm really convinced, one more Fragment is so much trouble, interface rendering and event monitoring are not written in one method, Google engineers give some effort!
//मैं वास्तव में आश्वस्त हूं, एक और टुकड़ा इतनी परेशानी है, इंटरफ़ेस रेंडरिंग और इवेंट मॉनिटरिंग एक विधि में नहीं लिखे गए हैं, Google इंजीनियर कुछ प्रयास देते हैं!


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);






//        changeRec.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //todo 对记录进行操作，参考实验7
//            }
//        });
//
//        delAllRec.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //todo 删除所有的记录，参考实验7
//            }
//        });

    }

    public void initLayout(View view){
//        nameText=view.findViewById(R.id.nameText);
//        sexText=view.findViewById(R.id.sexText);
//        ageText=view.findViewById(R.id.ageText);
//        hobbyText =view.findViewById(R.id.interestText);
//        changeInfo=view.findViewById(R.id.changeInfo);
//        delInfo=view.findViewById(R.id.deleteInfo);
        usernameT =view.findViewById(R.id.textView4);
        passwordT=view.findViewById(R.id.textView7);
//        本来想写一个记录自己环保记录的过程，但是数据库操作已经体现在登录和注册上了
//        changeRec=view.findViewById(R.id.changeRecord);
//        delAllRec=view.findViewById(R.id.deleteAllRecord);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==11 && resultCode==22){
            valSex=data.getStringExtra("sex");
            nameStr=data.getStringExtra("name");
            hobbyStr=data.getStringExtra("hobby");
            ageStr=data.getStringExtra("age");

        }
    }


}
