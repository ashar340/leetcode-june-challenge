/* 451. Sort Characters By Frequency
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String sortByFrequency_HashmapSort(String str) {

        // How many occurances?
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // List of keys by times they appeared
        List<Character> chars = new ArrayList<>(freqMap.keySet());

        Collections.sort(chars, (x, y) -> freqMap.get(y) - freqMap.get(x));

        // String conversion through StringBuilder
        StringBuilder s = new StringBuilder();
        for (char x : chars) {
            int duplicates = freqMap.get(x);
            for (int i = 0; i < duplicates; i++) {
                s.append(x);
            }
        }
        return s.toString();
    }

}