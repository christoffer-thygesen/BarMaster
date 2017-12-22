package memelord.com.barmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2);
    }

    public void onClickReturn(View view) {
        finish();
    }
}
