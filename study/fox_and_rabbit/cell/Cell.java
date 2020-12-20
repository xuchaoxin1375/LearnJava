package study.fox_and_rabbit.cell;

import java.awt.Graphics;

public interface Cell {
    /*让每个Cell所接管的对象都能够将自己画出来*/
    void draw ( Graphics g, int x, int y, int size );//抽象方法
}
