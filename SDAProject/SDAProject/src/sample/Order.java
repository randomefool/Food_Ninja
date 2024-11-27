package sample;

public class Order {

    private String item_id,item_name,item_price,res_id,cus_username,rid_id;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public String getCus_username() {
        return cus_username;
    }

    public void setCus_username(String cus_username) {
        this.cus_username = cus_username;
    }

    public String getRid_id() {
        return rid_id;
    }

    public void setRid_id(String rid_id) {
        this.rid_id = rid_id;
    }

    public Order(String item_id, String item_name, String item_price, String rid , String c_username,String rider) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.res_id=rid;
        this.cus_username=c_username;
        this.rid_id=rider;
    }

}
