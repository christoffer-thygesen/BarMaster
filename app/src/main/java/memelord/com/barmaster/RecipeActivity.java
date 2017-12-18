package memelord.com.barmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Bundle categoryPicked = getIntent().getExtras();
        String resultString = categoryPicked.getString("categoryPicked");

        result = findViewById(R.id.resultText);
        result.setText(resultString);
    }
}
