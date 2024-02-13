// Name: Monisha Jain
// Qualificaton: MCA
// College: PES(Bengaluru)

// Problem Statement:
// Given a string, determine the length of the longest palindrome that can be constructed using the characters from the string. Return the maximum possible length of the palindromic string.

// Examples:

// Input: "applepie"
// Expected Output: 5
// Justification: The longest palindrome that can be constructed from the string is "pepep", which has a length of 5. There are are other palindromes too but they all will be of length 5.
// Input: "aabbcc"
// Expected Output: 6
// Justification: We can form the palindrome "abccba" using the characters from the string, which has a length of 6.
// Input: "bananas"
// Expected Output: 5
// Justification: The longest palindrome that can be constructed from the string is "anana", which has a length of 5.


import java.util.*;

public class longestPalindrome1 {
    
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> myHashMap = new HashMap<>();

        // populate the hashmap with character frequencies
        for(char c: s.toCharArray()) {
            myHashMap.put(c, myHashMap.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean oddFound = false;

        for(int freq: myHashMap.values()) {
            if(freq % 2 == 0) {
                length = length + freq;
            } else {  //odd
                length = length + freq - 1;
                oddFound = true;
            }
        }
        if(oddFound) {
            length++;
        }

        return length;
    }
    public static void main(String[] args) {
        longestPalindrome1 obj = new longestPalindrome1();
        System.out.println(obj.longestPalindrome("bananas"));  // Expected output: 5
        System.out.println(obj.longestPalindrome("applepie")); // Expected output: 5
        System.out.println(obj.longestPalindrome("racecar"));  // Expected output: 7
    }
}


// Even Frequencies:

// For characters with even frequencies, we can use all of them in the palindrome. For our string, the character 'n' has an even frequency.
// 'n' can contribute 2 characters.
// So far, we have a contribution of 2 characters to the palindrome.
// Odd Frequencies:

// For characters with odd frequencies, we can use all but one of them in the palindrome. The central character of the palindrome can be any character with an odd frequency.
// For our string, characters 'b', 'a', and 's' have odd frequencies.
// 'b' can contribute 0 characters (leaving out 1).
// 'a' can contribute 2 characters (leaving out 1).
// 's' can contribute 0 characters (leaving out 1).
// Additionally, one of the characters left out from the odd frequencies can be used as the central character of the palindrome. Let's use 'a' for this purpose.
// So, from the odd frequencies, we have a contribution of 2 characters to the palindrome, plus 1 for the central character.


// Time Complexity:
// Iterating through the string: We iterate through the entire string once to count the frequency of each character. This operation takes (O(n)) time, where (n) is the length of the string.

// Iterating through the hashmap: After counting the frequencies, we iterate through the hashmap to determine how many characters can be used to form the palindrome. In the worst case, this would be (O(26)) for the English alphabet, which is a constant time. However, in general terms, if we consider any possible character (not just English alphabet), this would be (O(k)), where (k) is the number of unique characters in the string. But since , this can also be considered (O(n)) in the worst case.

// Space Complexity:
// Hashmap for character frequencies: The space taken by the hashmap is proportional to the number of unique characters in the string. In the worst case, this would be (O(26)) for the English alphabet, which is a constant space. However, in general terms, if we consider any possible character (not just English alphabet), this would be (O(k)), where (k) is the number of unique characters in the string. But since , this can also be considered (O(n)) in the worst case.

// Thus, the space complexity of the algorithm is (O(n)).