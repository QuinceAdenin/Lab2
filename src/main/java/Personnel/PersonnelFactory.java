package Personnel;
//Интерфейс паттерна фабрика персонала
public interface PersonnelFactory {
    Personnel createPersonnel(String role);
}
