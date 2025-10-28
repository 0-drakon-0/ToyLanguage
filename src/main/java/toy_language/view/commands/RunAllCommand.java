package toy_language.view.commands;

import toy_language.controller.Controller; 
import java.util.Scanner;

import toy_language.domain.statements.*;
import toy_language.domain.types.*;
import toy_language.domain.values.*;
import toy_language.domain.adts.dictionary.MyDict;
import toy_language.domain.adts.dictionary.SymbolTable;
import toy_language.domain.adts.stack.ExeStk;
import toy_language.domain.adts.stack.MyStack;
import toy_language.domain.expressions.*;
import toy_language.domain.prg_state.PrgState;
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
            System.out.println(e);
        }
    }

        
}
 
