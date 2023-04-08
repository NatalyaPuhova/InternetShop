import java.util.Scanner;

public class UserInterface {
    public Storage storage;

    public int  inputValue(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите год");
        int dataYearUser=scanner.nextInt();

        System.out.println("Введите месяцы");
        int dataMonthUser=scanner.nextInt();

        System.out.println("Введите дни");
        int dataDayUser=scanner.nextInt();

        int allUserInputDays=dataDayUser+dataMonthUser*30+dataYearUser*365;
        System.out.println("allUserInputDays="+allUserInputDays);

        return allUserInputDays;
    }

    public double userPrice(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите верхнюю цену");
        return scanner.nextDouble();
    }

    public FilterParametrs getUsersFilters(){
        char letterOfProduct;
        double d=0;
        FilterParametrs filterParametrs=new FilterParametrs();
        Scanner scannerHighPrice_FirstLetterofProduct=new Scanner(System.in);
        System.out.println("Введите верхнюю границу цены");

        String ss=scannerHighPrice_FirstLetterofProduct.nextLine().trim();
        //char cc=ss.charAt(0);
        try {
            d=Double.parseDouble(ss);
        }
        catch (NumberFormatException exception){
            System.out.println("ошибка, нельзя распарсить пустую строку"+exception.getClass().getName());
        }

        System.out.println("верхнzz границу цены="+d);

        filterParametrs.setPrice(d);



        System.out.println("Введите первую букву названия продукта");
        //Scanner scanner2=new Scanner(System.in);
        String s=scannerHighPrice_FirstLetterofProduct.nextLine();
        if(s!=null){
            try {
                letterOfProduct=s.charAt(0);
                if (letterOfProduct!=0){
                    System.out.println("letterOfProduct="+letterOfProduct);
                    filterParametrs.setFirstLetter(letterOfProduct);
                }
            }
            catch (StringIndexOutOfBoundsException exception){
                System.out.println("Вы не ввели букву");
            }


        }





        return filterParametrs;
    }
}
