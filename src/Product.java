import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate productionDate;
    private Double price;

    public Product(String name,LocalDate productionDate,Double price){
        this.name=name;
        this.productionDate=productionDate;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString(){
        return "name="+name+";  productionDate="+productionDate+";  price="+price;
    }
}
