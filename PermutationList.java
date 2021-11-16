import java.util.Stack;
import java.util.ArrayList;

/**
 * Creates and prints a list of permutations from a given string.
 */
public class PermutationList {

    private Stack<String> stack = new Stack<>(); // for working with string from user input
    private ArrayList<String> permutations = new ArrayList<>(); // for storing perms in separate list

    public PermutationList() {

    }

    /**
     * Creates a stack from a string, finds all of the word's permutations and adds to an ArrayList.
     * @param wordInput A string representing a single word.
     */
    public void createList(String wordInput) {

        stack.push("+" + wordInput); // +wordInput onto the stack

        while (!stack.empty()) // while the stack is not empty
        {
            String top = stack.pop(); // Pop off the top of the stack
            int plusSignIndex = top.indexOf('+');

            if (top.endsWith("+")) {
                top = top.replaceAll("\\+", "");  // Remove the +
                permutations.add(top); // add the string to the list of permutations
            }
            else {
                String[] wordArr = top.split("\\+"); // create array with string from top of stack

                // Remove each letter in turn from the right of the +
                for(int i = 0; i < wordArr[1].length(); i++){
                    String wordStr = wordArr[wordArr.length - 1];
                    StringBuilder sb = new StringBuilder(wordStr); //use StringBuilder since it is mutable
                    String perm = (wordArr[0] + wordStr.charAt(i) + "+" + sb.deleteCharAt(i).toString());
                    stack.push(perm); // Push the resulting string on the stack
                }
            }
        }
    }

    /**
     * Prints an ArrayList enumerated with all permutations of a string and the exact number that exist.
     */
    public void printList() {
        //Print the list of permutations
        System.out.println("List of permutations: ");
        for (int i = 0; i < permutations.size(); i++) {
            System.out.println(permutations.get(i));
        }
        System.out.println("Number of permutations: " + permutations.size());
    }
}