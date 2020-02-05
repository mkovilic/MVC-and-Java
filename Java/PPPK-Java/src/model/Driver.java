package model;

public class Driver {
    private Integer IDVozac;
    private String FirstName;
    private String LastName;
    private String Mobitel;
    private String VozackaDozvola;

    public Driver(String FirstName, String LastName, String phoneNumber, String VozackaDozvola) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Mobitel = Mobitel;
        this.VozackaDozvola = VozackaDozvola;
    }

    public Integer getIdDriver() {
        return IDVozac;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhoneNumber() {
        return Mobitel;
    }

    public String getDriversLicenceNumber() {
        return VozackaDozvola;
    }

    public void setIdDriver(Integer IDVozac) {
        this.IDVozac = IDVozac;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setPhoneNumber(String Mobitel) {
        this.Mobitel = Mobitel;
    }

    public void setDriversLicenceNumber(String VozackaDozvola) {
        this.VozackaDozvola = VozackaDozvola;
    }

    @Override
    public String toString() {
        return "Driver{" + "IDVozac=" + IDVozac + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Mobitel=" + Mobitel + ", VozackaDozvola=" + VozackaDozvola + '}';
    }

    
}
