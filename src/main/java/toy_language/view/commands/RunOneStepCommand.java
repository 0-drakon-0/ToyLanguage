package toy_language.view.commands;

import toy_language.controller.Controller; 

import toy_language.domain.my_exceptions.ToyLanguageExceptions;

public class RunOneStepCommand extends Command {
    private final Controller controller;
        
    public RunOneStepCommand (String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        try {
            this.controller.oneStep(this.controller.getCurrentState());
        } catch (ToyLanguageExceptions e) {
            System.out.println(e);
        }
    }

        
}
 
