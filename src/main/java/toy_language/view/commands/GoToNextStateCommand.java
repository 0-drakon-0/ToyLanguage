package toy_language.view.commands;

import toy_language.controller.Controller;
import toy_language.domain.my_exceptions.FinishUnexistentStateException;
import toy_language.domain.my_exceptions.NoProgramToRunException;
import toy_language.domain.prg_state.PrgState;

public class GoToNextStateCommand extends Command {
    Controller controller;

    public GoToNextStateCommand(String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        try {
            this.controller.goToNextState();
            System.out.println("Next state was loaded");
        } catch (FinishUnexistentStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
