package Resource;
//Класс ресурс
public class MyResource implements Resource {
    private String description;
    //Конструктор
    public MyResource(String description) {
        this.description = description;
    }
    //Гетр
    @Override
    public String getDescription() {
        return description;
    }
}
