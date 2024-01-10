package domain;

public class customer_cart {
    private int cart_id;
    private int user_id; 
    private String product_name;
    private double quantity; 
    private double price;
    private String p_image;

    public customer_cart() {
    }

    public customer_cart(int cart_id, int user_id, String product_name, double quantity, double price) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.price = price;
    }

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


    public double getQuantity() {
        return quantity;
    }


    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    public String getP_image() {
        return p_image;
    }

    
    public void setP_image(String p_image) {
        this.p_image = p_image;
    }

}
