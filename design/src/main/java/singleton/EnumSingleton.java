package singleton;

public enum EnumSingleton {
    instance;//提供访问入口

    Singleton singleton;

    EnumSingleton(){
        singleton = new Singleton();
    }

    //获取具体实例
    Singleton getSingleton(){
        return singleton;
    }

    class Singleton{
        public void sayHello(){
            System.out.println("hello world");
        }
    }
}
