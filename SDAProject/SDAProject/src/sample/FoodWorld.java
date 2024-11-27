package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FoodWorld {

    public static ArrayList<Admin> adminList=new ArrayList<>();
    public static ArrayList<Restaurant> restaurantlist=new ArrayList<>();
    public static ArrayList<Food> foodlist=new ArrayList<>();
    public static ArrayList<Rider> riderlist=new ArrayList<>();
    public static ArrayList<Customer> customerlist=new ArrayList<>();
    public static ArrayList<Restaurant> menulist=new ArrayList<>();
    public static ArrayList<CartList> cartlist=new ArrayList<>();
    public static ArrayList<Order> orderlist=new ArrayList<>();

    Admin admin1=new Admin("ar","2344");
    Admin admin2=new Admin("ali","2317");
        public FoodWorld(){
        }

    public void addAdmin(Admin obj)
    {
        adminList.add(obj);
//        adminList.add(admin1);
//        adminList.add(admin2);
    }

    public void AddFood(Food obj)
    {
            foodlist.add(obj);

    }

    public void AddRestaurant(Restaurant obj)
    {
        restaurantlist.add(obj);
    }

    public void AddCustomer(Customer obj)
    {
        customerlist.add(obj);
    }

    public void AddRider(Rider obj)
    {
        riderlist.add(obj);
    }

    public void AddMenu(Restaurant menu)
    {
        menulist.add(menu);
    }

    public void AddCart(CartList cartobj)
    {
        cartlist.add(cartobj);
    }
    public void AddOrders(Order obj)
    {
        orderlist.add(obj);
    }

    PersistanceHandler file=new File_Handling();
    public void AddToFile()
    {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\user\\Downloads\\SDAProject\\AdminList.txt"));
            writer.write("");
            writer.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=0;i<adminList.size();i++)
        {
            file.write("AdminList",adminList.get(i).getUsername()+"~"+adminList.get(i).getPassword()+"\n");
        }
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\user\\Downloads\\SDAProject\\CartList.txt"));
            writer.write("");
            writer.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=0;i<cartlist.size();i++)
        {
            file.write("CartList",cartlist.get(i).getItem_id()+"~"+cartlist.get(i).getItem_name()+"~"+cartlist.get(i).getItem_price()+"~"+cartlist.get(i).getRes_id()+"~"+cartlist.get(i).getCus_username()+"\n");
        }
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\user\\Downloads\\SDAProject\\CustomerList.txt"));
            writer.write("");
            writer.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=0;i<customerlist.size();i++)
        {
            file.write("CustomerList",customerlist.get(i).getName()+"~"+customerlist.get(i).getUsername()+"~"+customerlist.get(i).getDob()+"~"+customerlist.get(i).getPass()+"~"+customerlist.get(i).getC_pass()+"~"+customerlist.get(i).getContact_no()+"\n");
        }
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\user\\Downloads\\SDAProject\\FoodList.txt"));
            writer.write("");
            writer.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=0;i<foodlist.size();i++)
        {
            file.write("FoodList",foodlist.get(i).getName()+"~"+foodlist.get(i).getId()+"~"+foodlist.get(i).getDescription()+"~"+foodlist.get(i).getPrice()+"~"+foodlist.get(i).getRes_f_name()+"~"+foodlist.get(i).getRes_f_ID()+"\n");
        }
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\user\\Downloads\\SDAProject\\MenuList.txt"));
            writer.write("");
            writer.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=0;i<menulist.size();i++)
        {
             file.write("MenuList",menulist.get(i).getMenu()+"~"+menulist.get(i).getMenu_res()+"~"+menulist.get(i).getMenu_res_id()+"\n");
        }
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\user\\Downloads\\SDAProject\\orderlist.txt"));
            writer.write("");
            writer.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=0;i<orderlist.size();i++)
        {
            file.write("OrderList",orderlist.get(i).getItem_id()+"~"+orderlist.get(i).getItem_name()+"~"+orderlist.get(i).getItem_price()+"~"+orderlist.get(i).getRes_id()+"~"+orderlist.get(i).getCus_username()+"~"+orderlist.get(i).getRid_id()+"\n");
        }
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\iamum\\Downloads\\SDAProject\\SDAProject\\RestaurantList.txt"));
            writer.write("");
            writer.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=0;i<restaurantlist.size();i++)
        {
            file.write("RestaurantList",restaurantlist.get(i).getName()+"~"+restaurantlist.get(i).getid()+"~"+restaurantlist.get(i).getLocation()+"~"+restaurantlist.get(i).getPass()+"~"+restaurantlist.get(i).getConfirm_pass()+"~"+restaurantlist.get(i).getContact_no()+"~"+restaurantlist.get(i).getCity()+"\n");
        }
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\user\\Downloads\\SDAProject\\RiderList.txt"));
            writer.write("");
            writer.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=0;i<riderlist.size();i++)
        {
            file.write("RiderList",riderlist.get(i).getId()+"~"+riderlist.get(i).getName()+"~"+riderlist.get(i).getUsername()+"~"+riderlist.get(i).getDob()+"~"+riderlist.get(i).getPass()+"~"+riderlist.get(i).getC_pass()+"~"+riderlist.get(i).getContact_no()+"\n");
        }

    }

    public void ReadFromFile()
    {
        file.Read("AdminList.txt");
        file.Read("CartList.txt");
        file.Read("FoodList.txt");
        file.Read("MenuList.txt");
        file.Read("OrderList.txt");
        file.Read("RestaurantList.txt");
        file.Read("RiderList.txt");
        file.Read("CustomerList.txt");
    }

}
