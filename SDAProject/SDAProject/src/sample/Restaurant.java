package sample;

import java.awt.*;

public class Restaurant {
    Food f;
    private String name,id,location,pass,confirm_pass,city;
    private long contact_no;
    private String Menu,Menu_res,Menu_res_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getid() {
        return id;
    }

    public void setid(String address) {
        this.id = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfirm_pass() {
        return confirm_pass;
    }

    public void setConfirm_pass(String confirm_pass) {
        this.confirm_pass = confirm_pass;
    }

    public long getContact_no() {
        return contact_no;
    }

    public void setContact_no(long contact_no) {
        this.contact_no = contact_no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public String getMenu_res() {
        return Menu_res;
    }

    public void setMenu_res(String menu_res) {
        Menu_res = menu_res;
    }

    public String getMenu_res_id() {
        return Menu_res_id;
    }

    public void setMenu_res_id(String menu_res_id) {
        this.Menu_res_id = menu_res_id;
    }

    public Restaurant(String name, String id, String location, String pass, String confirm_pass, long contact_no, String city) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.pass = pass;
        this.confirm_pass = confirm_pass;
        this.contact_no = contact_no;
        this.city=city;
    }

    public Restaurant(String Menu,String Resname,String Resid)
    {
        this.Menu= Menu;
        this.Menu_res = Resname;
        this.Menu_res_id = Resid;
    }


}
