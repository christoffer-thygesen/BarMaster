package memelord.com.barmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {

    private ListView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        result = findViewById(R.id.listviewDrinks);

        ArrayList<String> objects = getIntent().getStringArrayListExtra("categoryPicked");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, objects);
        result.setAdapter(arrayAdapter);

        result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DrinksActivity.this, RecipeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClickReturn(View view) {
        finish();
    }
}
