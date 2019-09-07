package reflectdemo;

/**
 * sayChina() 输出NATIONAL和Author
 * sayHello() 输出name和age;
 */
interface China {
    public static final String NATIONAL = "China";
    public static final String AUTHOR = "Ecia";
    public void sayChina();
    public String sayHello(String name, int age);
}