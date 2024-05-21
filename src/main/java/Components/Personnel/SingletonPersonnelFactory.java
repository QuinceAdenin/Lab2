package Components.Personnel;

import org.springframework.stereotype.Component;


public class SingletonPersonnelFactory implements PersonnelFactory {
    private static SingletonPersonnelFactory instance;//единств экз

    private SingletonPersonnelFactory() {}//Приватный конструктор

    public static SingletonPersonnelFactory getInstance() {//Создание сингла
        if (instance == null) {
            instance = new SingletonPersonnelFactory();
        }
        return instance;
    }
    //Создание персонала
    @Override
    public Personnel createPersonnel(String role) {
        // Логика создания персонала
        return new MyPersonnel(role);
    }
}