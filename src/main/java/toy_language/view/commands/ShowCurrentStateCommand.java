package toy_language.view.commands;

import toy_language.controller.Controller;
import toy_language.domain.prg_state.PrgState;

public class ShowCurrentStateCommand extends Command {
    Controller controller;

    public ShowCurrentStateCommand(String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        PrgState stateD = this.controller.getCurrentState();
        System.out.println("---------CurrentState---------");
        System.out.println(stateD.toString());
        System.out.println("------------------------------");
    }
}
