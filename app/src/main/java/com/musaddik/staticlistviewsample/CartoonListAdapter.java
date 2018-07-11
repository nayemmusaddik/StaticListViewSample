package com.musaddik.staticlistviewsample;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CartoonListAdapter extends ArrayAdapter<Cartoon>{
    private List<Cartoon> cartoonItems;
    private Context context;


    public CartoonListAdapter(Context context, int textViewResourceId, List<Cartoon> cartoonItems) {
        super(context, textViewResourceId, cartoonItems);
        this.context = context;
        this.cartoonItems = cartoonItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.cartoon_items_view, null);
        }

        Cartoon cartoon = cartoonItems.get(position);

        if (cartoon != null) {
            // name
            TextView nameTextView = (TextView) view.findViewById(R.id.name);
            nameTextView.setText(cartoon.getName());

            // thumb image
            ImageView imageView = (ImageView) view.findViewById(R.id.cartoon_pic);
            imageView.setImageResource(cartoon.getPicRes());

            TextView aboutTextView = (TextView) view.findViewById(R.id.about_cartoon);
            aboutTextView.setText(cartoon.getAbout());
        }

        return view;
    }
}