package Personnel;
//Класс Персонал
public class MyPersonnel implements Personnel{
    private String role;
    //Конструктор
    public MyPersonnel(String role) {
        this.role = role;
    }
    //Гетр
    @Override
    public String getRole() {
        return role;
    }
}
