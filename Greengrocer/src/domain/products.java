package domain;

public class products {
    private int p_id;
    private String p_name;
    private double p_price;
    private double p_stock;
    private double p_kg;
    private String p_image;
    private String p_type;
    private double p_threshold;

    public products() {
    }

    public products (int p_id, String p_name, double p_price, int p_stock, double p_kg, String p_image, String p_type) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_stock = p_stock;
        this.p_kg = p_kg;
        this.p_image = p_image;
        this.p_type = p_type;
    }

    public products(int p_id, String p_name, String p_type, int p_stock, double p_price) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_type = p_type;
        this.p_stock = p_stock;
        this.p_price = p_price;
    }

    public int getp_id() {
        return p_id;
    }

    public String getp_name() {
        return p_name;
    }


    public double getp_price() {
        return p_price;
    }

    public double getp_stock() {
        return p_stock;
    }

    public double getp_kg() {
        return p_kg;
    }

    public String getp_image() {
        return p_image;
    }

    public String getp_type() {
        return p_type;
    }

    public void setp_id(int p_id) {
        this.p_id = p_id;
    }
    
    public void setp_name(String p_name) {
        this.p_name = p_name;
    }
    
    public void setp_price(double p_price) {
        this.p_price = p_price;
    }
    
    public void setp_stock(double p_stock) {
        this.p_stock = p_stock;
    }
    
    
    public void setp_kg(double p_kg) {
        this.p_kg = p_kg;
    }
    
    public void setp_image(String p_image) {
        this.p_image = p_image;
    }

    public void setp_type(String p_type) {
        this.p_type = p_type;
    }

    /**
     * @return int return the p_id
     */
    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

 
    public String getP_name() {
        return p_name;
    }


    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public double getP_price() {
        return p_price;
    }


    public void setP_price(double p_price) {
        this.p_price = p_price;
    }


    public double getP_stock() {
        return p_stock;
    }


    public void setP_stock(double p_stock) {
        this.p_stock = p_stock;
    }


    public double getP_kg() {
        return p_kg;
    }


    public void setP_kg(double p_kg) {
        this.p_kg = p_kg;
    }

    public String getP_image() {
        return p_image;
    }


    public void setP_image(String p_image) {
        this.p_image = p_image;
    }


    public String getP_type() {
        return p_type;
    }


    public void setP_type(String p_type) {
        this.p_type = p_type;
    }

    


    /**
     * @return double return the p_threshold
     */
    public double getP_threshold() {
        return p_threshold;
    }

    /**
     * @param p_threshold the p_threshold to set
     */
    public void setP_threshold(double p_threshold) {
        this.p_threshold = p_threshold;
    }

}