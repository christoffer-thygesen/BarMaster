package memelord.com.barmaster;

import android.app.Activity;
import android.content.res.Resources;
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
    private String nt = "\n\t";
    private ArrayList<String> drinksList;
    private ArrayList<String> oelList;
    private ArrayList<String> sjusserList;
    private ArrayList<String> varmeDrikkeList;

    private ArrayList<PacketRecipe> packetOelList;
    private ArrayList<PacketRecipe> packetDrinkList;
    private ArrayList<PacketRecipe> packetSjusserList;
    private ArrayList<PacketRecipe> packetVarmeDrikkeList;

    private Controller(Activity activity) {
        //private constructor
        this.activity = activity;

        drinksList = new ArrayList<>();
        oelList = new ArrayList<>();
        sjusserList = new ArrayList<>();
        varmeDrikkeList = new ArrayList<>();

        packetOelList           = new ArrayList<>();
        packetDrinkList         = new ArrayList<>();
        packetSjusserList       = new ArrayList<>();
        packetVarmeDrikkeList   = new ArrayList<>();

        populateDrinksList();
        populateOelList();
        populateSjusserList();
        populateVarmeDrikkeList();
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

    public ArrayList<PacketRecipe> getPacketOelList() {
        return packetOelList;
    }

    public ArrayList<PacketRecipe> getPacketDrinkList() {
        return packetDrinkList;
    }

    public ArrayList<PacketRecipe> getPacketSjusserList() {
        return packetSjusserList;
    }

    public ArrayList<PacketRecipe> getPacketVarmeDrikkeList() {
        return packetVarmeDrikkeList;
    }

    private void populateDrinksList() {
        InputStream inputStream = activity.getResources().openRawResource(activity.getResources().getIdentifier("drinks", "raw", activity.getPackageName()));

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;

            while((line = bufferedReader.readLine()) != null) {
                drinksList.add(line);

                String glassLine; //glass type
                String ingredients;
                String servingDesc;
                String garnish;
                String denRigtigeVersion;

                int image;

                switch (line) {
                    case "Moscow Mule":
                        glassLine = "Krystalglas";
                        servingDesc = "Glasset fyldes til en cm. under kanten med is.\n\tDerefter tilsættes ingredienserne lag på lag.";
                        ingredients = "4 cl. Vodka \n\tGinger Beer";
                        garnish = "Lime Skiver";
                        image = R.drawable.drinks_moscow_mule;
                        break;
                    case "White Russian":
                        glassLine = "Krystalglas";
                        ingredients = "2 cl. Smirnoff Vodka\n\t2 cl. Kahlua\n\tMælk";
                        servingDesc = "Shaker/glas fyldes med en skefuld is.\n\tDerefter tilsættes ingredienserne og shakes.\n\tBONUS: der kan max shake 2 ad gangen\n\tSPØRG evt gæsten; \"skal den shakes?\"";
                        garnish = "";
                        image = R.drawable.drinks_white_russian;
                        break;
                    case "Tom Collins":
                        glassLine = "Krystalglas";
                        servingDesc = "Put Gin, Lemon, Sugar Cane, Halve Citronskiver" + nt + "Tilsæt isterninger" + nt + "Shakes" + nt + "Toppes med danskvand";
                        ingredients = "4 cl. Tanqueray Gin" + nt + "2 cl. Monin Lemon Rantcho" + nt + "2 cl. Monin Pure Sugar Cane" + nt + "4 halve citronskiver" + nt + "Danskvand" + nt + "Isterninger";
                        garnish = "Citron skiver";
                        image = R.drawable.drinks_tom_collins;
                        break;
                    case "Strawberry Daiquiri":
                        glassLine = "Krystalglas";
                        servingDesc = "Put alle ingredienserne i blenderen" + nt + "Kør på program 4";
                        ingredients = "4 cl. Bacardi Rom" + nt + "2 cl. Monin Lemon Rantcho" + nt + "2 cl. Monin Fraise" + nt +
                                "3 sec jævnt tryk - Monin Pure Jordbær" + nt + "Præcis 1 skefuld is med den sorte isske";
                        garnish = "2 lime både";
                        image = R.drawable.drinks_strawberry_daiquiri;
                        break;
                    case "Mango Daiquiri":
                        glassLine = "Krystalglas";
                        servingDesc = "Put alle ingredienserne i blenderen" + nt + "Kør på program 4";
                        ingredients = "4 cl. Bacardi Rom" + nt + "2 cl. Monin Lemon Rantcho" + nt + "2 cl. Monin Fraise" + nt +
                                "3 sec jævnt tryk - Monin Pure Mango" + nt + "Præcis 1 skefuld is med den sorte isske";
                        garnish = "2 lime både";
                        image = R.drawable.drinks_mango_daiquiri;
                        break;
                    case "Mango Margarita":
                        glassLine = "Krystalglas";
                        servingDesc = "Put alle ingredienserne i blenderen" + nt + "Kør på program 4";
                        ingredients = "4 cl. Tequila" + nt +
                                "2 cl. Monin Lemon Rantcho" + nt +
                                "3 sec jævnt tryk - Monin Pure Mango" + nt +
                                "Præcis 1 skefuld is med den sorte isske";
                        garnish = "2 lime både";
                        image = R.drawable.drinks_mango_margarita;
                        break;
                    case "Pina Colada":
                        glassLine = "Krystalglas";
                        servingDesc = "Bland alle ingredienserne.\n" +
                                nt +
                                "Shakes";
                        ingredients = "4 cl. Bacardi Rom" +
                                nt +
                                "1,5 - 2 cl. Monin Coco" +
                                nt +
                                "8 cl. ananas juice" +
                                nt +
                                "Et lag med 2 cm." +
                                "Isterninger";
                        garnish = "Appelsin skiver";
                        image = R.drawable.drinks_pina_colada;
                        break;
                    case "Dark 'n' Stormy":
                        glassLine = "Krystalglas";
                        denRigtigeVersion = "Fyld 2/3 af glasset med Ginger Beer, sukker og juice" + nt + "Hæld rommen i glasset, så det ligner et stormvejr";
                        servingDesc = "Rom, Angostrua, Lime Juice, Sugar Cane i shaker" +
                                nt +
                                "Shakes og toppes med Ginger Beer" + "\nDen rigtige måde:"+ nt + denRigtigeVersion;
                        ingredients = "4 cl. Bacardi 8 års rom" +
                                nt +
                                "2 cl. Monin Lime Juice" +
                                nt +
                                "2 cl. Monin Sugar Cane" +
                                nt +
                                "Ginger Beer";
                        garnish = "2 Lime både";
                        image = R.drawable.drinks_dark_and_stormy;
                        break;
                    case "Old Fashioned":
                        glassLine = "Krystalglas";
                        denRigtigeVersion = "Bland spsk. sukker med 2-4 dashes af bitter og mas det sammen" + nt + "fyld isterninger i glasset og hæld whisky'en over";
                        servingDesc = "Glasset fyldes med KUN 4 isterninger" +
                                nt +
                                "Derefter tilsættes ingredienserne lag på lag" + "\nDen rigtige måde:"+ nt + denRigtigeVersion;
                        ingredients = "6 cl. Jack Daniels" +
                                nt +
                                "3 dråber Angostrua bitter" +
                                nt +
                                "1 cl. Monin Pure Sugar Cane";
                        garnish = "";
                        image = R.drawable.drinks_tennessee_old_fashioned;
                        break;
                    case "Long Island Iced Tea":
                        glassLine = "Stor fadølsglas";
                        servingDesc = "Put 6 cl. Cola i glasset" +
                                nt +
                                "Put al. Spiritus og Lime Juice i en shaker" +
                                nt +
                                "Shakers og hænges over Cola";
                        ingredients = "2 cl. Vodka" +
                                nt +
                                "2 cl. Bacardi Rom" +
                                nt +
                                "2 cl. Gin" +
                                nt +
                                "2 cl. Tequila" +
                                nt +
                                "2 cl. Cointreau" +
                                nt +
                                "2 cl. Monin Lime Juice" +
                                nt +
                                "Cola";
                        garnish = "";
                        image = R.drawable.drinks_long_island_iced_tea;
                        break;
                    case "Cuba Libre":
                        glassLine = "Krystalglas";
                        servingDesc = "Glasset fyldes til en cm. under kanten med is" +
                                nt +
                                "Derefter tilsættes ingredienserne lag på lag";
                        ingredients = "4 cl. Bacardi Rom" +
                                nt +
                                "Cola";
                        garnish = "Lime både";
                        image = R.drawable.drinks_cuba_libre;
                        break;
                    case "Harvey Wallbanger":
                        glassLine = "Krystalglas";
                        servingDesc = "Glasset fyldes til en cm. under kanten med is" +
                                nt +
                                "Derefter tilsættes ingredienserne lag på lag";
                        ingredients = "2 cl. Smirnoff Vodka" +
                                nt +
                                "Licor 43" +
                                nt +
                                "Appelsin Juice";
                        garnish = "Appelsin skriver";
                        image = R.drawable.drinks_harvey_wallbanger;
                        break;
                    case "Gin & Tonic":
                        glassLine = "Krystalglas";
                        servingDesc = "Glasset fyldes til en cm. under kanten med is" +
                                nt +
                                "Derefter tilsættes ingredienserne lag på lag";
                        ingredients = "2 cl. Tanqueray Gin" +
                                nt +
                                "Schweppes Tonic";
                        garnish = "Agurk eller lime";
                        image = R.drawable.drinks_gin_and_tonic;
                        break;
                    case "Gin & Lemon":
                        glassLine = "Krystalglas";
                        servingDesc = "Glasset fyldes til en cm. under kanten med is" +
                                nt +
                                "Derefter tilsættes ingredienserne lag på lag";
                        ingredients = "2 cl. Tanqueray Gin" +
                                nt +
                                "Schweppes Lemon (Postmix)";
                        garnish = "Lime skive";
                        image = R.drawable.drinks_gin_and_lemon;
                        break;
                    case "Rød Ninja":
                        glassLine = "Krystalglas";
                        servingDesc = "Glasset fyldes til en cm. under kanten med is" +
                                nt +
                                "Derefter tilsættes ingredienserne lag på lag";
                        ingredients = "2 cl. Smirnoff Raspberry" +
                                nt +
                                "Passionssodavand" +
                                nt +
                                "Toppes med Grenadine";
                        garnish = "";
                        image = R.drawable.drinks_roed_ninja;
                        break;
                    case "Key West Lemonade, Glas":
                        glassLine = "Krystalglas";
                        servingDesc = "Glasset fyldes halvt med is, appelsiner, lime og citroner" +
                                nt +
                                "Derefter tilsættes ingredienserne lag på lag";
                        ingredients = "2 cl. Smirnoff Vodka" +
                                nt +
                                "Appelsin skiver" +
                                nt +
                                "Lime både" +
                                nt +
                                "Citron skiver" +
                                nt +
                                "Lemonade";
                        garnish = "";
                        image = R.drawable.drinks_key_west_lemonade_glas;
                        break;
                    case "Key West Lemonade, Kande":
                        glassLine = "Kande";
                        servingDesc = "Kanden fyldes en 3. del med is, appelsiner, lime og citroner" +
                                nt +
                                "Derefter tilsættes ingredienserne lag på lag";
                        ingredients = "6 cl. Smirnoff Vodka" +
                                nt +
                                "Appelsin skiver" +
                                nt +
                                "Lime både" +
                                nt +
                                "Citron skiver" +
                                nt +
                                "Lemonade";
                        garnish = "";
                        image = R.drawable.drinks_key_west_lemonade_kande;
                        break;
                    case "Whiskey Sour":
                        glassLine = "Krystalglas";
                        servingDesc = "Shakes med 4-5 isteringer";
                        ingredients = "4 cl. Jameson Whiskey" +
                                nt +
                                "2 cl . Monin Sugar Cane" +
                                nt +
                                "2 cl. Monin Rantcho Lemon";
                        garnish = "";
                        image = R.drawable.drinks_whiskey_sour;
                        break;
                    case "Bloody Mary":
                        glassLine = "Krystalglas";
                        servingDesc = "Glasset fyldes til en cm. under kanten med is" +
                                nt +
                                "Derefter tilsættes ingredienserne lag på lag";
                        ingredients = "4 cl. Smirnoff Vodka" +
                                nt +
                                "3 små dråber tabasco" +
                                nt +
                                "Tomat Juice";
                        garnish = "INFO: Spørgsmål fra gæsten ang salt, peber, og selleri. Så er det allerede i den tomat juice vi bruger";
                        image = R.drawable.drinks_bloody_mary;
                        break;
                    default:
                        glassLine = "";
                        servingDesc = "";
                        ingredients = "";
                        garnish = "";
                        image = R.drawable.blank;
                        break;
                }

                PacketRecipe temp = new PacketRecipe(line, glassLine, ingredients, servingDesc, garnish, image);
                packetDrinkList.add(temp);
            }
            bufferedReader.close();
            PacketRecipe packetRecipe = new PacketRecipe();
            Collections.sort(packetDrinkList, packetRecipe);


        } catch (IOException e) {
            Log.d("TESTINGREAD", e.getMessage());
        }
    }

    private void populateOelList() {
        InputStream inputStream = activity.getResources().openRawResource(activity.getResources().getIdentifier("oel", "raw", activity.getPackageName()));

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;

            while((line = bufferedReader.readLine()) != null) {

                String glassLine;
                int image;
                switch (line) {
                    case "Tuborg Flaskeøl": case "Carlsberg Flaskeøl": case "Guld Tuborg":
                        glassLine = "Intet. Serveres i flasken";
                        image = R.drawable.oel_flaskeoel;
                        break;
                    case "Budweiser":
                        glassLine = "Intet. Serveres i flasken";
                        image = R.drawable.oel_budweiser;
                        break;
                    case "Corona":
                        glassLine = "Intet. Serveres i flasken \n\nSæt et stykke lime i halsen på flasken. Så kan gæsten selv vælge om de vil have lime i eller ej.";
                        image = R.drawable.oel_corona;
                        break;
                    case "Hoegaarden Wit":
                        glassLine = "Stort fadølsglas";
                        image = R.drawable.oel_hoegaarden_wit;
                        break;
                    case "Grimbergen Double-Ambree":
                        glassLine = "Grimbergen glas";
                        image = R.drawable.oel_grimbergen_double_ambree;
                        break;
                    case "Erdinger Weissbier":
                        glassLine = "Erdinger glas";
                        image = R.drawable.oel_erdinger_weissbier;
                        break;
                    default:
                        glassLine = "i et glas";
                        image = R.drawable.blank;
                        break;
                }

                PacketRecipe temp = new PacketRecipe(line, glassLine, "", "", "", image);
                packetOelList.add(temp);
            }
            bufferedReader.close();
            PacketRecipe packetRecipe = new PacketRecipe();
            Collections.sort(packetOelList, packetRecipe);


        } catch (IOException e) {
            Log.d("TESTINGREAD", e.getMessage());
        }
    }

    private void populateSjusserList() {
        InputStream inputStream = activity.getResources().openRawResource(activity.getResources().getIdentifier("sjusser", "raw", activity.getPackageName()));

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            String glassLine; //glass type
            int image;

            while((line = bufferedReader.readLine()) != null) {

                switch (line) {
                    case "Ron Zacapa":
                        glassLine = "Ron Zacapa glas";
                        image = R.drawable.sjusser_ron_zacapa;
                        break;
                    case "Ron Zacapa OX":
                        glassLine = "Ron Zacapa glas";
                        image = R.drawable.sjusser_ron_zacapa;
                        break;
                    case "Jack Daniels Honey":
                        glassLine = "Jack Daniel’s glas";
                        image = R.drawable.sjusser_jack_daniels_honey;
                        break;
                    case "Gentlemen Jack":
                        glassLine = "Jack Daniel’s glas";
                        image = R.drawable.sjusser_jack_daniels_honey;
                        break;
                    case "Jack Daniels Single Barrel":
                        glassLine = "Jack Daniel’s glas";
                        image = R.drawable.sjusser_jack_daniels_honey;
                        break;
                    default:
                        glassLine = "";
                        image = R.drawable.blank;
                        break;
                }

                PacketRecipe temp = new PacketRecipe(line, glassLine, "", "", "", image);
                packetSjusserList.add(temp);
            }
            bufferedReader.close();
            PacketRecipe packetRecipe = new PacketRecipe();
            Collections.sort(packetDrinkList, packetRecipe);

        } catch (IOException e) {
            Log.d("TESTINGREAD", e.getMessage());
        }
    }

    private void populateVarmeDrikkeList() {
        InputStream inputStream = activity.getResources().openRawResource(activity.getResources().getIdentifier("varme_drikke", "raw", activity.getPackageName()));

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            String glassLine; //glass type
            String ingredients;
            String servingDesc;
            String garnish;
            int image;

            while((line = bufferedReader.readLine()) != null) {

                switch (line) {
                    case "Irish Coffee":
                        glassLine = "Kaffeglas";
                        ingredients = "4 cl. Jameson Whiskey" +
                                nt +
                                "Kandispind" +
                                nt +
                                "Kaffe" +
                                nt +
                                "Flødeskum";
                        servingDesc = "Tilsæt Whiskey og Kandispind" +
                                nt +
                                "Derefter kaffe" +
                                nt +
                                "og til sidst flødeskum";
                        garnish = "";
                        image = R.drawable.varme_irish_coffee;
                        break;
                    case "Mexican Coffee":
                        glassLine = "Kaffeglas";
                        ingredients = "2 cl. Tequila" +
                                nt +
                                "2 cl. Kahlua" +
                                nt +
                                "Kaffe" +
                                nt +
                                "Flødeskum";
                        servingDesc = "Tilsæt Kahlua og tequila\n" +
                                "\n" +
                                "Derefter kaffe\n" +
                                "\n" +
                                "og til sidst flødeskum";
                        garnish = "";
                        image = R.drawable.varme_mexican_coffee;
                        break;
                    case "Kaffe & Baileys":
                        glassLine = "Kaffeglas";
                        ingredients = "4 cl. Baileys" +
                                nt +
                                "Kaffe";
                        servingDesc = "Tilsæt Baileys og kaffe";
                        garnish = "";
                        image = R.drawable.varme_kaffe_og_baileys;
                        break;
                    case "Spanish Coffee":
                        glassLine = "Kaffeglas";
                        ingredients = "4 cl. Licor 43" +
                                nt +
                                "Kaffe" +
                                nt +
                                "Flødeskum";
                        servingDesc = "Tilsæt Licor 43" +
                                nt +
                                "Derefter kaffe" +
                                nt +
                                "og til sidst flødeskum";
                        garnish = "";
                        image = R.drawable.varme_spanish_coffee;
                        break;
                    case "Hot Shots":
                        glassLine = "Højt shotsglas";
                        ingredients = "2 cl. Licor 43" +
                                nt +
                                "Kaffe" +
                                nt +
                                "Flødeskum";
                        servingDesc = "Tilsæt Licor 43" +
                                nt +
                                "Hold barskeen henover Licor 43’en og hæld kaffe på. Så det ligger sig i synlige lag" +
                                nt +
                                "og til sidst flødeskum";
                        garnish = "";
                        image = R.drawable.varme_hot_shots;
                        break;
                    default:
                        glassLine = "";
                        ingredients = "";
                        servingDesc = "";
                        garnish = "";
                        image = R.drawable.blank;
                        break;
                }

                PacketRecipe temp = new PacketRecipe(line, glassLine, ingredients, servingDesc, garnish, image);
                packetVarmeDrikkeList.add(temp);
            }
            bufferedReader.close();
            PacketRecipe packetRecipe = new PacketRecipe();
            Collections.sort(packetVarmeDrikkeList, packetRecipe);

        } catch (IOException e) {
            Log.d("TESTINGREAD", e.getMessage());
        }
    }
}
