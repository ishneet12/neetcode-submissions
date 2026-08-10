class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for (Character c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

       
        int maxEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for (int a : mp.values()) {
            if (a % 2 == 0) {
                maxEven = Math.min(maxEven, a);
            } else {
                maxOdd = Math.max(maxOdd, a);
            }
        }
        return maxOdd - maxEven;
    }
}