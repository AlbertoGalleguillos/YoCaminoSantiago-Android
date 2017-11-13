package cl.marcer.yocaminosantiago;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alberto Galleguillos on 09-11-17.
 */

public class PlaceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView placeImage;
    TextView nameText;
    TextView durationText;
    TextView distanceText;
    TextView latitudeText;
    TextView longitudeText;
    TextView photoUrlText;

    public static final String EXTRA_PLACE_URL = "EXTRA_PLACE_URL";
    public static final String EXTRA_PLACE_NAME = "PLACE_NAME";
    public static final String EXTRA_PLACE_LATITUDE = "LATITUDE";
    public static final String EXTRA_PLACE_LONGITUDE = "LONGITUDE";

    public PlaceHolder(final View itemView) {
        super(itemView);
        placeImage = itemView.findViewById(R.id.iv_photoUrl);
        nameText = itemView.findViewById(R.id.tv_name);
        durationText= itemView.findViewById(R.id.tv_duration);
        distanceText= itemView.findViewById(R.id.tv_distance);
        latitudeText = itemView.findViewById(R.id.tv_latitude);
        longitudeText = itemView.findViewById(R.id.tv_longitude);
        photoUrlText = itemView.findViewById(R.id.tv_photo_url);

        placeImage.setOnClickListener(this);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if (view.getId() == R.id.iv_photoUrl) {
            intent = new Intent(view.getContext(), PlaceActivity.class);
        } else {
            intent = new Intent(view.getContext(), MapsActivity.class);
        }
        intent.putExtra(EXTRA_PLACE_URL, photoUrlText.getText());
        intent.putExtra(EXTRA_PLACE_NAME, nameText.getText());
        intent.putExtra(EXTRA_PLACE_LATITUDE, latitudeText.getText());
        intent.putExtra(EXTRA_PLACE_LONGITUDE, longitudeText.getText());
        view.getContext().startActivity(intent);

    }
}
