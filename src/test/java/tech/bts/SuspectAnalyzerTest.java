package tech.bts;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SuspectAnalyzerTest {

    @Test
    public void equal_suspects() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();
        boolean matchResult = suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 35, 180, 86, "brown", "green", true));
        assertEquals(true, matchResult);
    }

    @Test
    public void very_similar() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();
        boolean matchResult = suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 40, 180, 86, "brown", "green", true));
        assertEquals(true, matchResult);
    }

    @Test
    public void quite_similar() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();
        boolean matchResult = suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 36, 178, 89, "brown", "blue", true));
        assertEquals(true, matchResult);

        boolean matchResult2 = suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Toni", 36, 170, 86, "brown", "blue", true));
        assertEquals(false, matchResult2);
    }

    @Test
    public void different_suspects() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();
        boolean matchResult = suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("John", 29, 190, 86, "blond", "brown", true));
        assertEquals(false, matchResult);

    }

    @Test
    public void only_hair_and_eyes_change() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();
        boolean matchResult = suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 35, 180, 86, "blond", "black", true));
        assertEquals(true, matchResult);
    }




}
