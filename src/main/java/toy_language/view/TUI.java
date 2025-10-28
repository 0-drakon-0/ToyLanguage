package toy_language.view;

import toy_language.controller.Controller;
import toy_language.view.commands.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TUI {
    private final Map<String, Command> commands;
    private final Scanner keyboard = new Scanner(System.in);

    public TUI(Controller controller) {
        this.commands = new HashMap<>();
        addCommand(new SelectPrgCommand("1", "Select a program", controller));
        addCommand(new RunAllCommand("2", "Run the entire program", controller));
        //addCommand(new SetPrintFlag("3", "Activate the print flag");
        //addCommand(new ShowCurrentState("4", "Show current state");
        addCommand(new ExitCommand("0", "Exit"));
    }

    private void addCommand(Command command) {
        this.commands.put(command.getKey(), command);
    }

    private void printMenu() {
        System.out.println("\n------------ MENU ------------");
        for (Command command : commands.values()) {
            String line = String.format("%3s. %s", command.getKey(), command.getDescription());
            System.out.println(line);
        }
        System.out.println("------------------------------");
    }

    public void start() {
        while (true) {
            printMenu();
            System.out.print("Enter option: ");
            String key = keyboard.next();
            
            Command command = commands.get(key);

            if (command == null) {
                System.out.println("Invalid option. Please try again.");
                continue; 
            }

            command.execute();
        }
    }
}
