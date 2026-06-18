package models;

import models.menus.MenuState;
import models.menus.RegistrationMenu;

import java.util.Scanner;

public class Application {
    private MenuState currentMenuState;
    private Scanner scanner;
    private boolean isRunning;

    public Application() {
        this.scanner = new Scanner(System.in);
        this.isRunning = true;
    }

    public void run() {
        // Game starts at the Registration Menu
        changeMenuState(new RegistrationMenu());

        while (isRunning) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (currentMenuState != null) {
                    currentMenuState.handleInput(input);
                }
            }
        }
        scanner.close();
    }

    public void changeMenuState(MenuState newState) {
        if (currentMenuState != null) {
            currentMenuState.exitState(this);
        }
        currentMenuState = newState;
        if (currentMenuState != null) {
            currentMenuState.enterState(this);
        }
    }

    public void exit() {
        this.isRunning = false;
        System.out.println("Exiting the application. Goodbye!");
    }
}
