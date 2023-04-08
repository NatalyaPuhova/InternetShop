import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final String FILE_NAME="C:\\Users\\pushinka\\Projects\\2022\\internetShop\\src\\storage_Products.txt";
    private List<Product> products;

    public Storage(){
        products=readProductsFromFile();
    }

    public List<Product> getProducts() {
        return products;
    }

    private List<Product>  readProductsFromFile(){
        List<Product> productList=new ArrayList<>();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(FILE_NAME));
            String strReadFromFile;
            while ((strReadFromFile=bufferedReader.readLine())!=null){
                String [] arrayFieldsOfClassProduct=strReadFromFile.split(" ");
                String name=null;
                if (arrayFieldsOfClassProduct[0]!=null){
                    name=arrayFieldsOfClassProduct[0].trim();
                }
                LocalDate produceDate=null;
                if (arrayFieldsOfClassProduct[1]!=null){
                    produceDate= LocalDate.parse(arrayFieldsOfClassProduct[1].trim());
                }
                Double price=null;
                if (arrayFieldsOfClassProduct[2]!=null){
                    price=Double.parseDouble(arrayFieldsOfClassProduct[2].trim());
                }
                productList.add(new Product(name,produceDate,price));
            }
        }
        catch (FileNotFoundException exception){
            System.out.println("ошибка при открытии файла, файл не найден"+exception.getClass().getName());
        }
        catch (IOException exception){
            System.out.println("ошибка"+exception.getClass().getName());
        }
        return productList;

    }


    public List<Product> getByPrice (double price){
        List<Product> sortedProductList=new ArrayList<>();

        for (Product p: getProducts()){
            if (p.getPrice()<price){
                sortedProductList.add(p);
            }
        }
        return sortedProductList;
    }





    public List<Product> getByDate(int allUserInputDays){
        List<Product> sortedProductList2=new ArrayList<>();

        for (Product p:getProducts()){
            Period periodBetween=Period.between(p.getProductionDate(),LocalDate.now());
            System.out.println();
            int days=periodBetween.getDays();
            int monthes=periodBetween.getMonths();
            int years=periodBetween.getYears();

            System.out.println(p);
            System.out.println("Давность продукта:"+"Period years="+years+"; Period monthes="+monthes+" ;Period days="+days);

            int daysOfProduct=days+monthes*30+years*365;
            System.out.println("продукт="+p+"          .;  int daysOfProduct="+daysOfProduct);

            if (daysOfProduct<allUserInputDays){
                sortedProductList2.add(p);
            }

        }
        return sortedProductList2;
    }

    public List<Product> getListProductsByFilter(FilterParametrs filterParametrs1){
        char firstLetter;
        double highPrice=0;
        List<Product> productsByFilterN1=getProducts();
        List<Product> productsByFilterN2=new ArrayList<>();
        firstLetter=filterParametrs1.getFirstLetter();

        try {
            highPrice=filterParametrs1.returnPrice();
        }
        catch (NullPointerException e){
            System.out.println("не ввели цену");
        }


        if (highPrice!=0.0){
            System.out.println("highPrice="+highPrice);
            for (int i=0;i<productsByFilterN1.size();i++){
                Product p=productsByFilterN1.get(i);
                System.out.println("p.getPrice()="+p.getPrice());
                if (p.getPrice()<highPrice){
                    productsByFilterN2.add(p);
                }
            }
            productsByFilterN1.clear();
            //productsByFilterN1.addAll(productsByFilterN2);//////////////////////////////////////////////

            for (Product p: productsByFilterN2){
                productsByFilterN1.add(p);///////////////                        1-итоговый
            }
            productsByFilterN2.clear();
        }

        if (firstLetter!=0) {
            for (Product p : productsByFilterN1) {
                System.out.println("firstLetter=" + firstLetter);
                System.out.println("pervaya=" + p.getName().charAt(0));
                if (firstLetter == p.getName().charAt(0)) {
                    productsByFilterN2.add(p);
                }
            }
            productsByFilterN1.clear();

            for (Product p : productsByFilterN2) {
                productsByFilterN1.add(p);
            }
            productsByFilterN2.clear();
        }



        return productsByFilterN1;
    }

}
