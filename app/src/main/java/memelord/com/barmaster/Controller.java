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

    private ArrayList<PacketRecipe> packetOelList;
    private ArrayList<PacketRecipe> packetDrinkList;
    private ArrayList<PacketRecipe> packetSjusserList;
    private ArrayList<PacketRecipe> packetVarmeDrikkeList;

    private Controller(Activity activity) {
        //private constructor
        this.activity = activity;

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
            ArrayList<String> lines;
            int image;
            String glassLine; //glass type
            String denRigtigeVersion;
            String ingredients;
            String servingDesc;
            String garnish;

            while((line = bufferedReader.readLine()) != null) {

                switch (line) {
                    case "Moscow Mule":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Vodka");
                        lines.add("\tGinger Beer");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tGlasset fyldes til en cm. under kanten med is");
                        lines.add("\tDerefter tilsættes ingredienserne lag på lag");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\tLime skiver");

                        image = R.drawable.drinks_moscow_mule;
                        break;
                    case "White Russian":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t2 cl. Smirnoff Vodka");
                        lines.add("\t2 cl. Kahlua");
                        lines.add("\tMælk");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tShaker/glas fyldes med en skefuld is");
                        lines.add("\tDerefter tilsættes ingredienserne og shakes");
                        lines.add("");
                        lines.add("BONUS:");
                        lines.add("\tDer kan max shake 2 ad gangen");
                        lines.add("\tSPØRG evt gæsten; \"skal den shakes?\"");

                        image = R.drawable.drinks_white_russian;
                        break;
                    case "Tom Collins":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        garnish = "Citron skiver";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Tanqueray Gin");
                        lines.add("\t2 cl. Monin Lemon Rantcho");
                        lines.add("\t2 cl. Monin Pure Sugar Cane");
                        lines.add("\t4 halve citronskiver");
                        lines.add("\tDanskvand");
                        lines.add("\tIsterninger");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tPut Gin, Lemon, Sugar Cane, Halve Citronskiver");
                        lines.add("\tTilsæt isterninger");
                        lines.add("\tShaker");
                        lines.add("\tToppes med danskvand");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\t" + garnish);
                        image = R.drawable.drinks_tom_collins;
                        break;
                    case "Strawberry Daiquiri":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        garnish = "2 lime både";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Bacardi Rom");
                        lines.add("\t2 cl. Monin Lemon Rantcho");
                        lines.add("\t2 cl. Monin Fraise");
                        lines.add("\t3 sec jævnt tryk - Monin Pure Jordbær");
                        lines.add("\tPræcis 1 skefuld is med den sorte isske");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tPut alle ingredienserne i blenderen");
                        lines.add("\tKør på program 4");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\t" + garnish);

                        image = R.drawable.drinks_strawberry_daiquiri;
                        break;
                    case "Mango Daiquiri":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        garnish = "2 lime både";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Bacardi Rom");
                        lines.add("\t2 cl. Monin Lemon Rantcho");
                        lines.add("\t2 cl. Monin Fraise");
                        lines.add("\t3 sec jævnt tryk - Monin Pure Mango");
                        lines.add("\tPræcis 1 skefuld is med den sorte isske");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tPut alle ingredienserne i blenderen");
                        lines.add("\tKør på program 4");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\t" + garnish);
                        image = R.drawable.drinks_mango_daiquiri;
                        break;
                    case "Mango Margarita":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        garnish = "2 lime både";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Tequila");
                        lines.add("\t2 cl. Monin Lemon Rantcho");
                        lines.add("\t2 cl. Monin Fraise");
                        lines.add("\t3 sec jævnt tryk - Monin Pure Mango");
                        lines.add("\tPræcis 1 skefuld is med den sorte isske");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tPut alle ingredienserne i blenderen");
                        lines.add("\tKør på program 4");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\t" + garnish);
                        image = R.drawable.drinks_mango_margarita;
                        break;
                    case "Pina Colada":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        servingDesc = "Bland alle ingredienserne.\n" +
                                nt +
                                "Shakes";
                        garnish = "Appelsin skiver";
                        garnish = "2 lime både";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Bacardi Rom");
                        lines.add("\t1,5 - 2 cl. Monin Coco");
                        lines.add("\t8 cl. ananas juice");
                        lines.add("\tEt lag med 2 cm isterninger");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tBland alle ingredienserne");
                        lines.add("\tShakes");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\t" + garnish);
                        image = R.drawable.drinks_pina_colada;
                        break;
                    case "Dark 'n' Stormy":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        garnish = "2 Lime både";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Bacardi 8 års rom");
                        lines.add("\t5 dråber Angostrua bitter");
                        lines.add("\t2 cl. Monin Lime Juice");
                        lines.add("\t2 cl. Monin Sugar Cane");
                        lines.add("\tGinger Beer");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tRom, Angostrua, Lime Juice, Sugar Cane i shaker");
                        lines.add("\tShakes og toppes med Ginger Beer");
                        lines.add("");
                        lines.add("Den rigtige måde:");
                        lines.add("\tFyld 2/3 af glasset med Ginger Beer, sukker og juice");
                        lines.add("\tHæld rommen i glasset, så det ligner et stormvejr");
                        lines.add("\t(hold det bitter væk fra drinken)");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\t" + garnish);
                        image = R.drawable.drinks_dark_and_stormy;
                        break;
                    case "Old Fashioned":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t6 cl. Jack Daniels");
                        lines.add("\t3 dråber Angostrua bitter");
                        lines.add("\t1 cl. Monin Pure Sugar Cane");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tGlasset fyldes med KUN 4 isterninger");
                        lines.add("\tDerefter tilsættes ingredienserne lag på lag");
                        lines.add("");
                        lines.add("Den rigtige måde:");
                        lines.add("\tBland spsk. sukker med 2-4 dashes ");
                        lines.add("\taf bitter og mas det sammen");
                        lines.add("\tfyld isterninger i glasset og hæld whisky'en i");

                        image = R.drawable.drinks_tennessee_old_fashioned;
                        break;
                    case "Long Island Iced Tea":
                        lines = new ArrayList<>();
                        glassLine = "Stor fadølsglas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t2 cl. Vodka");
                        lines.add("\t2 cl. Bacardi Rom");
                        lines.add("\t2 cl. Gin");
                        lines.add("\t2 cl. Tequila");
                        lines.add("\t2 cl. Cointreau");
                        lines.add("\t2 cl. Monin Lime Juice");
                        lines.add("\tCola");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tPut 6 cl. Cola i glasset");
                        lines.add("\tPut al spiritus og lime juice i en shaker");
                        lines.add("\tShakers og hænges over Cola");

                        image = R.drawable.drinks_long_island_iced_tea;
                        break;
                    case "Cuba Libre":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        garnish = "Lime både";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Bacardi Rom");
                        lines.add("\tCola");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tGlasset fyldes til en cm. under kanten med is");
                        lines.add("\tDerefter tilsættes ingredienserne lag på lag");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\t" + garnish);
                        image = R.drawable.drinks_cuba_libre;
                        break;
                    case "Harvey Wallbanger":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        servingDesc = "Glasset fyldes til en cm. under kanten med is" +
                                nt +
                                "Derefter tilsættes ingredienserne lag på lag";

                        garnish = "Appelsin skriver";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t2 cl. Smirnoff Vodka");
                        lines.add("\tLicor 43");
                        lines.add("\tAppelsin Juice");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tGlasset fyldes til en cm. under kanten med is");
                        lines.add("\tDerefter tilsættes ingredienserne lag på lag");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\t" + garnish);
                        image = R.drawable.drinks_harvey_wallbanger;
                        break;
                    case "Gin & Tonic":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        garnish = "Agurk eller lime";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t2 cl. Tanqueray Gin");
                        lines.add("\tSchweppes Tonic");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tGlasset fyldes til en cm. under kanten med is");
                        lines.add("\tDerefter tilsættes ingredienserne lag på lag");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\t" + garnish);
                        image = R.drawable.drinks_gin_and_tonic;
                        break;
                    case "Gin & Lemon":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        garnish = "Lime skive";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t2 cl. Tanqueray Gin");
                        lines.add("\tSchweppes Lemon (Postmix)");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tGlasset fyldes til en cm. under kanten med is");
                        lines.add("\tDerefter tilsættes ingredienserne lag på lag");
                        lines.add("");
                        lines.add("Pynt:");
                        lines.add("\t" + garnish);
                        image = R.drawable.drinks_gin_and_lemon;
                        break;
                    case "Rød Ninja":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t2 cl. Smirnoff Raspberry");
                        lines.add("\tPassionssodavand");
                        lines.add("\tToppes med Grenadine");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tGlasset fyldes til en cm. under kanten med is");
                        lines.add("\tDerefter tilsættes ingredienserne lag på lag");
                        lines.add("");
                        image = R.drawable.drinks_roed_ninja;
                        break;
                    case "Key West Lemonade, Glas":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t2 cl. Smirnoff Vodka");
                        lines.add("\tAppelsin skiver");
                        lines.add("\tLime både");
                        lines.add("\tCitron skiver");
                        lines.add("\tLemonade");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tGlasset fyldes halvt med is, appelsiner, lime og citroner");
                        image = R.drawable.drinks_key_west_lemonade_glas;
                        break;
                    case "Key West Lemonade, Kande":
                        lines = new ArrayList<>();
                        glassLine = "Kande";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t6 cl. Smirnoff Vodka");
                        lines.add("\tAppelsin skiver");
                        lines.add("\tLime både");
                        lines.add("\tCitron skiver");
                        lines.add("\tLemonade");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tKanden fyldes en 3. del med is, appelsiner, lime og citroner");
                        lines.add("\tDerefter tilsættes ingredienserne lag på lag");

                        image = R.drawable.drinks_key_west_lemonade_kande;
                        break;
                    case "Whiskey Sour":
                        lines = new ArrayList<>();
                        glassLine = "Krystalglas";
                        servingDesc = "Shakes med 4-5 isteringer";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Jameson Whiskey");
                        lines.add("\t2 cl . Monin Sugar Cane");
                        lines.add("\t2 cl. Monin Rantcho Lemon");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tShakes med 4-5 isteringer");
                        image = R.drawable.drinks_whiskey_sour;
                        break;
                    case "Bloody Mary":
                        lines = new ArrayList<>();
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
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Smirnoff Vodka");
                        lines.add("\t3 små dråber tabasco");
                        lines.add("\tTomat Juice");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tGlasset fyldes til en cm. under kanten med is");
                        lines.add("\tDerefter tilsættes ingredienserne lag på lag");
                        lines.add("");
                        lines.add("INFO:");
                        lines.add("\tSpørgsmål fra gæsten ang salt, peber, og selleri.");
                        lines.add("\tSå er det allerede i den tomat juice vi bruger");
                        image = R.drawable.drinks_bloody_mary;
                        break;
                    default:
                        lines = new ArrayList<>();

                        image = R.drawable.blank;
                        break;
                }

                PacketRecipe temp = new PacketRecipe(line, "", "", "", "", image);
                temp.setLines(lines);
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
            ArrayList<String> lines;
            int image;
            String glassLine; //glass type

            while((line = bufferedReader.readLine()) != null) {

                switch (line) {
                    case "Tuborg Flaskeøl": case "Carlsberg Flaskeøl": case "Guld Tuborg":
                        lines = new ArrayList<>();
                        glassLine = "Intet. Serveres i flasken";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.oel_flaskeoel;
                        break;
                    case "Budweiser":
                        lines = new ArrayList<>();
                        glassLine = "Intet. Serveres i flasken";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.oel_budweiser;
                        break;
                    case "Corona":
                        lines = new ArrayList<>();
                        glassLine = "Intet. Serveres i flasken";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        lines.add("Info:");
                        lines.add("\tSæt et stykke lime i halsen på flasken,");
                        lines.add("\tså kan gæsten selv vælge om ");
                        lines.add("\tde vil have lime i eller ej");
                        image = R.drawable.oel_corona;
                        break;
                    case "Hoegaarden Wit":
                        lines = new ArrayList<>();
                        glassLine = "Stort fadølsglas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.oel_hoegaarden_wit;
                        break;
                    case "Grimbergen Double-Ambree":
                        lines = new ArrayList<>();
                        glassLine = "Grimbergen glas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.oel_grimbergen_double_ambree;
                        break;
                    case "Erdinger Weissbier":
                        lines = new ArrayList<>();
                        glassLine = "Erdinger glas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.oel_erdinger_weissbier;
                        break;
                    default:
                        lines = new ArrayList<>();
                        image = R.drawable.blank;
                        break;
                }

                PacketRecipe temp = new PacketRecipe(line, "", "", "", "", image);
                temp.setLines(lines);
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

            ArrayList<String> lines;
            String line;
            int image;
            String glassLine; //glass type

            while((line = bufferedReader.readLine()) != null) {

                switch (line) {
                    case "Ron Zacapa":
                        lines = new ArrayList<>();
                        glassLine = "Ron Zacapa glas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.sjusser_ron_zacapa;
                        break;
                    case "Ron Zacapa OX":
                        lines = new ArrayList<>();
                        glassLine = "Ron Zacapa glas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.sjusser_ron_zacapa;
                        break;
                    case "Jack Daniels Honey":
                        lines = new ArrayList<>();
                        glassLine = "Jack Daniel’s glas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.sjusser_jack_daniels_honey;
                        break;
                    case "Gentlemen Jack":
                        lines = new ArrayList<>();
                        glassLine = "Jack Daniel’s glas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.sjusser_jack_daniels_honey;
                        break;
                    case "Jack Daniels Single Barrel":
                        lines = new ArrayList<>();
                        glassLine = "Jack Daniel’s glas";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.sjusser_jack_daniels_honey;
                        break;
                    default:
                        lines = new ArrayList<>();
                        glassLine = "";
                        lines.add("Glas:");
                        lines.add("\t" + glassLine);
                        image = R.drawable.blank;
                        break;
                }

                PacketRecipe temp = new PacketRecipe(line, "", "", "", "", image);
                temp.setLines(lines);
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

            ArrayList<String> lines;
            String line;
            int image;

            while((line = bufferedReader.readLine()) != null) {

                switch (line) {
                    case "Irish Coffee":
                        lines = new ArrayList<>();
                        lines.add("Glas:");
                        lines.add("\tKaffeglas");
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Jameson Whiskey");
                        lines.add("\tKandispind");
                        lines.add("\tKaffe");
                        lines.add("\tFlødeskum");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tTilsæt whiskey og kandispind");
                        lines.add("\tDerefter kaffe");
                        lines.add("\tog til sidst flødeskum");

                        image = R.drawable.varme_irish_coffee;
                        break;
                    case "Mexican Coffee":
                        lines = new ArrayList<>();
                        lines.add("Glas:");
                        lines.add("\tKaffeglas");
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t2 cl. Tequila");
                        lines.add("\t2 cl. Kahlua");
                        lines.add("\tKaffe");
                        lines.add("\tFlødeskum");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tTilsæt Kahlua og tequila");
                        lines.add("\tDerefter kaffe");
                        lines.add("\tog til sidst flødeskum");

                        image = R.drawable.varme_mexican_coffee;
                        break;
                    case "Kaffe & Baileys":
                        lines = new ArrayList<>();
                        lines.add("Glas:");
                        lines.add("\tKaffeglas");
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Baileys");
                        lines.add("\tKaffe");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tTilsæt Baileys og kaffe");

                        image = R.drawable.varme_kaffe_og_baileys;
                        break;
                    case "Spanish Coffee":
                        lines = new ArrayList<>();
                        lines.add("Glas:");
                        lines.add("\tKaffeglas");
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t4 cl. Licor 43");
                        lines.add("\tKaffe");
                        lines.add("\tFlødeskum");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tTilsæt Licor 43");
                        lines.add("\tDerefter kaffe");
                        lines.add("\tog til sidst flødeskum");

                        image = R.drawable.varme_spanish_coffee;
                        break;
                    case "Hot Shots":
                        lines = new ArrayList<>();
                        lines.add("Glas:");
                        lines.add("\tHøjt shotsglas");
                        lines.add("");
                        lines.add("Ingredienser:");
                        lines.add("\t2 cl. Licor 43");
                        lines.add("\tKaffe");
                        lines.add("\tFlødeskum");
                        lines.add("");
                        lines.add("Fremgangsmåde:");
                        lines.add("\tTilsæt Licor 43");
                        lines.add("\tHold barskeen henover Licor 43’en");
                        lines.add("\tog hæld kaffe på, så det ligger sig i synlige lag");
                        lines.add("\tog til sidst flødeskum");

                        image = R.drawable.varme_hot_shots;
                        break;
                    default:
                        lines = new ArrayList<>();

                        image = R.drawable.blank;
                        break;
                }

                PacketRecipe temp = new PacketRecipe(line, "", "", "", "", image);
                temp.setLines(lines);
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
