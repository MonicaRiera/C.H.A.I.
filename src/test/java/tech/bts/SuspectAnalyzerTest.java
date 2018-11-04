package tech.bts;

import org.junit.Test;
import static org.junit.Assert.*;

public class SuspectAnalyzerTest {

    @Test
    public void equal_suspects() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();

        assertTrue(suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 35, 180, 86, "brown", "green", true)));

        assertTrue(suspectAnalyzer.match(new Suspect("Anna", 32, 165, 61, "blond", "blue", false),
                new Suspect("Anna", 32, 165, 61, "blond", "blue", false)));
    }

    @Test
    public void very_similar() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();

        assertTrue(suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 40, 180, 86, "brown", "green", true)));

        assertTrue(suspectAnalyzer.match(new Suspect("Anna", 32, 165, 61, "blond", "blue", false),
                new Suspect("Anna", 31, 165, 61, "blond", "brown", false)));
    }

    @Test
    public void quite_similar() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();

        assertTrue(suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 36, 178, 89, "brown", "blue", true)));

        assertFalse(suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Toni", 36, 170, 86, "brown", "blue", true)));

        assertTrue(suspectAnalyzer.match(new Suspect("Anna", 32, 165, 61, "blond", "blue", false),
                new Suspect("Anna", 33, 167, 58, "blond", "blue", false)));

        assertFalse(suspectAnalyzer.match(new Suspect("Anna", 32, 165, 61, "blond", "blue", false),
                new Suspect("Anna", 34, 170, 62, "blond", "blue", false)));
    }

    @Test
    public void different_suspects() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();

        assertFalse(suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("John", 29, 190, 86, "blond", "brown", true)));

        assertFalse(suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Anna", 32, 165, 61, "blond", "blue", false)));

    }

    @Test
    public void only_hair_and_eyes_change() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();

        assertTrue(suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 35, 180, 86, "blond", "black", true)));

        assertTrue(suspectAnalyzer.match(new Suspect("Anna", 32, 165, 61, "blond", "blue", false),
                new Suspect("Anna", 32, 165, 61, "brown", "green", false)));
    }

    @Test
    public void only_gender_changes() {
        SuspectAnalyzer suspectAnalyzer = new SuspectAnalyzer();

        assertFalse(suspectAnalyzer.match(new Suspect("Tony", 35, 180, 86, "brown", "green", true),
                new Suspect("Tony", 35, 180, 86, "brown", "green", false)));
    }




}
