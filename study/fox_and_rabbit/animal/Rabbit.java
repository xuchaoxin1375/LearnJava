package study.fox_and_rabbit.animal;

import java.awt.Color;
import java.awt.Graphics;

import study.fox_and_rabbit.cell.Cell;

public class Rabbit extends Animal implements Cell{

    public Rabbit() {
        super(10, 2);
    }

    @Override
    public void draw(Graphics g, int x, int y, int size) {
        int alpha = (int)((1-getAgePercent())*255);
        g.setColor(new Color(255,0,0,alpha));
        g.fillRect(x, y, size, size);
    }

    @Override
    public Animal breed() {
        Animal ret = null;/*生产失败(默认)返回null*/
        if( isBreedable() && Math.random() < 0.12 ){   //12%的几率breed
            ret = new Rabbit();//可以生育并且满足概率条件,则生成新的自带对象
        }
        return ret;/*返回这个子代对象的管理者引用变量.*/
    }

    @Override
    public String toString(){
        return "Rabbit:"+super.toString();
    }
}
