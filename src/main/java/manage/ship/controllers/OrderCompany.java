package manage.ship.controllers;

public class OrderCompany {

    //SELECT `o_idin`, `o_namecm`, `o_ordereridcm`, `o_categorycm`, `o_weightcm`, `o_pricecm`, `o_datecm`
    String IdCm,NameCm,IdNumberCm,CategoryCm,WeightCm,PriceCm,DateCm;

    public String getIdCm() {
        return IdCm;
    }

    public void setIdCm(String idCm) {
        IdCm = idCm;
    }

    public String getNameCm() {
        return NameCm;
    }

    public void setNameCm(String nameCm) {
        NameCm = nameCm;
    }

    public String getIdNumberCm() {
        return IdNumberCm;
    }

    public void setIdNumberCm(String idNumberCm) {
        IdNumberCm = idNumberCm;
    }

    public String getCategoryCm() {
        return CategoryCm;
    }

    public void setCategoryCm(String categoryCm) {
        CategoryCm = categoryCm;
    }

    public String getWeightCm() {
        return WeightCm;
    }

    public void setWeightCm(String weightCm) {
        WeightCm = weightCm;
    }

    public String getPriceCm() {
        return PriceCm;
    }

    public void setPriceCm(String priceCm) {
        PriceCm = priceCm;
    }

    public String getDateCm() {
        return DateCm;
    }

    public void setDateCm(String dateCm) {
        DateCm = dateCm;
    }

    public OrderCompany(String idCm, String nameCm, String idNumberCm, String categoryCm, String weightCm, String priceCm, String dateCm) {
        IdCm = idCm;
        NameCm = nameCm;
        IdNumberCm = idNumberCm;
        CategoryCm = categoryCm;
        WeightCm = weightCm;
        PriceCm = priceCm;
        DateCm = dateCm;
    }
}
