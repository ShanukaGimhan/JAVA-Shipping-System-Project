package manage.ship.controllers;

public class TableCustomerIndividual {
    // `c_idin`, `c_namein`, `c_addressin`, `c_idnumberin`, `c_phonein`, `c_mailin`, `c_datein

    String id, name, address, idNumber, phone, mail, date;

    public TableCustomerIndividual(String id, String name, String address, String idNumber, String phone, String mail, String date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.idNumber = idNumber;
        this.phone = phone;
        this.mail = mail;
        this.date = date;
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

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
