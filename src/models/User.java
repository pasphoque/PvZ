package models;

public class User {
    private String username;
    private String passwordHash;
    private String nickname;
    private String email;
    private String gender;

    // Additional fields for later phases
    private int coins = 0;
    private int diamonds = 0;

    public User(String username, String passwordHash, String nickname, String email, String gender) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.nickname = nickname;
        this.email = email;
        this.gender = gender;
    }

    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public String getNickname() { return nickname; }
    public String getEmail() { return email; }
    public String getGender() { return gender; }
}