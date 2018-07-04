package Mood;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Happy implements Mood {

    //Happy requires a major key, so this method selects a random key and ensures it's major
    @Override
    public String findKey() {
        //decides a random note for the key to be in
        String[] letters = {"A", "B", "C", "D", "E", "F", "G"};
        String key = letters[(int) (Math.random() * letters.length)];
        //decides whether the key should be sharp, flat, or neither
        String[] sharpOrFlat = {"#", "b", ""};
        key = key + sharpOrFlat[(int) (Math.random() * sharpOrFlat.length)];
        //adds major on the end to ensure it's in a major key
        return key + "maj";
    }

    @Override
    public String addPercussion() {
        return null;
    }

    @Override
    public String decideTempo() {
        return null;
    }
}
