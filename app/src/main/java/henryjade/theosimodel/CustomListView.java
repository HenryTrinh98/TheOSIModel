package henryjade.theosimodel;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends ArrayAdapter<String> {

    private String[] applicationLayers;
    private Integer[] imageID;
    private Activity context;

    public CustomListView(Activity context, String[] applicationLayers, Integer[] imageID) {
        super(context, R.layout.listview_layout, applicationLayers);

        this.context = context;
        this.applicationLayers = applicationLayers;
        this.imageID = imageID;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;
        ViewHolder viewHolder = null;
        if (r==null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) r.getTag();
        }

        viewHolder.imageView.setImageResource(imageID[position]);

        viewHolder.textView1.setText(applicationLayers[position]);

        return r;
    }

    class ViewHolder {

        TextView textView1;
        TextView textView2;
        ImageView imageView;
        ViewHolder(View v) {

            textView1 = v.findViewById(R.id.tvapplicationlayer);
            imageView = v.findViewById(R.id.imageView);

        }


    }
}
