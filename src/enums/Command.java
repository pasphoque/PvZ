package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Command {
    REGISTER("(?i)^register\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)\\s+(?<passwordConfirm>\\S+)\\s+-n\\s+(?<nickname>\\S+)\\s+-e\\s+(?<email>\\S+)\\s+-g\\s+(?<gender>\\S+)$"),
    LOGIN("(?i)^login\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)(?<stayLoggedIn>\\s+-stay-logged-in)?$"),
    MENU_ENTER("(?i)^menu\\s+enter\\s+(?<menuName>.+)$"),
    MENU_EXIT("(?i)^menu\\s+exit$"),
    UNKNOWN("");

    private final Pattern pattern;

    Command(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public Matcher getMatcher(String input) {
        return pattern.matcher(input);
    }
}