public class Friend{
    int age;
    String name, gender, username;
    static int counter;
    Friend() {
        this.username = "example";
    }
    Friend(int age, String name, String gender, String username){
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.username = username;
    }
    void sayHi(){
        System.out.println("Hi my name is " + name);
    }
    public String toString() {
        return username;
    }
}