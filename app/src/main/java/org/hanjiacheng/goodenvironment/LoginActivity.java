package org.hanjiacheng.goodenvironment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


//后期突发奇想想写这么一个登录注册页面
public class LoginActivity extends AppCompatActivity {

    private String HANJIACHNEG;

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton,regButton;

    private SQLiteDatabase database;

    public static String myVariable,myVariable2;
    public static int id;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        初始化组件，组件少，这里就不用单独开一个方法了
        usernameEditText = findViewById(R.id.editTextTextPersonName2);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.button2);
        regButton=findViewById(R.id.button3);

        // 打开或创建数据库,有数据库就打开，没有就创建。
        database = openOrCreateDatabase("my_db", MODE_PRIVATE, null);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // 从数据库中查询用户输入的账号密码是否正确
                String[] columns = {"id"};
                String selection = "username=? AND password=?";
                String[] selectionArgs = {username, password};
//               初始化游标
                Cursor cursor = database.query("user", columns, selection, selectionArgs,
                        null, null, null);
                if (cursor.moveToFirst()) {
                    // 将用户名写入myVariable
                myVariable = usernameEditText.getText().toString();
                myVariable2 = passwordEditText.getText().toString();
                id=cursor.getInt(cursor.getColumnIndex("id"));
                    // 如果输入正确，跳转到MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // 如果输入错误，显示错误提示
                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 关闭数据库
        if (database != null) {
            database.close();
        }
    }
}

/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            佛祖保佑       永无BUG
*/

