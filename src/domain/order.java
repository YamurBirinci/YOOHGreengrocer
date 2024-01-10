package domain;
import java.sql.Timestamp;
public class order {
    private int order_customer_id;
    private String order_p_name;
    private double order_p_price;
    private double order_p_kg;
    private String order_p_image;
    private String order_status;
    private Timestamp time;



    /**
     * @return int return the order_customer_id
     */
    public int getOrder_customer_id() {
        return order_customer_id;
    }

    /**
     * @param order_customer_id the order_customer_id to set
     */
    public void setOrder_customer_id(int order_customer_id) {
        this.order_customer_id = order_customer_id;
    }

    /**
     * @return String return the order_p_name
     */
    public String getOrder_p_name() {
        return order_p_name;
    }

    /**
     * @param order_p_name the order_p_name to set
     */
    public void setOrder_p_name(String order_p_name) {
        this.order_p_name = order_p_name;
    }

    /**
     * @return double return the order_p_price
     */
    public double getOrder_p_price() {
        return order_p_price;
    }

    /**
     * @param order_p_price the order_p_price to set
     */
    public void setOrder_p_price(double order_p_price) {
        this.order_p_price = order_p_price;
    }

    /**
     * @return double return the order_p_kg
     */
    public double getOrder_p_kg() {
        return order_p_kg;
    }

    /**
     * @param order_p_kg the order_p_kg to set
     */
    public void setOrder_p_kg(double order_p_kg) {
        this.order_p_kg = order_p_kg;
    }

    /**
     * @return String return the order_p_image
     */
    public String getOrder_p_image() {
        return order_p_image;
    }

    /**
     * @param order_p_image the order_p_image to set
     */
    public void setOrder_p_image(String order_p_image) {
        this.order_p_image = order_p_image;
    }

    /**
     * @return String return the order_status
     */
    public String getOrder_status() {
        return order_status;
    }

    /**
     * @param order_status the order_status to set
     */
    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }


    /**
     * @return Timestamp return the time
     */
    public Timestamp getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

}
