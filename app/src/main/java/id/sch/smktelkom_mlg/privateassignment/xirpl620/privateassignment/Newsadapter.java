package id.sch.smktelkom_mlg.privateassignment.xirpl620.privateassignment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Dafa Zakhulhaq on 13/05/2017.
 */

public class Newsadapter
        extends RecyclerView.Adapter<Newsadapter.ViewHolder> {

    private List<News> newses;
    private Context context;

    public Newsadapter(List<News> newses, Context context) {
        this.newses = newses;
        this.context = context;
    }

    @Override
    public Newsadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Newsadapter.ViewHolder holder, final int position) {
        final News news = newses.get(position);

        holder.title.setText(news.getJudul());
        holder.by.setText(news.getBuat());

        Glide
                .with(context)
                .load(news.getGambar())
                .into(holder.image);

        holder.cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Detail.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("image", news.getGambar());
                intent.putExtra("judul", news.getJudul());
                intent.putExtra("detildeskripsi", news.getDeskrip());
                intent.putExtra("oleh", news.getBuat());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return newses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView title;
        public TextView description;
        public TextView by;
        public CardView cd1;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.gambar);
            title = (TextView) itemView.findViewById(R.id.tv1);
            by = (TextView) itemView.findViewById(R.id.tv3);
            cd1 = (CardView) itemView.findViewById(R.id.cd);
        }

    }
}
