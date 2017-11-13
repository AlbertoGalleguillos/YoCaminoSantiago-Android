package cl.marcer.yocaminosantiago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        Intent intent = getIntent();
        String imageName = intent.getStringExtra(PlaceHolder.EXTRA_PLACE_URL);

        ImageView fullPlace = findViewById(R.id.iv_full_place);
        int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        fullPlace.setImageResource(resID);
    }
}
