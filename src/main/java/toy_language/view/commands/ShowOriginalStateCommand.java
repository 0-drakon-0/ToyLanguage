package toy_language.view.commands;

import toy_language.controller.Controller; 

public class ShowOriginalStateCommand extends Command {
    private final Controller controller;
        
    public ShowOriginalStateCommand (String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(this.controller.getOriginalState());    
    }

    public boolean getPrintFlag() {
        return this.controller.getPrintFlag();
    }
}
 
