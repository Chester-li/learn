package builder;

public class BuilderClient {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder carBuilder = new BMWCarBuilder();
        director.setCarBuilder(carBuilder);
        director.build();
        Car car = director.getCar();
        System.out.println(car);
    }
}

class Car {
    private String mirror;
    private String seat;

    public void setMirror(String mirror) {
        this.mirror = mirror;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "mirror='" + mirror + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }
}

abstract class CarBuilder {
    protected Car car;

    public void createCar() {
        car = new Car();
    }

    public Car getCar() {
        return car;
    }

    public abstract void buildMirror();

    public abstract void buildSeat();
}

class BMWCarBuilder extends CarBuilder {

    public void buildMirror() {
        car.setMirror("BMW");
    }

    public void buildSeat() {
        car.setSeat("BMW");
    }
}

class Director {
    private CarBuilder carBuilder;

    public void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car getCar() {
        return carBuilder.getCar();
    }

    public void build() {
        carBuilder.createCar();
        carBuilder.buildMirror();
        carBuilder.buildSeat();
    }
}