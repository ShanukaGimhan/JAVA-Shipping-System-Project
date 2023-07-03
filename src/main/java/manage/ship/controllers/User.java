package manage.ship.controllers;

public class User {


    public String u_name;
    public String u_address;
    public String u_idnumber;
    public String u_phone;
    public String u_mail;
    public String username;
    public String password;
    public String u_status;
    public String u_role;

    public User(String u_name, String u_address, String u_idnumber, String u_phone, String u_mail, String username, String password, String u_status, String u_role) {
        this.u_name = u_name;
        this.u_address = u_address;
        this.u_idnumber = u_idnumber;
        this.u_phone = u_phone;
        this.u_mail = u_mail;
        this.username = username;
        this.password = password;
        this.u_status = u_status;
        this.u_role = u_role;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public String getU_idnumber() {
        return u_idnumber;
    }

    public void setU_idnumber(String u_idnumber) {
        this.u_idnumber = u_idnumber;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public String getU_mail() {
        return u_mail;
    }

    public void setU_mail(String u_mail) {
        this.u_mail = u_mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getU_status() {
        return u_status;
    }

    public void setU_status(String u_status) {
        this.u_status = u_status;
    }

    public String getU_role() {
        return u_role;
    }

    public void setU_role(String u_role) {
        this.u_role = u_role;
    }
}
