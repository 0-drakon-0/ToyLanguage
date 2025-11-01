package toy_language.view.commands;

import toy_language.controller.Controller; 
import toy_language.domain.my_exceptions.ToyLanguageExceptions;
import toy_language.controller.ExecutionObserver;
import toy_language.domain.prg_state.PrgState;

public class RunAllCommand extends Command implements ExecutionObserver{
    private final Controller controller;
        
    public RunAllCommand (String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        try {
            this.controller.allStep(this);
        } catch (ToyLanguageExceptions e) {
            System.err.println("Execution failed: " + e.getMessage());
        }
    }
    @Override
    public void onExecutionStart(PrgState initialState) {
        System.out.println("--- Initial Program State ---");
        System.out.println(initialState.toString());
    }
    @Override
    public void onStepExecuted(PrgState currentState) {
        System.out.println("==>");
        System.out.println(currentState.toString());
    }
    @Override
    public void onExecutionFinish(PrgState finalState) {
        System.out.println("-----------------------------");
        System.out.println("Execution finished successfully.");
    }}
 
