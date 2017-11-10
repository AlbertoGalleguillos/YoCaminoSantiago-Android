package cl.marcer.yocaminosantiago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference placeRef = database.getReference("place");
    FirebaseRecyclerAdapter<Place, PlaceHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_place);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = placeRef.limitToLast(50);
        FirebaseRecyclerOptions<Place> options = new FirebaseRecyclerOptions.Builder<Place>().setQuery(query, Place.class).build();

        adapter = new FirebaseRecyclerAdapter<Place, PlaceHolder>(options) {
            @Override
            protected void onBindViewHolder(PlaceHolder holder, int position, Place model) {
                holder.nameText.setText(model.getName());
                holder.durationText.setText(model.getDuration());
                holder.distanceText.setText(model.getDistance());
                holder.latitudeText.setText(String.valueOf(model.getLat()));
                holder.longitudeText.setText(String.valueOf(model.getLng()));
            }

            @Override
            public PlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
                return new PlaceHolder(view);
            }
        };
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.stopListening();
    }
}
