package toy_language.view.commands;

import toy_language.controller.Controller; 

import toy_language.domain.my_exceptions.ToyLanguageExceptions;

public class RunAllCommand extends Command {
    private final Controller controller;
        
    public RunAllCommand (String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        try {
            this.controller.allStep();
        } catch (ToyLanguageExceptions e) {
            System.out.println(e.getMessage());
        }
    }

        
}
 
