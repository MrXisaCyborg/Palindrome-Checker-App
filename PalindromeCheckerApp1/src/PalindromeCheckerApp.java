public class UseCase10PalindromeCheckerApp {

    public static boolean isPalindrome(String word) {

        // Normalize string: remove spaces and convert to lowercase
        word = word.replaceAll("\\s+", "").toLowerCase();

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

        String word = "Race Car";

        if (isPalindrome(word)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}