package Mood;

public interface Mood {

    /**
     * These variables are what defines the mood sounds ie. Major vs. Minor key, the speed of the piece, the percussive
     * instruments used (eg. a more downbeat piece would use more muted instruments), and the frequency of the
     * percussive beats (eg. the more beats in a bar, the more upbeat/exciting the song will sound)
     */
    String key = "";
    int[] tempoRange = new int[0];
    char[] percussiveInstruments = new char[0];
    int beats = 0;
    
    String getKey();
    int[] getTempoRange();
    int getBeats();
    char[] getPercussiveInstruments();

}
