public class Customer {
    private int Id;
    private int Name;
    private int Age;

    public Customer(int id, int name, int age) {
        Id = id;
        Name = name;
        Age = age;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getName() {
        return Name;
    }

    public void setName(int name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }


}
