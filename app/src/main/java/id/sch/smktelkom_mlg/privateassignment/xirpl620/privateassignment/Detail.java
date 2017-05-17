package id.sch.smktelkom_mlg.privateassignment.xirpl620.privateassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Detail extends AppCompatActivity {


    public String url = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?api-key=1d82a5270c564eceaae327fd1d06aeb7";
    String image, judul, oleh, gambar, detildeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        image = intent.getStringExtra("image");
        judul = intent.getStringExtra("judul");
        detildeskripsi = intent.getStringExtra("detildeskripsi");
        oleh = intent.getStringExtra("oleh");
        setTitle(judul);

        gambar = url + image;
        ImageView Imagedetil = (ImageView) findViewById(R.id.imagedetil);
        TextView textjudul = (TextView) findViewById(R.id.detiljudul);
        TextView textdeskripsi = (TextView) findViewById(R.id.detildes);

        Glide.with(this).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.drawable.ic_menu_gallery)
                .error(R.mipmap.ic_launcher)
                .into(Imagedetil);
        textjudul.setText(oleh);
        textdeskripsi.setText(detildeskripsi);


    }
}
