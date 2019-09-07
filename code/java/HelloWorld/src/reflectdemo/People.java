package reflectdemo;

class People implements China {
    private String name;
    private int age;
    public People() {
    }
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public void sayChina() {
        System.out.println("national: " + NATIONAL + " author: " + AUTHOR);
    }
    @Override
    public String sayHello(String name, int age) {
        return "name: " + name + " age: " + age;
    }
}
