package principle;

public class DIPPrinciple {
    public static void main(String[] args) {
        distributionlock.Player player = new distributionlock.Player();
        BasketBall basketBall = new BasketBall();
        player.play(basketBall);

        Badminton badminton = new Badminton();
        player.play(badminton);
    }
}

class Player {
    public void play(Sport sport) {
        System.out.println("play the " + sport.name);
    }
}

class Sport {
    String name;
}

class BasketBall extends Sport {
    BasketBall() {
        name = "BasketBall";
    }
}

class Badminton extends Sport {
    Badminton() {
        name = "Badminton";
    }
}