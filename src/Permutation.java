import java.util.ArrayList;
import java.util.Arrays;

class Permutation {
    /**
     * Given some input, generate all permutations of the string.
     *
     * @param input string for which we find permutation
     * @return array list of the permutations of the input
     */
    public static ArrayList<String> permute(String input) {
        // return as array list for unit tests
        if (input == null) {
            return new ArrayList<String>();
        }
        if (input == "") {
            System.out.println("");
            return new ArrayList<String>();
        }
        // sort the characters to avoid duplication
        char[] characters = input.toCharArray();
        Arrays.sort(characters);
        // keep track of characters on current path
        ArrayList<Character> pathSoFar = new ArrayList<Character>();
        // array of visited will help keep track of which indices we have used
        Boolean[] visited = new Boolean[input.length()];
        Arrays.fill(visited, Boolean.FALSE);
        ArrayList<String> permutations = new ArrayList<String>();
        permutationHelper(characters, pathSoFar, visited, permutations);
        return permutations;
    }

    private static void permutationHelper(char[] characters, ArrayList<Character> pathSoFar, Boolean[] visited, ArrayList<String> permutations) {
        if (pathSoFar.size() == characters.length) {
            // found termination case based on length of pathSoFar- create string from this
            // and print / add to output
            String permutation = stringFromCharacters(pathSoFar);
            System.out.println(permutation);
            permutations.add(permutation);
            return;
        }
        // using chars not yet visited, add a char and all of its subpaths to current path
        for (int i = 0; i < characters.length; i++) {
            // already encountered character
            if (visited[i] == true ||
                    // we only start a path for a character the first time we've encountered it to avoid duplication-
                    // so when we encounter a duplicate, we only use the duplicate if the original was used
                    (i > 0 && characters[i-1] == characters[i] && visited[i - 1] == false)) {
                continue;
            }
            pathSoFar.add(characters[i]);
            visited[i] = true;
            permutationHelper(characters, pathSoFar, visited, permutations);
            visited[i] = false;
            pathSoFar.remove(pathSoFar.size() - 1);
        }
    }

    public static String stringFromCharacters(ArrayList<Character> characters) {
        StringBuilder builder = new StringBuilder(characters.size());
        for (int i = 0; i < characters.size(); i++) {
            Character character = characters.get(i);
            builder.append(character);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        permute("GOD");
    }
}