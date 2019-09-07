package interfacesdemo.obserable;

import java.util.Observable;
import java.util.Observer;
// 继承Observable,创建被观察的类
class House extends Observable {
    private float price;
    public House() {}
    public House(float price) {
        this.price = price;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        super.setChanged(); // 设置变化点,通知所有观察者价格改变
        super.notifyObservers(price);
        this.price = price;
    }
    @Override
    public String toString() {
        return "price: " + this.price;
    }
}
// 实现接口Observer,创建观察者类，需要重写update()，即发生变化时，会执行的代码
class HousePriceObserver implements Observer {
    private String name;
    public HousePriceObserver() {}
    public HousePriceObserver(String name) {
        this.name = name;
    }
    @Override
    public void update(Observable boj, Object arg) {
        if (arg instanceof Float) {
            System.out.print("Name of the house: " + this.name + "\t");
            System.out.println("new of the price: " + ((Float) arg).floatValue());
        }
    }
}
public class ObserDemo {
    public static void main(String[] args) {
        House hou = new House(1000000f);
        HousePriceObserver hpo1 = new HousePriceObserver("A");
        HousePriceObserver hpo2 = new HousePriceObserver("B");
        HousePriceObserver hpo3 = new HousePriceObserver("C");
        // 添加观察者
        hou.addObserver(hpo1);
        hou.addObserver(hpo2);
        hou.addObserver(hpo3);
        System.out.println(hou);
        hou.setPrice(33333f);
        System.out.println(hou);
        // 删除观察者
        hou.deleteObserver(hpo1);
    }

}
