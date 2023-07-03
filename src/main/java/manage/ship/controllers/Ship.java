package manage.ship.controllers;

public class Ship {

    //`s_id`, `s_name`, `s_country`, `s_company`, `s_phone`, `s_mail`, `s_captain`, `s_date`
    String Id;
    String Name;
    String Country;
    String Company;
    String Phone;
    String Mail;
    String CaptainName;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getCaptainName() {
        return CaptainName;
    }

    public void setCaptainName(String captainName) {
        CaptainName = captainName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Ship(String id, String name, String country, String company, String phone, String mail, String captainName, String date) {
        Id = id;
        Name = name;
        Country = country;
        Company = company;
        Phone = phone;
        Mail = mail;
        CaptainName = captainName;
        Date = date;
    }

    String Date;


}
