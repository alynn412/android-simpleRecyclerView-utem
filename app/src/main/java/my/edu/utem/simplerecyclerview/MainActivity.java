package my.edu.utem.simplerecyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    //(4)buat find by id
    public class CustomViewHolder extends RecyclerView.ViewHolder
    {
        TextView wordTextView;

        public CustomViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.custom_row,parent,false));
            wordTextView = itemView.findViewById(R.id.wordTextView);
        }
    }

    //(5)what, where, how data display
    public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>
    {
        public final String[] restaurantNames;
        public CustomAdapter(Context context)
        {
            Resources resources = context.getResources();
            restaurantNames = resources.getStringArray(R.array.restaurant_name);
        }

        @NonNull
        @Override
        //which viewholder to use
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()),viewGroup);
        }

        @Override
        //what to show for each row
        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
            customViewHolder.wordTextView.setText(restaurantNames[i]);
        }

        @Override
        //how many rows to repeat
        public int getItemCount() {
            return restaurantNames.length;
        }
    }
}