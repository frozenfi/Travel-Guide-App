package fi.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import fi.nischhal.travelguide.R;

public class DetailsActivity extends AppCompatActivity {

    ImageView imgMain;
    TextView title, desc;
    String title_text, desc_text;
    int myImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imgMain = findViewById(R.id.img_main);
        title = findViewById(R.id.txt_title);
        desc = findViewById(R.id.txt_desc);

        getData();
        setData();


    }

    private void getData() {
        if(getIntent().hasExtra("image") && getIntent().hasExtra("title") && getIntent().hasExtra("desc")) {

            title_text = getIntent().getStringExtra(("title"));
            desc_text = getIntent().getStringExtra(("desc"));
            myImage = getIntent().getIntExtra("image", 1);
        } else
            Toast.makeText(this, "The data is not available", Toast.LENGTH_SHORT).show();
    }

    private void setData() {
        title.setText(title_text);
        desc.setText(desc_text);
        imgMain.setImageResource(myImage);
    }
}