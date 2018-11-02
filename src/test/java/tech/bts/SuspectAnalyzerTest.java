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

        boolean matchResultWoman = suspectAnalyzer.match(new Suspect("Anna", 32, 165, 61, "blond", "blue", false),
                new Suspect("Anna", 32, 165, 61, "blond", "blue", false));
        assertEquals(true, matchResultWoman);
    }

    @Test
    public void very_similar() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();
        boolean matchResult = suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 40, 180, 86, "brown", "green", true));
        assertEquals(true, matchResult);

        boolean matchResultWoman = suspectAnalyzer.match(new Suspect("Anna", 32, 165, 61, "blond", "blue", false),
                new Suspect("Anna", 31, 165, 61, "blond", "brown", false));
        assertEquals(true, matchResultWoman);
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

        boolean matchResultWoman = suspectAnalyzer.match(new Suspect("Anna", 32, 165, 61, "blond", "blue", false),
                new Suspect("Anna", 33, 167, 58, "blond", "blue", false));
        assertEquals(true, matchResultWoman);

        boolean matchResultWoman2 = suspectAnalyzer.match(new Suspect("Anna", 32, 165, 61, "blond", "blue", false),
                new Suspect("Anna", 34, 170, 62, "blond", "blue", false));
        assertEquals(false, matchResultWoman2);
    }

    @Test
    public void different_suspects() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();
        boolean matchResult = suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("John", 29, 190, 86, "blond", "brown", true));
        assertEquals(false, matchResult);

        boolean matchResultWoman = suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Anna", 32, 165, 61, "blond", "blue", false));
        assertEquals(false, matchResultWoman);

    }

    @Test
    public void only_hair_and_eyes_change() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();
        boolean matchResult = suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 35, 180, 86, "blond", "black", true));
        assertEquals(true, matchResult);

        boolean matchResultWoman = suspectAnalyzer.match(new Suspect("Anna", 32, 165, 61, "blond", "blue", false),
                new Suspect("Anna", 32, 165, 61, "brown", "green", false));
        assertEquals(true, matchResultWoman);
    }




}
