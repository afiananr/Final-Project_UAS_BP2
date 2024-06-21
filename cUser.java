package fresh.vegetables;

public class cUser {

    private String id;
    private String password;

    cUser(String id, String p) {
        this.id = id;
        this.password = p;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String p) {
        this.password = p;
    }
}
