package principle;

public class ISPPrinciple {
    public static void main(String[] args) {

    }
}


interface ISwim {
    void swim();
}

interface IBasketball{
    void playTheBasketball();
}

class Swim implements ISwim{

    public void swim() {
        System.out.println("swimming");
    }
}

class Basketball implements IBasketball{
    public void playTheBasketball() {
        System.out.println("play basketball");
    }
}