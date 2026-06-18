package models.menus;

import controller.services.AuthenticationService;
import enums.Command;
import models.User;

import java.util.Map;

public class RegistrationMenu extends BaseMenu {
    @Override
    protected void processCommand(Command cmd, Map<String, String> args) {
        switch (cmd) {
            case REGISTER:
                String username = args.get("username");
                String password = args.get("password");
                String passwordConfirm = args.get("passwordConfirm");
                String nickname = args.get("nickname");
                String email = args.get("email");
                String gender = args.get("gender");

                if (app.getUserRepository().isUsernameTaken(username)) {
                    view.displayError("Username is already taken.");
                    return;
                }

                if (!AuthenticationService.validateEmailFormat(email)) {
                    view.displayError("Invalid email format.");
                    return;
                }

                if (!AuthenticationService.validatePasswordStrength(password)) {
                    view.displayError("Weak password. It must be at least 8 characters and include uppercase, lowercase, numbers, and special characters.");
                    return;
                }

                if (!password.equals(passwordConfirm)) {
                    view.displayError("Passwords do not match.");
                    return;
                }

                // Create and save the new user
                String hashedPassword = AuthenticationService.hashPassword(password);
                User newUser = new User(username, hashedPassword, nickname, email, gender);
                app.getUserRepository().addUser(newUser);

                view.displaySuccess("Account created successfully! You can now access the 'login' menu.");
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