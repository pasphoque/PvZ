package models.menus;

import enums.Command;

import java.util.Map;

public class RegistrationMenu extends BaseMenu {
    @Override
    protected void processCommand(Command cmd, Map<String, String> args) {
        switch (cmd) {
            case REGISTER:
                view.displayMessage("Attempting to register user: " + args.get("username"));
                // TODO: Call AuthenticationService to validate and save user
                break;
            case MENU_ENTER:
                if ("login".equalsIgnoreCase(args.get("menuName"))) {
                    app.changeMenuState(new LoginMenu());
                } else {
                    view.displayError("You can only access the 'login' menu from here.");
                }
                break;
            case MENU_EXIT:
                app.exit();
                break;
            default:
                view.displayError("Command not supported in the Registration Menu.");
                break;
        }
    }
}
