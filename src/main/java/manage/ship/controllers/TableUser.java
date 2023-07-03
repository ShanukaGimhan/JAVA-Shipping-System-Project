package manage.ship.controllers;

public class TableUser {

   // String uID, uName, uAddress, uIDNumber, uMail, uUser, uRole;
String id, name, address, idnumber, mail, user, role;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public String getMail() {
        return mail;
    }

    public String getUser() {
        return user;
    }

    public String getRole() {
        return role;
    }

    public TableUser(String id, String name, String address, String idnumber, String mail, String user, String role) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.idnumber = idnumber;
        this.mail = mail;
        this.user = user;
        this.role = role;
    }
}
