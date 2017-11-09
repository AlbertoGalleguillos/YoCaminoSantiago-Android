package cl.marcer.yocaminosantiago;

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


    public PlaceHolder(final View itemView) {
        super(itemView);
        nameText = itemView.findViewById(R.id.tv_name);
        durationText= itemView.findViewById(R.id.tv_duration);
        distanceText= itemView.findViewById(R.id.tv_distance);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(),"Name :" + nameText.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
