import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Storage productStorage=new Storage();


        System.out.println("Весь список продуктов:");
        for (Product p:productStorage.getProducts()){
            System.out.println(p);
        }

        System.out.println("сортирока по давности");
        System.out.println("по давности:");
        UserInterface userInterface=new UserInterface();
        for (Product p: productStorage.getByDate(userInterface.inputValue())){
            System.out.println("то, что подходит по сроку годности:"+p);
        }

        List<Product> mySortedProducts=productStorage.getByPrice(userInterface.userPrice());
        for (Product p: mySortedProducts){
            System.out.println(p);
        }


        System.out.println("МООООООУ");


        List<Product> myNewSort= productStorage.getListProductsByFilter(userInterface.getUsersFilters());
        for (Product p: myNewSort){
            System.out.println(p);
        }



        /*System.out.println("Сортируем по цене и по давности");
        List<Product> mySortedProducts4=productStorage.getByPrice();
        List<Product> mySortedProductsPriceAge=productStorage.getByDate(mySortedProducts4);
        for (Product p:mySortedProductsPriceAge){
            System.out.println(p);
        }

         */



    }
}
