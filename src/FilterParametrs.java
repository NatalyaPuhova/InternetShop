public class FilterParametrs {
    char firstLetter;
    Double price;

    public void setPrice(Double price){
        this.price=price;

    }

    public double returnPrice(){

        return price;
    }


    public void setFirstLetter(char firstLetter){
        this.firstLetter=firstLetter;
    }

    public char getFirstLetter(){
        return firstLetter;
    }

}
