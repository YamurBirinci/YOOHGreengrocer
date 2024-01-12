package domain;

public class customer_cart {
    private int cart_id;
    private int user_id; 
    private String product_name;
    private double quantity; 
    private double price;
    private double threshold;
    private double kg;
    private String p_image;


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


    /**
     * @return double return the threshold
     */
    public double getThreshold() {
        return threshold;
    }

    /**
     * @param threshold the threshold to set
     */
    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }


    /**
     * @return double return the kg
     */
    public double getKg() {
        return kg;
    }

    /**
     * @param kg the kg to set
     */
    public void setKg(double kg) {
        this.kg = kg;
    }

}