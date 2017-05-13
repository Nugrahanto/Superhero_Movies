package id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.Avengers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.R;

/**
 * Created by Nugrahanto on 13/05/2017.
 */

public class AvengersAdapter extends RecyclerView.Adapter<AvengersAdapter.ViewHolder> {
    private List<AvengersListItem> avengersListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public AvengersAdapter(List<AvengersListItem> avengersListItems, Context context) {
        this.avengersListItems = avengersListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.avengers_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final AvengersListItem avengersListItem = avengersListItems.get(position);

//        holder.imageViewOtof.setImageResource(R.drawable.ic_memory_black_24dp);
        holder.textViewTitle.setText(avengersListItem.getTitle());
        holder.textViewYear.setText(avengersListItem.getYear());

        Glide
                .with(context)
                .load(avengersListItem.getImageUrl())
                .into(holder.imageViewOtof);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Will be released soon", Toast.LENGTH_LONG).show();

//                Intent singleBlogIntent = new Intent(context, TechnologyDetailActivity.class);
//                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //addFLags membuka activity dari fragment
//                singleBlogIntent.putExtra("blog_id", position); //position untuk menentukan posisi di array
//                context.startActivity(singleBlogIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return avengersListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTitle;
        public TextView textViewYear;
        public ImageView imageViewOtof;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(R.id.textViewHeadAve);
            textViewYear = (TextView) itemView.findViewById(R.id.textViewDescAve);
            imageViewOtof = (ImageView) itemView.findViewById(R.id.imageViewOtofAve);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.LinearLayoutAve);
        }
    }

}
