package manage.ship.controllers;

public class OrderIndividual {
    //SELECT `o_idin`, `o_namein`, `o_idnumberin`, `o_categoryin`, `o_weightin`, `o_pricein`, `o_datein`

    String IdIn,NameIn,IdNumberIn,CategoryIn,WeightIn,PriceIn,DateIn;

    public String getIdIn() {
        return IdIn;
    }

    public void setIdIn(String idIn) {
        IdIn = idIn;
    }

    public String getNameIn() {
        return NameIn;
    }

    public void setNameIn(String nameIn) {
        NameIn = nameIn;
    }

    public String getIdNumberIn() {
        return IdNumberIn;
    }

    public void setIdNumberIn(String idNumberIn) {
        IdNumberIn = idNumberIn;
    }

    public String getCategoryIn() {
        return CategoryIn;
    }

    public void setCategoryIn(String categoryIn) {
        CategoryIn = categoryIn;
    }

    public String getWeightIn() {
        return WeightIn;
    }

    public void setWeightIn(String weightIn) {
        WeightIn = weightIn;
    }

    public String getPriceIn() {
        return PriceIn;
    }

    public void setPriceIn(String priceIn) {
        PriceIn = priceIn;
    }

    public String getDateIn() {
        return DateIn;
    }

    public void setDateIn(String dateIn) {
        DateIn = dateIn;
    }

    public OrderIndividual(String idIn, String nameIn, String idNumberIn, String categoryIn, String weightIn, String priceIn, String dateIn) {
        IdIn = idIn;
        NameIn = nameIn;
        IdNumberIn = idNumberIn;
        CategoryIn = categoryIn;
        WeightIn = weightIn;
        PriceIn = priceIn;
        DateIn = dateIn;
    }
}
