package memelord.com.barmaster;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Christoffer on 17/01/2018.
 */

public class RecipeAdapter extends ArrayAdapter<String> {

    public RecipeAdapter(@NonNull Context context, ArrayList<String> data) {
        super(context, R.layout.recipe_row, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowView = inflater.inflate(R.layout.recipe_row, parent, false);

        String recipeLine = getItem(position);

        TextView line = rowView.findViewById(R.id.recipeLine);
        line.setText(recipeLine);

        return rowView;
    }
}
