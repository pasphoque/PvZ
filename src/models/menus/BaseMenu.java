package models.menus;

import enums.Command;
import enums.CommandParser;
import models.Application;
import views.ConsoleView;
import views.OutputView;

import java.util.Map;

public abstract class BaseMenu implements MenuState {
    protected Application app;
    protected CommandParser parser;
    protected OutputView view;

    public BaseMenu() {
        this.parser = new CommandParser();
        this.view = new ConsoleView();
    }

    @Override
    public void enterState(Application app) {
        this.app = app;
        view.displayMessage("--- " + this.getClass().getSimpleName() + " ---");
    }

    @Override
    public void exitState(Application app) {
        // Optional logic for cleaning up or saving state when leaving a menu
    }

    @Override
    public void handleInput(String input) {
        Command cmd = parser.parseCommand(input);
        if (cmd == Command.UNKNOWN) {
            view.displayError("Invalid command format.");
            return;
        }
        Map<String, String> args = parser.extractArguments(cmd, input);
        processCommand(cmd, args);
    }

    // Forces derived menus to handle their specific logic
    protected abstract void processCommand(Command cmd, Map<String, String> args);
}