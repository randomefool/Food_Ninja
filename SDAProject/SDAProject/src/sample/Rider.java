package sample;

public class Rider {
    private String id,name,username,dob,pass,c_pass;
    private long contact_no;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getC_pass() {
        return c_pass;
    }

    public void setC_pass(String c_pass) {
        this.c_pass = c_pass;
    }

    public long getContact_no() {
        return contact_no;
    }

    public void setContact_no(long contact_no) {
        this.contact_no = contact_no;
    }

    public Rider(String ID,String name, String username, String dob, String pass, String c_pass, long contact_no) {
        this.id=ID;
        this.name = name;
        this.username = username;
        this.dob = dob;
        this.pass = pass;
        this.c_pass = c_pass;
        this.contact_no = contact_no;
    }
}
