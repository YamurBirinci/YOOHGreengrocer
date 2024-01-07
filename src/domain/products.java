package domain;

public class products {
    private int p_id;
    private String p_name;
    private double p_price;
    private double p_stock;
    private double p_kg;
    private String p_image;
    private String p_type;

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
    
    public void setp_stock(int p_stock) {
        this.p_stock = p_stock;
    }
    
    public void setp_kg(double p_kg) {
        this.p_kg = p_kg;
    }
    
    public void setp_image(String p_image) {
        this.p_image = p_image;
    }

    public void setp_type(String p_type) {
        this.p_image = p_type;
    }
}