package memelord.com.barmaster;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Christoffer on 17/01/2018.
 */

public class RecipeAdapter extends ArrayAdapter<PacketRecipe> {

    public RecipeAdapter(@NonNull Context context, ArrayList<PacketRecipe>) {
        super(context, R.layout.recipe_row, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
