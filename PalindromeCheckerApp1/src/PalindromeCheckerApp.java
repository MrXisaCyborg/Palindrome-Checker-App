import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase13PalindromeCheckerApp {

    // Stack method
    public static boolean stackPalindrome(String word) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return word.equals(reversed);
    }

    // Deque method
    public static boolean dequePalindrome(String word) {

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }

        while (deque.size() > 1) {

            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                return false;
            }
        }

        return true;
    }

    // Two-pointer method
    public static boolean twoPointerPalindrome(String word) {

        int start = 0;
        int end = word.length() - 1;

        while (start < end) {

            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        String word = "madam";

        // Stack timing
        long start1 = System.nanoTime();
        boolean stackResult = stackPalindrome(word);
        long end1 = System.nanoTime();

        // Deque timing
        long start2 = System.nanoTime();
        boolean dequeResult = dequePalindrome(word);
        long end2 = System.nanoTime();

        // Two pointer timing
        long start3 = System.nanoTime();
        boolean pointerResult = twoPointerPalindrome(word);
        long end3 = System.nanoTime();

        System.out.println("Stack Result: " + stackResult +
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Deque Result: " + dequeResult +
                " | Time: " + (end2 - start2) + " ns");

        System.out.println("Two Pointer Result: " + pointerResult +
                " | Time: " + (end3 - start3) + " ns");
    }
}