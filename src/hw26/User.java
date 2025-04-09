package hw26;

public class User {
    private String name;
    private Adress adress;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getFullAdress(){
        if (adress != null){
            return adress.getFullAdress();
        }
        else {
            return "No adress";
        }
    }
}
