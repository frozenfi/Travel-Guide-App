package fi.binod.travelguide;
import fi.nischhal.travelguide.MainActivity;
import fi.nischhal.travelguide.R;
import fi.user.FrontPage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMER = 5000;

    ImageView splashImage;
    TextView cityGuide, subtopic;

    Animation sideAnim, bottomAnim;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        splashImage = findViewById(R.id.imageSplash);
        cityGuide = findViewById(R.id.textViewCity);
        subtopic = findViewById(R.id.textViewSub);

        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        splashImage.setAnimation(sideAnim);
        cityGuide.setAnimation(bottomAnim);
        subtopic.setAnimation(bottomAnim);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, FrontPage.class );
            startActivity(intent);
            finish();
        },SPLASH_TIMER);
    }

}


