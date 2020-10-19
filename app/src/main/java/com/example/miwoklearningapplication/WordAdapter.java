package com.example.miwoklearningapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mbgColorId;

    public WordAdapter(Context context, ArrayList<Word> words, int bgColorId) {
        super(context, 0, words);
        mbgColorId = bgColorId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        final Word currWord = getItem(position);

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TextView miwokWord = listItemView.findViewById(R.id.miwokWordTextView);
        TextView englishWord = listItemView.findViewById(R.id.engWordTextview);

        miwokWord.setText(currWord.getMiwokTranslation());
        englishWord.setText(currWord.getDefaultTranslation());

        ImageView icon = listItemView.findViewById(R.id.iconHolder);
        if (currWord.isImagePresent()) {

            icon.setImageResource(currWord.getImageResourceId());
            icon.setVisibility(View.VISIBLE);
        } else {
            icon.setVisibility(View.GONE);
        }

        int color = ContextCompat.getColor(getContext(), mbgColorId);
        listItemView.findViewById(R.id.rootParent).setBackgroundColor(color);
        //((View) listItemView.findViewById(R.id.playButton)).setBackgroundColor(color);

        return listItemView;

    }
}
