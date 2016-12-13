package com.lpc.design.decorator.example2;

/**
 * 具体的装饰者二：细化装饰者
 */
public class Decorator2 extends Decorator {

    public Decorator2(Human human) {
        super(human);
    }

    public void wearClothes(){
        super.wearClothes();
        goClothespress();
    }

    public void walkToWhere(){
        super.walkToWhere();
        findPlaceOnMap();
    }

    public void goClothespress(){
        System.out.println("去衣柜找找看。。");
    }

    public void findPlaceOnMap(){
        System.out.println("在Map上找找。。");
    }

}
