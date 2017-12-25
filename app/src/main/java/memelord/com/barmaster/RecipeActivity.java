package memelord.com.barmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    private TextView recipeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2);

        recipeText = findViewById(R.id.recipeText);
        String recipe = "Glas:\n\t“Krystalglas” \n\nIngrediens:\n\t4 cl. Smirnoff Vodka \n\tGinger Beer \n\nFremgangsmåde: \n\tGlasset fyldes til en cm. under kanten med is. \n\tGlasset fyldes til en cm. under kanten med is. \n\tDerefter tilsættes ingredienserne lag på lag. \n\nPynt: \n\tLime skiver";

        String thisString = "Glas:\n\tStor fadølsglas \n\nIngrediens:\n\t2 cl. Vodka \n\t2 cl. Bacardi Rom \n\t2 cl. Gin \n\t2 cl Tequila \n\t2 cl. Cointreau \n\t2 cl. Monin Lime Juice \n\tcola \n\tcola Zero";
        String extraString = "\n\nFremgangsmåde: \n\tPut 6 cl. cola i glasset \n\tPut al spiritus og lime juice i en shaker \n\tShake og hæld over cola \n\tToppes med cola zero";

        recipeText.setText(thisString + extraString);
    }

    public void onClickReturn(View view) {
        finish();
    }
}
