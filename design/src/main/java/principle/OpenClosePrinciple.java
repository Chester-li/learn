package principle;

public class OpenClosePrinciple {

    static abstract class Travel {
        abstract void goTravel();
    }

    static class BikeTravel extends Travel {
        void goTravel() {
            System.out.println("骑车出行");
        }
    }

    static class WalkingTravel extends Travel {
        void goTravel() {
            System.out.println("步行出行");
        }
    }

    public static void main(String[] args) {
        Travel travel = new BikeTravel();
        travel.goTravel();
    }
}
