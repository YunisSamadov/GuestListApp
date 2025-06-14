package exercise1.guestListApp;

public class Guest {
    private String name;
    private boolean confirmed;

    public Guest(String name) {
        this.name = name;
        this.confirmed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
