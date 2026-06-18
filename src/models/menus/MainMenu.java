package models.menus;

import enums.Command;
import java.util.Map;

public class MainMenu extends BaseMenu {
    @Override
    protected void processCommand(Command cmd, Map<String, String> args) {
        switch (cmd) {
            case MENU_ENTER:
                String menuName = args.get("menuName").toLowerCase();
                switch (menuName) {
                    case "game":
                        // app.changeMenuState(new GameMenu()); // We will create this next
                        view.displayMessage("Transitioning to Game Menu...");
                        break;
                    case "profile":
                        // app.changeMenuState(new ProfileMenu());
                        view.displayMessage("Transitioning to Profile Menu...");
                        break;
                    // Add settings, network, news here later
                    default:
                        view.displayError("Invalid menu name. Available: game, profile, settings, network, news.");
                        break;
                }
                break;

            case MENU_LOGOUT:
                app.setActiveUser(null);
                app.changeMenuState(new RegistrationMenu());
                break;

            case MENU_EXIT:
                // "menu exit" in Main Menu usually means nothing or prompts a logout.
                // The doc specifies "menu logout" to leave the main menu.
                view.displayError("Use 'menu logout' to sign out of your account.");
                break;

            case UNKNOWN:
                // Check if it's the logout command (we didn't add a dedicated regex for it yet,
                // but you can either add LOGOUT to Command.java or catch it here if the raw input was "menu logout")
                view.displayError("Invalid command.");
                break;

            default:
                view.displayError("Command not supported in the Main Menu.");
                break;
        }
    }
}