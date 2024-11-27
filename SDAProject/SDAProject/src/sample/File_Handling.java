package sample;

import java.io.*;
import java.util.ArrayList;

public class File_Handling implements PersistanceHandler{

    @Override
    public void write(String filename,String data)
    {
        try {
            FileWriter fw = new FileWriter(filename+".txt",true);
            BufferedWriter writer = new BufferedWriter(fw); // writer object creation to write in file
            writer.write(data); // writing encoded data in file
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nData Written TO FILE Successfully");
    }

    @Override
    public void Read(String filename)
    {
        try {
            File original = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(original));
            String file_data;   // DATA TYPE
            String data;

            while ((file_data = reader.readLine()) != null)
            {
                 data= file_data;
                int count=0;
                System.out.println("Data: "+data);
                String[] arrOfStr = data.split("~");
                ArrayList<String> str=new ArrayList<>();
                for (String a : arrOfStr) {
                   // System.out.println(a);
                    str.add(a);
                }
                //System.out.println("Size: "+str.size()+" "+str.get(0)+" "+str.get(1));
                    if (filename.equals("AdminList.txt")) {
                        Admin admin = new Admin(str.get(count), str.get(count+1));
                        FoodWorld.adminList.add(admin);
                    }
                    else if(filename.equals("RestaurantList.txt"))
                    {
                        Restaurant restaurant=new Restaurant(str.get(count),str.get(count+1),str.get(count+2),str.get(count+3),str.get(count+4),Long.parseLong(str.get(count+4)),str.get(count+5));
                        FoodWorld.restaurantlist.add(restaurant);
                    }
                    else if(filename.equals("FoodList.txt"))
                    {
                        Food f=new Food(str.get(count),str.get(count+1),str.get(count+2),Double.parseDouble(str.get(count+3)),str.get(count+4),str.get(count+5));
                        FoodWorld.foodlist.add(f);
                    }
                    else if(filename.equals("RiderList.txt"))
                    {
                        Rider rider=new Rider(str.get(count),str.get(count+1),str.get(count+2),str.get(count+3),str.get(count+4),str.get(count+5),Long.parseLong(str.get(count+6)));
                         FoodWorld.riderlist.add(rider);
                    }
                    else if(filename.equals("CustomerList.txt"))
                    {
                        Customer customer=new Customer(str.get(count),str.get(count+1),str.get(count+2),str.get(count+3),str.get(count+4),Long.parseLong(str.get(count+5)));
                       FoodWorld.customerlist.add(customer);
                    }
                    else if(filename.equals("MenuList.txt"))
                    {
                        Restaurant menu=new Restaurant(str.get(count),str.get(count+1),str.get(count+2));
                     FoodWorld.menulist.add(menu);
                    }
                    else if(filename.equals("CartList.txt"))
                    {
                        CartList cartList=new CartList(str.get(count),str.get(count+1),str.get(count+2),str.get(count+3),str.get(count+4));
                       FoodWorld.cartlist.add(cartList);
                    }
                    else if(filename.equals("OrderList.txt"))
                    {
                        Order order=new Order(str.get(count),str.get(count+1),str.get(count+2),str.get(count+3),str.get(count+4),str.get(count+5));
                         FoodWorld.orderlist.add(order);
                    }
                str.clear();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
