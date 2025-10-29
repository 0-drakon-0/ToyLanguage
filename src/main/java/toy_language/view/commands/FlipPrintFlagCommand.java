package toy_language.view.commands;

import toy_language.controller.Controller; 

public class FlipPrintFlagCommand extends Command {
    private final Controller controller;
        
    public FlipPrintFlagCommand (String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        this.controller.flipPrintFlag();    
    }

    public boolean getPrintFlag() {
        return this.controller.getPrintFlag();
    }
}
 
