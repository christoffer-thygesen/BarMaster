package memelord.com.barmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    private TextView recipeText;
    private ImageView drinkImage;
    private ListView recipeListView;
    private ImageView blackground;
    private String glass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2);
        glass = "Glas:\n\t";

        drinkImage = findViewById(R.id.drinkView);
        recipeListView = findViewById(R.id.recipeListView);
        blackground = findViewById(R.id.blackground);
        blackground.setAlpha(0.6f);

        PacketRecipe theRecipe = (PacketRecipe) getIntent().getSerializableExtra("THIS_RECIPE");
        drinkImage.setImageResource(theRecipe.getDrinkImage());

        ListAdapter recipeAdapter = new RecipeAdapter(this, theRecipe.getLines());
        recipeListView.setAdapter(recipeAdapter);
    }

    public void onClickReturn(View view) {
        finish();
    }
}
