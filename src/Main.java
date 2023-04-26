import java.util.*;

public class Main {
    public static void main(String[] args) {

        Hashtable h = new Hashtable();

        h.put("fruit", "grape");
        h.put("fruit2", "apple");


        char[] arr1 = {'a', 'b', 'c', 'd'};
        char[] arr2 = {'z', 'y', 'b'};

        Random rn = new Random();

        int num = rn.nextInt(20);

        System.out.println(firstNonRepeatingCharacter("loveleetcode"));
    }


    public static char firstNonRepeatingCharacter(String s) {

        Map<Character, Integer> frequency = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequency.put(c, frequency.getOrDefault(c,0) + 1);
        }

        for (int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            System.out.println("character value :" + c + " " + frequency.get(c));
            if(frequency.get(c) == 1) {
                return c;
            }
        }

        return '-';
    }

    // it finds the longest substring in the given string.
    // for instance, abcabcab will be abc - 3 characters
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int length = 0;

        while (end < s.length()) {
            if(map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) >= start) {
                start = map.get(s.charAt(end)) + 1;
            }

            map.put(s.charAt(end), end);

            length = Math.max(length, end - start + 1);

        }
        return length;
    }

    // If there is a common character betwen two different arrays
    public static boolean findCommonCharacter(char[] arr1, char[] arr2) {

        Set<Character> res = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            res.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (res.contains(arr2[i])) {
                return true;
            }
        }

        return false;
    }

    //Find the first recurring number in given array
    public static int findFirstRecurringNumber(int[] arr) {

        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(!res.containsKey(arr[i])) {
                res.put(arr[i], +1);
            } else {
                return arr[i];
            }
        }

        return -1;
    }

    public static boolean checkLastIndex(int[] arr) {

        int lastIndexGoodPosition = arr.length -1;

        for (int i = arr.length -1; i >= 0; i --) {
            if (i + arr[i] >= lastIndexGoodPosition) {
                lastIndexGoodPosition = i;
            }
        }
        return lastIndexGoodPosition == 0;
    }


    // right method and understand how stack is working!!!!!!!!
    public static int[] testingStacks(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(Integer i : arr) {
            if(!stack.contains(i)) {
                stack.push(i);
            }
        }

        int[] result = new int[stack.size()];
        int count = 0;

        System.out.println(stack.size());

        while(!stack.isEmpty()) {
            int temp = stack.pop();
            result[count++] = temp;

        }

        for (Integer j : result) {
            System.out.println(j);
        }

        return result;

    }


    // Binary search
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right -  left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }


    // remove duplicate characters from String
    public static String removeDuplicates(String str){
        Set<Character> s = new HashSet<>();
        StringBuilder sb = new StringBuilder();


        for(char c : str.toCharArray()) {
            s.add(c);
        }

        for(char a : s){
            sb.append(a);
        }

        return sb.toString();
    }

    public static boolean isPalindrome(String str){
        int n = str.length();

        for(int i = 0; i < n / 2; i++) {
            if(str.charAt(i) != str.charAt(n - 1 - i)){
                return false;
            }
        }

        return true;
    }

    private static int[] plusOne(int[] arr) {
        int m = arr.length -1;
        for(int i = m; i>=0; i--){
            if(arr[i] < 9) {
                arr[i]++;
                return arr;
            }

        }

        return arr;
    }

    //merge sorted arrays
    private static int[] mergeArrays(int[] arr1, int m, int[] arr2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i >= 0 && j >= 0) {
            if(arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        for (int t = 0; t < arr1.length; t++) {
            System.out.println(arr1[t]);
        }

        return arr1;
    }




    // frequenceSOrt agorithm  --  Entre tree -> eert, Aabb -> bbAa
    public static String frequenceSort(String s) {

        if (s == null || s.length() == 0) {return null;}

        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> ccount = new HashMap<>();

        for(char c: s.toCharArray()) {
            ccount.put(c, ccount.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> ccount.get(b) - ccount.get(a));

        for(char c: ccount.keySet()) {
            maxHeap.add(c);
        }

        while(!maxHeap.isEmpty()) {
            char cur = maxHeap.remove();
            int count = ccount.get(cur);
            for(int i = 0; i < count; i++){
                sb.append(cur);
            }
        }

        return sb.toString();
    }

}