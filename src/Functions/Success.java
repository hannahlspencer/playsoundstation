package Functions;

public class Success implements Function {
    @Override
    public String checkKey(String score) {
        return score.contains("maj") ? score : score.replace("min", "maj");
    }


}
