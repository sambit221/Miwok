package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

//created to use multiple views to pass into adapter as default adapter only allows one view.
//custom ArrayAdapter
public class WordAdapter extends ArrayAdapter<Word> {
   //id for background colors of diff views
    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> words,int colorResourceId) {//context ,words list
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);//here we used list_item.xml if there is null in listview
            //e.g when img files are not added we used this list_item-ic launcher android img.
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView .setText(currentWord.getMiwokTranslation());
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        //set the ImageView to the image resourse specified in current Word
        if(currentWord.hasImage()) {//condition created to avoid the blankspace left on the left side of phrases view as img is abcent
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else
            imageView.setVisibility(View.GONE);//GONE is used insted of INVISIBLE,cuz INVISIBLE lefts blank space besides it.
        //setting background theme color for list item
        View textContainer = listItemView.findViewById(R.id.text_container);//linearlayout Id at list_item
        //find color that resource id maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        //set the background color of text container view
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
