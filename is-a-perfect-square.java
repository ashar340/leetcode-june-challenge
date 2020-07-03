/* 

367. Valid Perfect Square
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false
 

Constraints:

1 <= num <= 2^31 - 1 

*/

class Solution {
    public boolean perfectSquare_BinarySearch(int n) {
        if (n < 2) {
            return true;
        }

        long l = 2;
        long r = n / 2;
        long z, couldBeSquare;

        while (l <= r) {
            z = l + (r - l) / 2;
            couldBeSquare = z * z;
            if (couldBeSquare == n) {
                return true;
            }
            if (couldBeSquare > n) {
                r = z - 1;
            } else {
                l = z + 1;
            }
        }
        return false;
    }
}
