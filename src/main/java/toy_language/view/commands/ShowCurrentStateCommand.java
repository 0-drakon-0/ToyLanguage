package toy_language.view.commands;

import toy_language.controller.Controller;
import toy_language.domain.my_exceptions.NoProgramToRunException;
import toy_language.domain.prg_state.PrgState;

public class ShowCurrentStateCommand extends Command {
    Controller controller;

    public ShowCurrentStateCommand(String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println("\n---------CurrentState---------");
        try {
            PrgState stateD = this.controller.getCurrentState();
            System.out.println(stateD.toString());
        } catch (NoProgramToRunException e) {
            System.out.println(e.getMessage());
        }
    }
}
