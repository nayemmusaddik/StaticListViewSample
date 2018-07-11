package com.musaddik.staticlistviewsample;

import android.app.Dialog;
import android.app.ListActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
    private CartoonListAdapter cartoonListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List cartoonList = new ArrayList();
        cartoonList
                .add(new Cartoon(
                        "Tintin",
                        R.drawable.tintin_thumb,
                        "Tintin is a fictional character in The Adventures of Tintin, the comics series by Belgian cartoonist Hergé."));
        cartoonList
                .add(new Cartoon(
                        "Snowy",
                        R.drawable.snowy_thumb,
                        "Snowy is a white wire fox terrier who is a companion to Tintin, the series' protagonist. Snowy is a central character in all Tintin stories"));
        cartoonList
                .add(new Cartoon(
                        "Obelix",
                        R.drawable.obelix_thumb,
                        "Obelix is a cartoon character from the French comic book series Asterix. He works as a menhir sculptor and deliveryman, and is Asterix's best friend. Obelix is noted for his fatness, the menhirs he carries around on his back and his superhuman strength"));
        cartoonList
                .add(new Cartoon(
                        "Asterix",
                        R.drawable.asterix_thumb,
                        "Asterix is a fictional character, the titular hero of the French comic book series The Adventures of Asterix. The series portrays him as a diminutive but fearless Gaulish warrior living in the time of Julius Caesar's Gallic Wars"));
        cartoonListAdapter = new CartoonListAdapter(this,
                R.layout.cartoon_items_view, cartoonList);
        setListAdapter(cartoonListAdapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Cartoon cartoon = cartoonListAdapter.getItem((int) position);
        displayIllustratorInDialog(cartoon);
    }
    private void displayIllustratorInDialog(Cartoon cartoon) {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle(cartoon.getName() + "'s " + getString(R.string.illustrator));
        dialog.setContentView(R.layout.author_dialog);
        TextView author = (TextView) dialog.findViewById(R.id.author_name);
        author.setCompoundDrawablesWithIntrinsicBounds(0,
                cartoon.getPicRes(), 0, 0);

        author.setText(cartoon.getName());
        final Button closeButton = (Button) dialog
                .findViewById(R.id.close_author_dialog_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
