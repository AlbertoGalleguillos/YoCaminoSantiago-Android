package cl.marcer.yocaminosantiago;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ubuntu on 09-11-17.
 */

public class PlaceHolder extends RecyclerView.ViewHolder {
    TextView nameText;
    TextView durationText;
    TextView distanceText;
    TextView latitudeText;
    TextView longitudeText;

    public static final String EXTRA_PLACE_NAME = "PLACE_NAME";
    public static final String EXTRA_LATITUDE = "LATITUDE";
    public static final String EXTRA_LONGITUDE = "LONGITUDE";

    public PlaceHolder(final View itemView) {
        super(itemView);
        nameText = itemView.findViewById(R.id.tv_name);
        durationText= itemView.findViewById(R.id.tv_duration);
        distanceText= itemView.findViewById(R.id.tv_distance);
        latitudeText = itemView.findViewById(R.id.tv_latitude);
        longitudeText = itemView.findViewById(R.id.tv_longitude);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(),"Name : " + nameText.getText(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                intent.putExtra(EXTRA_PLACE_NAME, nameText.getText());
                intent.putExtra(EXTRA_LATITUDE, latitudeText.getText());
                intent.putExtra(EXTRA_LONGITUDE, longitudeText.getText());
                view.getContext().startActivity(intent);
            }
        });
    }
}
