package com.lewis.methodrefer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-01-02 21:13
 * @desc: 类描述
 *
 * <p>方法引用通过方法的名字来指向一个方法。
 * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 * 方法引用使用一对冒号 :: 。
 * 下面，我们在 Car 类中定义了 4 个方法作为例子来区分 Java 中 4 种不同方法的引用。</p>
 * @refer http://www.runoob.com/java/java8-method-references.html
 */
public class Test {

    public static void main(String[] args) {
        final Car car =Car.create(Car::new);
       List<Car> carList= Arrays.asList(car);
        carList.forEach(Car::collide);
        carList.forEach(Car::repair);
        carList.forEach(car::follow);

        carList.forEach(System.out::println);
    }
}

class Car {
    public static Car create (final Supplier<Car> carSupplier){

        return carSupplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }
}