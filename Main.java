import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // create new PermutationList object
        PermutationList p = new PermutationList();
        Scanner in = new Scanner(System.in);

        // request user input
        System.out.print("Enter a word to find all of its permutations: ");
        while (in.hasNextLine()) {
            String word = in.nextLine();
            p.createList(word);
            p.printList();
            return;
        }

        in.close();
    }
}