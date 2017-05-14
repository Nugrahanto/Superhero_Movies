package id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.Avengers;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.HeroDB.HeroDBItem;
import id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.R;

public class AvengersDetailActivity extends AppCompatActivity {

    private static final String URL_DATA = "http://www.omdbapi.com/?s=Avengers&apikey=c20dda67";
    public TextView textViewTitleet;
    public TextView textViewYearet;
    public TextView textViewIdet;
    public TextView textViewTypeet;
    public ImageView imageViewDetail;
    public String url;
    public String imageURL;
    HeroDBItem heroDBItem;
    boolean isPressed = true;
    FloatingActionButton fab;
    boolean isNew;
    ArrayList<HeroDBItem> fItem;
    private Integer mPostkey = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avengers_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPostkey = getIntent().getExtras().getInt("blog_id"); //menerima hasil kiriman dari fragment sebelumnya
        loadRecyclerViewData();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPressed) {
                    doSave();
                    Snackbar.make(view, "Berhasil ditambahkan ke favorit", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {

                    Snackbar.make(view, "Artikel favorit anda", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                isPressed = !isPressed;
            }
        });

        textViewTitleet = (TextView) findViewById(R.id.textViewHead);
        textViewYearet = (TextView) findViewById(R.id.textViewYear);
        textViewIdet = (TextView) findViewById(R.id.textViewId);
        textViewTypeet = (TextView) findViewById(R.id.textViewType);
//        textViewReview = (TextView) findViewById(R.id.textViewReview);
        imageViewDetail = (ImageView) findViewById(R.id.imageViewDetail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void doSave() {
        String imageurl = imageURL;
        String title = textViewTitleet.getText().toString();
        String year = textViewYearet.getText().toString();
        heroDBItem = new HeroDBItem(imageurl, title, year);
        heroDBItem.save();

    }

    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("Search");
                            JSONObject o = array.getJSONObject(mPostkey);

                            setTitle("");

                            textViewTitleet.setText(o.getString("Title"));
                            textViewYearet.setText(o.getString("Year"));
                            textViewIdet.setText("imdbID: " + o.getString("imdbID"));
                            textViewTypeet.setText(o.getString("Type"));
//                            url = o.getJSONObject("link").getString("url");

                            Glide
                                    .with(AvengersDetailActivity.this)
                                    .load(o.getString("Poster"))
                                    .into(imageViewDetail);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
