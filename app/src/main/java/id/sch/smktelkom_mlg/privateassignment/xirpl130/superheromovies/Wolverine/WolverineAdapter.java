package id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.Wolverine;

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

public class WolverineAdapter extends RecyclerView.Adapter<WolverineAdapter.ViewHolder> {

    private List<WolverineListItem> wolverineListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public WolverineAdapter(List<WolverineListItem> wolverineListItems, Context context) {
        this.wolverineListItems = wolverineListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wolverine_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final WolverineListItem wolverineListItem = wolverineListItems.get(position);

//        holder.imageViewOtof.setImageResource(R.drawable.ic_memory_black_24dp);
        holder.textViewTitle.setText(wolverineListItem.getTitle());
        holder.textViewYear.setText(wolverineListItem.getYear());

        Glide
                .with(context)
                .load(wolverineListItem.getImageUrl())
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

    public int getItemCount() {
        return wolverineListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView textViewYear;
        public ImageView imageViewOtof;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(R.id.textViewHeadWol);
            textViewYear = (TextView) itemView.findViewById(R.id.textViewDescWol);
            imageViewOtof = (ImageView) itemView.findViewById(R.id.imageViewOtofWol);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.LinearLayoutWol);
        }
    }
}
