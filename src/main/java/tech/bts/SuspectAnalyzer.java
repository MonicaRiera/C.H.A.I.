package tech.bts;

public class SuspectAnalyzer {

    public boolean match (Suspect s1, Suspect s2) {
        if (s1.isMale() && s2.isMale()) {
            int points = 0;
            boolean differentHair = true;
            boolean differentEyes = true;

            if (s1.getName().toUpperCase().equals(s2.getName().toUpperCase())) {
                points++;
            }

            if (Math.abs(s1.getAge() - s2.getAge()) <= 1 ) {
                points++;
            }

            if (Math.abs(s1.getHeight() - s2.getHeight()) <= 2) {
                points++;
            }

            if (Math.abs(s1.getWeight() - s2.getWeight()) <= 5) {
                points++;
            }

            if (s1.getHairColor().toUpperCase().equals(s2.getHairColor().toUpperCase())) {
                points++;
                differentHair = false;
            }

            if (s1.getEyeColor().toUpperCase().equals(s2.getEyeColor().toUpperCase())) {
                points++;
                differentEyes = false;
            }

            if (points >= 5) {
                return true;
            } else if ( points >= 4 && differentEyes && differentHair) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}
