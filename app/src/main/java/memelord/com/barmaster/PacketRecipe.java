package memelord.com.barmaster;

import android.content.res.Resources;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Christoffer on 26/12/2017.
 */

public class PacketRecipe implements Serializable, Comparator<PacketRecipe> {

    private String drinkName;
    private String glassType;
    private String ingredients;
    private String servingDesc;
    private String garnish;
    private int drinkImage;
    private ArrayList<String> lines;

    public PacketRecipe(String drinkName, String glassType, String ingredients, String servingDesc, String garnish, int drinkImage) {
        this.drinkName = drinkName;
        this.glassType = glassType;
        this.ingredients = ingredients;
        this.servingDesc = servingDesc;
        this.garnish = garnish;
        this.drinkImage = drinkImage;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }

    public PacketRecipe() {}

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public String getServingDesc() {
        return servingDesc;
    }

    public void setServingDesc(String servingDesc) {
        this.servingDesc = servingDesc;
    }

    public int getDrinkImage() {
        return drinkImage;
    }

    public void setDrinkImage(int drinkImage) {
        this.drinkImage = drinkImage;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getGarnish() {
        return garnish;
    }

    public void setGarnish(String garnish) {
        this.garnish = garnish;
    }

    @Override
    public int compare(PacketRecipe o1, PacketRecipe o2) {
        return o1.drinkName.compareToIgnoreCase(o2.drinkName);
    }
}
