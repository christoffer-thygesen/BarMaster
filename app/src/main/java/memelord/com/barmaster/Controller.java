package memelord.com.barmaster;

import android.app.Activity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Christoffer on 18/12/2017.
 */

public class Controller {

    private static Controller instance;
    private static Activity activity;
    private ArrayList<String> drinksList;
    private ArrayList<String> oelList;
    private ArrayList<String> sjusserList;
    private ArrayList<String> varmeDrikkeList;

    private Controller(Activity activity) {
        //private constructor
        this.activity = activity;

        drinksList = new ArrayList<>();
        oelList = new ArrayList<>();
        sjusserList = new ArrayList<>();
        varmeDrikkeList = new ArrayList<>();
        populateDrinksList();
    }


    //singleton
    public static Controller getInstance(Activity activity) {

        if (instance == null) {
            //initLists();
            instance = new Controller(activity);
        }

        return instance;
    }

    public ArrayList<String> getDrinksList() {
        return drinksList;
    }

    public ArrayList<String> getOelList() {
        return oelList;
    }

    public ArrayList<String> getSjusserList() {
        return sjusserList;
    }

    public ArrayList<String> getVarmeDrikkeList() {
        return varmeDrikkeList;
    }

    private void populateDrinksList() {
        InputStream inputStream = activity.getResources().openRawResource(activity.getResources().getIdentifier("drinks", "raw", activity.getPackageName()));

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;

            while((line = bufferedReader.readLine()) != null) {
                drinksList.add(line);
            }
            bufferedReader.close();
            Collections.sort(drinksList);


        } catch (IOException e) {
            Log.d("TESTINGREAD", e.getMessage());
        }
    }
}
