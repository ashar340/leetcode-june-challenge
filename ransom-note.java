import java.util.HashMap;
import java.util.Map;

/* 
383. Ransom Note

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

You may assume that both strings contain only lowercase letters. 
*/

//Simulation Approach - We can simulate the process and determine whether or not the ransom note be constructed, if we dont have a character we need to constuct the note int he magazine, we simply return false, or we return true.
class Solution {
    public boolean ransomNote_Simulation(String note, String magazine) {
        for (char c : note.toCharArray()) {
            // Looking for the first occurence
            int i = magazine.indexOf(c);

            if (i == -1) {
                return false;
            }

            magazine = magazine.substring(0, i) + magazine.substring(i + 1);
        }

        return true;
    }

    // Method to create a hashmap of counts from the given string
    private Map<Character, Integer> countMap(String a) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : a.toCharArray()) {
            int currCount = counts.getOrDefault(c, 0);
            counts.put(c, currCount + 1);
        }
        return counts;
    }

    public boolean ransomNote_hashmap(String note, String magazine) {

        if (note.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> noteCount = countMap(note);
        Map<Character, Integer> magazineCount = countMap(magazine);

        for (char c : noteCount.keySet()) {
            // Is count of char in magazine >= note char count
            int magazine_count_char = magazineCount.getOrDefault(c, 0);

            int note_count_char = noteCount.get(c);

            if (magazine_count_char < note_count_char) {
                return false;
            }
        }

        // if the above runthrough is possible, then we return true since the note can
        // be constructed

        return true;
    }

}