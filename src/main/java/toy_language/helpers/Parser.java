package toy_language.helpers;

import toy_language.domain.my_exceptions.InvalidInstructionException;
import toy_language.domain.prg_state.PrgState;

// It can be in its own 'parser' package or a 'util' package
public class Parser {
    // An instance method is often better than static so you can inject dependencies if needed later
    public void parse(String rawInput) throws InvalidInstructionException {
        if (rawInput == null || rawInput.isBlank()) {
            throw new InvalidInstructionException("Input cannot be empty.");
        }
        String[] parts = rawInput.trim().split(" *; *");
        
        //String commandName = parts[0];
        //List<String> args = Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));

    }
}
