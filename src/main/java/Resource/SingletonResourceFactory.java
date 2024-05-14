package Resource;

public class SingletonResourceFactory implements ResourceFactory {
    private static SingletonResourceFactory instance;//единств экз

    private SingletonResourceFactory() {}//Конструктор

    public static SingletonResourceFactory getInstance() {//Создание синглтона
        if (instance == null) {
            instance = new SingletonResourceFactory();
        }
        return instance;
    }
    //Создание ресурса
    @Override
    public Resource createResource(String description) {
        // Логика создания ресурса
        return new MyResource(description);
    }
}
