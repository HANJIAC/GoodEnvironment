package org.hanjiacheng.goodenvironment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InformationInput extends AppCompatActivity {

    private EditText name,age,hobby;
    private ImageView imageView;
    private RadioGroup sexCheck;
    private Button ensure,photo;

    private String valSex="";
    private String nameStr="";
    private String hobbyStr="";
    private String ageStr="";
    private String all="";

    private int RESULT_CODE=22,PICK_IMAGE=33;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_input);
        initLayout();

        sexCheck.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton r = (RadioButton) findViewById(i);
                valSex = r.getText().toString();
            }
        });

//      点击此按钮拍照
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE);
//                谷歌的代码
//                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivityForResult(intent, PICK_IMAGE);
//                }
            }
        });

        ensure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameStr=name.getText().toString();
                hobbyStr=hobby.getText().toString();
                ageStr=age.getText().toString();
                all=nameStr+" "+ageStr+" "+hobbyStr+" "+valSex;
                Log.i("inputInfo",all);
                Intent intent=new Intent(InformationInput.this,Frame_mine.class);
//todo 将值传递回Frame_mine
                intent.putExtra("name",nameStr);
                intent.putExtra("sex",valSex);
                intent.putExtra("age",ageStr);
                intent.putExtra("hobby",hobbyStr);
                setResult(RESULT_CODE,intent);
                finish();
            }
        });



    }

    public void initLayout(){
        name=findViewById(R.id.editTextTextPersonName);
        age=findViewById(R.id.editTextTextPersonName);
        hobby=findViewById(R.id.editTextTextPersonHobby);
        ensure=findViewById(R.id.button);
        sexCheck=findViewById(R.id.radioGroupSex);
        photo=findViewById(R.id.photo);
        imageView=findViewById(R.id.imageViewPhoto);
    }
}
