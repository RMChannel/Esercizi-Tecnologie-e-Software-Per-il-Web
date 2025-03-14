package Model;

import java.util.ArrayList;

public class BeerExpert {
    private ArrayList<String> adivces;

    public ArrayList<String> getAdivces() {
        return adivces;
    }

    public BeerExpert(String color) {
        adivces = new ArrayList<>();
        if(color.equals("light")) {
            adivces.add("Heineken");
            adivces.add("Desperados");
        }
        else if(color.equals("dark")) {
            adivces.add("Blacksmith");
            adivces.add("Dunkel");
        }
        else if(color.equals("brown")) {
            adivces.add("AleSmith Nut Brown Ale");
            adivces.add("Lazy Magnolia Southern Pecan");
        }
        else if(color.equals("amber")) {
            adivces.add("Omission Beer Pale Ale");
            adivces.add("Portland Brewing MacTarnahan's");
        }
        else {
            System.err.println("Se accade questa casistica, buttati, non hai più speranze");
        }
    }
}
