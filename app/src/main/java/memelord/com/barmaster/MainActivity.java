package memelord.com.barmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Controller controller;
    private ImageView drinks;
    private ImageView oel;
    private ImageView varmDrikke;
    private ImageView sjusser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = Controller.getInstance(this);

        drinks = findViewById(R.id.imageDrinks);
        oel = findViewById(R.id.imageOel);
        varmDrikke = findViewById(R.id.imageVarmeDrikke);
        sjusser = findViewById(R.id.imageSjusser);

        drinks.setOnClickListener(this);
        oel.setOnClickListener(this);
        varmDrikke.setOnClickListener(this);
        sjusser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, DrinksActivity.class);
        switch (v.getId()) {
            case R.id.imageDrinks:
                intent.putExtra("categoryPicked", controller.getPacketDrinkList());
                break;

            case R.id.imageOel:
                intent.putExtra("categoryPicked", controller.getPacketOelList());
                break;

            case R.id.imageSjusser:
                intent.putStringArrayListExtra("categoryPicked", controller.getSjusserList());
                break;

            case R.id.imageVarmeDrikke:
                intent.putStringArrayListExtra("categoryPicked", controller.getVarmeDrikkeList());
                break;
        }
        startActivity(intent);
    }
}
