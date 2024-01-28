package domain;
import java.sql.Timestamp;
public class order {
    private String orderID;
    private int order_customer_id;
    private String order_p_name;
    private double order_p_price;
    private double order_p_kg;
    private String order_p_image;
    private String order_status;
    private int order_carrierID;
    private String deliveryTime;
    private String c_address;
    private Timestamp time;
    private Timestamp completedDelivery;


    public int getOrder_customer_id() {
        return order_customer_id;
    }


    public void setOrder_customer_id(int order_customer_id) {
        this.order_customer_id = order_customer_id;
    }

    public String getOrder_p_name() {
        return order_p_name;
    }


    public void setOrder_p_name(String order_p_name) {
        this.order_p_name = order_p_name;
    }


    public double getOrder_p_price() {
        return order_p_price;
    }

    public void setOrder_p_price(double order_p_price) {
        this.order_p_price = order_p_price;
    }


    public double getOrder_p_kg() {
        return order_p_kg;
    }

    public void setOrder_p_kg(double order_p_kg) {
        this.order_p_kg = order_p_kg;
    }


    public String getOrder_p_image() {
        return order_p_image;
    }


    public void setOrder_p_image(String order_p_image) {
        this.order_p_image = order_p_image;
    }

  
    public String getOrder_status() {
        return order_status;
    }


    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }



    public Timestamp getTime() {
        return time;
    }


    public void setTime(Timestamp time) {
        this.time = time;
    }



    public String getOrderID() {
        return orderID;
    }


    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }



    public int getOrder_carrierID() {
        return order_carrierID;
    }


    public void setOrder_carrierID(int order_carrierID) {
        this.order_carrierID = order_carrierID;
    }



    public String getDeliveryTime() {
        return deliveryTime;
    }


    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }


    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }


    public Timestamp getCompletedDelivery() {
        return completedDelivery;
    }

    public void setCompletedDelivery(Timestamp completedDelivery) {
        this.completedDelivery = completedDelivery;
    }

}
