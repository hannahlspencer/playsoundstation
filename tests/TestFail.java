import Genre.Genre;

public class TestFail implements Genre {
    @Override
    public String selectInstruments() {
        //not implemented as testing for reflection exception
        return null;
    }

    @Override
    public String setBassline(String score) {
        //not implemented as testing for reflection exception
        return null;
    }
}

