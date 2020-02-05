package model;


public class Car {
    private Integer IDVozilo;
    private String Tip;
    private String Marka;
    private Integer GodinaProizvodnje;
    private Integer StanjeKilometra;


    public Car(String Tip, String Marka,Integer GodinaProizvodnje, Integer StanjeKilometra) {
        this.Tip = Tip;
        this.Marka=Marka;
        this.GodinaProizvodnje = GodinaProizvodnje;
        this.StanjeKilometra = StanjeKilometra;

    }

    public Integer getIdCar() {
        return IDVozilo;
    }

    public String getType() {
        return Tip;
    }

    public String getBrand(){ return Marka;}

    public Integer getInitialKm() {
        return StanjeKilometra;
    }

    public Integer getYearOfProduction() {
        return GodinaProizvodnje;
    }
/*
    public Integer getCarTypeId() {
        return carTypeId;
    }*/

    public void setIdCar(Integer IDVozilo) {
        this.IDVozilo = IDVozilo;
    }

    public void setType(String Tip) {
        this.Tip = Tip;
    }

    public void setBrand(String Marka) {
        this.Marka = Marka;
    }


    public void setInitialKm(Integer StanjeKilometra) {
        this.StanjeKilometra = StanjeKilometra;
    }

    public void setYearOfProduction(Integer GodinaProizvodnje) {
        this.GodinaProizvodnje = GodinaProizvodnje;
    }

/*
    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
                }
*/

    @Override
    public String toString() {
        return "Car{" + "IDVozilo=" + IDVozilo + ", Tip=" + Tip  + ", Marka=" +Marka + ", GodinaProizvodnje=" + GodinaProizvodnje + ", StanjeKilometra=" + StanjeKilometra + '}';
    }
}
