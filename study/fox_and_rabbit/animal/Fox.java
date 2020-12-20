package study.fox_and_rabbit.animal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import study.fox_and_rabbit.cell.Cell;

public class Fox extends Animal implements Cell{
    public Fox(){
        super(20,4);     //������䣬��������
    }

    @Override/*���Լ�������*/
    public void draw( Graphics g, int x, int y, int size ){
        int alpha = (int)((1-getAgePercent())*255);
        g.setColor(new Color(0,0,0,alpha));
        g.fillRect(x, y, size, size);
    }

    @Override/*��������*/
    public Animal breed() {
        Animal ret = null;
        if( isBreedable() && Math.random() < 0.05 ){   //5%�ļ���breed
            ret = new Fox();
        }
        return ret;
    }

    @Override
    public String toString(){
        return "Fox:"+super.toString();
    }

    @Override/*��ʳ�ߵĲ�ʳ����(��Ҫ֪���ھӵ����(����))���ر���ʳ�Ķ���(������)*/
    public Animal feed(ArrayList<Animal> neighbour){    //���ر��Ե�����
        Animal ret = null;//Ĭ�ϲ�ʳʧ��.
        if( Math.random() < 0.2 ){/*��һ���ĸ����²�ʳ�ɹ�*/
            ret = neighbour.get((int)(Math.random()*neighbour.size()));/*����ز�ʳRabbit�б��е�ĳһλ�õ�����*/
            longerlife(2);//�����ʳ�ɹ�,Ϊ��ֻ�������������ֵ+2.
        }
        return ret;//��һ����,���ر���ʳ�Ķ��������
    }
}
