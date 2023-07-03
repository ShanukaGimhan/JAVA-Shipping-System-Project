package manage.ship.controllers;

public class TableCustomerCompany {

    //`c_idcm`, `c_namecm`, `c_addresscm`, `c_phonecm`, `c_mailcm`, `c_desigcm`, `c_idnumbercm`, `c_datecm`

    String id,name,address,phone,mail,designation,idNumber,date;

    public TableCustomerCompany(String id, String name, String address, String phone, String mail, String designation, String idNumber, String date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.designation = designation;
        this.idNumber = idNumber;
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

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getDesignation() {
        return designation;
    }

    public String getIdNumber() {
        return idNumber;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
