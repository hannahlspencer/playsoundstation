package Mood;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Happy implements Mood {

    //Happy requires a major key, so this method selects a random key and ensures it's major
    @Override
    public String setKey() {

        //adds major on the end to ensure it's in a major key
        return "maj";
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
