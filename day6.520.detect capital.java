class Solution {
    public boolean detectCapitalUse(String word) {

        if (word.equals(word.toUpperCase())) {
            return true;
        }

        if (word.equals(word.toLowerCase())) {
            return true;
        }

        String firstCapital =
                Character.toUpperCase(word.charAt(0))
                + word.substring(1).toLowerCase();

        return word.equals(firstCapital);
    }
}
