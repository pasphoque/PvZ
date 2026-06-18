package models.menus;

import enums.Command;

import java.util.Map;

public class LoginMenu extends BaseMenu {
    @Override
    protected void processCommand(Command cmd, Map<String, String> args) {
        switch (cmd) {
            case LOGIN:
                view.displayMessage("Attempting to login user: " + args.get("username"));
                // TODO: Call AuthenticationService to authenticate user
                // On success: app.changeMenuState(new MainMenu());
                break;
            case MENU_ENTER:
                if ("registration".equalsIgnoreCase(args.get("menuName"))) {
                    app.changeMenuState(new RegistrationMenu());
                } else {
                    view.displayError("You can only access the 'registration' menu from here.");
                }
                break;
            case MENU_EXIT:
                app.changeMenuState(new RegistrationMenu());
                break;
            default:
                view.displayError("Command not supported in the Login Menu.");
                break;
        }
    }
}
