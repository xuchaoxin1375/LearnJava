package study.fox_and_rabbit.animal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import study.fox_and_rabbit.cell.Cell;

public class Fox extends Animal implements Cell{
    public Fox(){
        super(20,4);     //最大年龄，生育年龄
    }

    @Override/*将自己画出来*/
    public void draw( Graphics g, int x, int y, int size ){
        int alpha = (int)((1-getAgePercent())*255);
        g.setColor(new Color(0,0,0,alpha));
        g.fillRect(x, y, size, size);
    }

    @Override/*生育方法*/
    public Animal breed() {
        Animal ret = null;
        if( isBreedable() && Math.random() < 0.05 ){   //5%的几率breed
            ret = new Fox();
        }
        return ret;
    }

    @Override
    public String toString(){
        return "Fox:"+super.toString();
    }

    @Override/*捕食者的捕食方法(需要知道邻居的情况(数组))返回被捕食的对象(的引用)*/
    public Animal feed(ArrayList<Animal> neighbour){    //返回被吃的兔子
        Animal ret = null;//默认捕食失败.
        if( Math.random() < 0.2 ){/*在一定的概率下捕食成功*/
            ret = neighbour.get((int)(Math.random()*neighbour.size()));/*随机地捕食Rabbit列表中的某一位置的兔子*/
            longerlife(2);//如果捕食成功,为这只狐狸的生命上限值+2.
        }
        return ret;//单一出口,返回被捕食的对象的引用
    }
}
