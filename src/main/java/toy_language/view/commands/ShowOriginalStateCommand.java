package toy_language.view.commands;

import toy_language.controller.Controller; 
import toy_language.domain.my_exceptions.NoProgramToRunException;

public class ShowOriginalStateCommand extends Command {
    private final Controller controller;
        
    public ShowOriginalStateCommand (String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        try {
            System.out.println("\n--------Original-State--------");
            System.out.println(this.controller.getOriginalState());    
        } catch (NoProgramToRunException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean getPrintFlag() {
        return this.controller.getPrintFlag();
    }
}
 
