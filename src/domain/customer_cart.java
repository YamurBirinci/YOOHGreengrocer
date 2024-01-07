package domain;

public class customer_cart {
    private int cart_id;
    private int user_id; 
    private int product_id; 
    private double quantity; 
    private double total_price;

    public int getCart_id() {
        return cart_id;
    }


    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }


    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


    public double getQuantity() {
        return quantity;
    }


    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    public double getTotal_price() {
        return total_price;
    }


    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

}