package toy_language.controller;

import toy_language.domain.prg_state.PrgState;

public interface ExecutionObserver {
    void onExecutionStart(PrgState initialState);
    void onStepExecuted(PrgState currentState);
    void onExecutionFinish(PrgState finalState);
}
