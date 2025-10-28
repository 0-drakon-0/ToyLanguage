package toy_language;

import toy_language.controller.Controller;
import toy_language.controller.MyController;
import toy_language.view.TUI;
import toy_language.repository.Repository;
import toy_language.repository.MyRepo;

public class App {
    public static void main(String[] args) {
        Repository repo = new MyRepo();
        Controller ctrl = new MyController(repo);
        TUI tui = new TUI(ctrl);

        tui.start();
    }
}
