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

    private TextView nameText,sexText,ageText, hobbyText;
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

        changeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo 跳转到信息输入页面
                Intent intent=new Intent(getActivity(),InformationInput.class);
                startActivityForResult(intent, USER_INFO_REQUEST_CODE);
                Log.i("button","xiugaigerenxinxi----------");
            }
        });

        Intent intentGet=new Intent();
//        调用方法获取界面输入的信息
        onActivityResult(USER_INFO_REQUEST_CODE,22,intentGet);

//        在输入的界面输入的信息将会在这里显示
        nameText.setText(nameStr);
        sexText.setText(valSex);
        ageText.setText(ageStr);
        hobbyText.setText(hobbyStr);

        delInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo 清空名片中的所有的个人信息
                nameText.setText("");
                sexText.setText("");
                ageText.setText("");
                hobbyText.setText("");
            }
        });

        changeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 对记录进行操作，参考实验7
            }
        });

        delAllRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 删除所有的记录，参考实验7
            }
        });

        return view;
    }

    public void initLayout(View view){
        nameText=view.findViewById(R.id.nameText);
        sexText=view.findViewById(R.id.sexText);
        ageText=view.findViewById(R.id.ageText);
        hobbyText =view.findViewById(R.id.interestTextView);
        changeInfo=view.findViewById(R.id.changeInfo);
        delInfo=view.findViewById(R.id.deleteInfo);
        changeRec=view.findViewById(R.id.changeRecord);
        delAllRec=view.findViewById(R.id.deleteAllRecord);
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
