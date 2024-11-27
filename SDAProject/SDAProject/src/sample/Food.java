package sample;

public class Food {
    private String name,id,description,Res_f_name,Res_f_ID;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRes_f_name() {
        return Res_f_name;
    }

    public void setRes_f_name(String res_name) {
        Res_f_name = res_name;
    }

    public String getRes_f_ID() {
        return Res_f_ID;
    }

    public void setRes_ID(String res_ID) {
        Res_f_ID = res_ID;
    }

    public Food(String name, String id, String description, double price, String Res_name, String Res_id) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.price = price;
        this.Res_f_name=Res_name;
        this.Res_f_ID=Res_id;
    }
}
