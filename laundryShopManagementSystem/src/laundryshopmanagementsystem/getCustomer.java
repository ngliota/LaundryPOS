package laundryshopmanagementsystem;

import java.sql.Date;

public class getCustomer {

    private Integer id;
    private Integer customerId;
    private String clothType;
    private String service;
    private Integer kilo;
    private Double price;
    private Date date;

    //ikuti parameter
    public getCustomer(Integer id, Integer customerId, Date date){
        this.id = id;
        this.customerId = customerId;
        this.date = date;
    }
    public getCustomer(Integer id, Integer customerId, String clothType,
                       String service, Integer kilo, Double price, Date date){
        this.id = id;
        this.customerId = customerId;
        this.clothType = clothType;
        this.service = service;
        this.kilo = kilo;
        this.price = price;
        this.date = date;
    }
    public Integer getId(){
        return id;
    }
    public Integer getCustomerId(){
        return customerId;
    }
    public String getClothType(){
        return clothType;
    }
    public String getService(){
        return service;
    }
    public Integer getKilo(){
        return kilo;
    }
    public Double getPrice(){
        return price;
    }
    public Date getDate(){
        return date;
    }
}