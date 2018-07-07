package Function;

public class Success implements Function {

    public String checkKey(String score) {
        return score.contains("maj") ? score : score.replace("min", "maj");
    }


    @Override
    public String getKey() {
        return null;
    }
}
