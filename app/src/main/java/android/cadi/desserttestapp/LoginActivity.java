package android.cadi.desserttestapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity {
    Button btn_kakao_login;
    CallbackManager callbackManager;
    LoginButton btn_facebook_login;
    Button btn_sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginManager.getInstance().logOut();
        btn_sign_up = (Button)findViewById(R.id.btn_sign_up);
        btn_kakao_login = (Button)findViewById(R.id.btn_kakao_login);
        callbackManager = CallbackManager.Factory.create();
        btn_facebook_login = (LoginButton) findViewById(R.id.btn_facebook_login);
        btn_facebook_login.setReadPermissions("email");
        btn_facebook_login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(LoginActivity.this,"로그인 성공",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("token",loginResult.getAccessToken());
                startActivity(intent);
                finish();
            }

            @Override
            public void onCancel() {
                AlertDialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("로그인 실패");
                builder.setPositiveButton("확인",null);
                dialog = builder.create();
                dialog.show();
            }

            @Override
            public void onError(FacebookException error) {
                AlertDialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("로그인 에러");
                builder.setPositiveButton("확인",null);
                dialog = builder.create();
                dialog.show();

            }
        });
        Button.OnClickListener tmpListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"서비스 준비중 입니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        };
        btn_kakao_login.setOnClickListener(tmpListener);
        btn_sign_up.setOnClickListener(tmpListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_kakao_login.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    btn_kakao_login.setBackground(getDrawable(R.drawable.kakao_account_login_btn_medium_wide_ov));
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    btn_kakao_login.setBackground(getDrawable(R.drawable.kakao_account_login_btn_medium_wide));
                }
                return false;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);

    }
}
