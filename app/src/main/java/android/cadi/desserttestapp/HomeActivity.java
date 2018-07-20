package android.cadi.desserttestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;

public class HomeActivity extends AppCompatActivity {
    AccessToken facebookAccessToken ;
    Profile facebookProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        facebookAccessToken = getIntent().getParcelableExtra("token");
        facebookProfile = Profile.getCurrentProfile();
        ((TextView)findViewById(R.id.txt_testMsg)).setText(facebookProfile.getName()+"님 로그인 중");
        ((Button)findViewById(R.id.btn_facebook_logout)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                finish();
            }
        });

    }
}
