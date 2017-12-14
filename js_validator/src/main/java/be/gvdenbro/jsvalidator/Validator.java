package be.gvdenbro.jsvalidator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Utility class validating javascript brackets.
 */
public final class Validator {

    private static final Map<Character, Character> MAPPING = Collections.unmodifiableMap(new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    });

    private Validator() {
        // utility class - shouldn't be instantiated
    }

    /**
     * Validate the input.
     * @param input the input string
     * @return true if the brackets are balanced. Else, false.
     */
    public static boolean valid(String input) {

        Stack<Character> charactersStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);
            if (isOpener(bracket)) {
                charactersStack.push(bracket);
            } else if (isCloser(bracket)) {
                if (charactersStack.empty()) {
                    return false;
                } else {
                    char opener = charactersStack.pop();
                    if (!matches(opener, bracket)) {
                        return false;
                    }
                }
            }
        }

        return charactersStack.empty();
    }

    private static boolean matches(char opener, char closer) {
        return MAPPING.get(opener).equals(closer);
    }

    private static boolean isOpener(char bracket) {
        return MAPPING.containsKey(bracket);
    }

    private static boolean isCloser(char bracket) {
        return MAPPING.containsValue(bracket);
    }
}
