package toy_language.view.commands;

import toy_language.controller.Controller; 

public class FlipPrintFlag extends Command {
    private final Controller controller;
        
    public FlipPrintFlag (String key, String description, Controller controller) {
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
 
