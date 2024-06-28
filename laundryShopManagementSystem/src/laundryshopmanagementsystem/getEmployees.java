package laundryshopmanagementsystem;

import java.sql.Timestamp;

public class getEmployees {

    private Integer id;
    private String username;
    private Timestamp timestamp;

    public getEmployees(Integer id, String username, Timestamp timestamp) {
        this.id = id;
        this.username = username;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
