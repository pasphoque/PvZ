package enums;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class CommandParser {

    public Command parseCommand(String input) {
        input = input.trim();
        for (Command cmd : Command.values()) {
            if (cmd == Command.UNKNOWN) continue;
            Matcher matcher = cmd.getMatcher(input);
            if (matcher.matches()) {
                return cmd;
            }
        }
        return Command.UNKNOWN;
    }

    public Map<String, String> extractArguments(Command cmd, String input) {
        Map<String, String> args = new HashMap<>();
        if (cmd == Command.UNKNOWN) return args;

        Matcher matcher = cmd.getMatcher(input.trim());
        if (matcher.matches()) {
            // Extract named groups based on the parsed command type
            if (cmd == Command.REGISTER) {
                args.put("username", matcher.group("username"));
                args.put("password", matcher.group("password"));
                args.put("passwordConfirm", matcher.group("passwordConfirm"));
                args.put("nickname", matcher.group("nickname"));
                args.put("email", matcher.group("email"));
                args.put("gender", matcher.group("gender"));
            } else if (cmd == Command.LOGIN) {
                args.put("username", matcher.group("username"));
                args.put("password", matcher.group("password"));
                args.put("stayLoggedIn", matcher.group("stayLoggedIn") != null ? "true" : "false");
            } else if (cmd == Command.MENU_ENTER) {
                args.put("menuName", matcher.group("menuName"));
            }
        }
        return args;
    }
}
