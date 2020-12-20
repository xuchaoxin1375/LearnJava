package study.fox_and_rabbit.stimulate;

import study.fox_and_rabbit.field.Field;
import study.fox_and_rabbit.field.View;
import study.fox_and_rabbit.field.Location;

import java.util.ArrayList;

import javax.swing.JFrame;

import study.fox_and_rabbit.animal.Fox;
import study.fox_and_rabbit.animal.Rabbit;
import study.fox_and_rabbit.animal.Animal;
import study.fox_and_rabbit.cell.Cell;

public class FoxAndRabbit{
    private Field thefield;
    private View theview;
//constructor:构建一个size*size的网格
    public FoxAndRabbit( int size ){
        thefield = new Field(size, size);//生成一个网格(田野),同时设置方阵网格的规模(内部是一个Cell类型的二维数组)
        for( int row = 0; row <thefield.getHeight(); row++ ){
            for( int col = 0; col < thefield.getWidth(); col++ ){
                double probability = Math.random();//生成一个随机数,作为某事件发生与否的判断因素(概率)Math.random 方法Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0
                if( probability <0.05 ){
                    thefield.place( row, col, new Fox());//在一定的概率下格子上生成一只狐狸.
                }else if( probability < 0.15 ){//如果没有生成一只狐狸,那么这个格子还有0.15的概率生成一只兔子
                    thefield.place( row, col, new Rabbit());
                }
            }
        }//至此,field上已经生活着若干只狐狸和兔子.
        theview = new View(thefield);//当先要从循环处的断点立刻移步到某个地方时,可以使用强制运行到光标处.(当然也可以在此处打个断点,然后取消启用循环处的断点.也方便.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("study/fox_and_rabbit/stimulate");
        frame.add(theview);
        frame.pack();
        frame.setVisible(true);
    }//FoxAndRabbit()构造器
/*编写每一趟的模拟的操作内容(包括捕食,生育)这些会引起field所接管的Cell发生变化*/
    public void step(){
        /*遍历获取field中每个格子的信息(获取各个位置的Cell是否被某种动物所实例化(实现)*/
        int height=thefield.getHeight();
        int width=thefield.getWidth();
        for( int row = 0; row <height; row++ ){
            for( int col = 0; col < width; col++ ){
                Cell cell = thefield.get(row, col);//读取田野中(row,col)位置的Cell接口的对象,用cell来管理
                if( cell != null ){//如果刚才获得的(row,col)位置的cell存在某种动物.
                    Animal animal = (Animal)cell;/*//将此处的cell变量的类型(Cell接口)强制转换为Animal,
                    以便使用Animal类中的方法(多态)当然我们知道,cell所管理的对象一定是Animal的子类的实例对象*/
                    animal.grow();/*每一轮模拟都让field上的动物年龄+1,这一动作可能导致某个动物死亡*/
                    if( animal.isAlive()){//判断该动物是否还活着
                        /*//move(让cell所指对象(动物)在田野中移动.);定义一个location类型的变量,接收并管理move方法返回的location类型的变量,
                        loc是animal移动的目标位置处*/
                        Location loc = animal.moveToLocation(thefield.getFreeNeighbour(row, col));/*getFreeNighbour()返回
                        给moveToLocation(row,col)处相邻的几个位置中为空的位置的构成的数组,
                        然而,Animal类中的move方法只是返回一个animal该移动的位置信息loc,而不让这个对象移动到loc处,只能通过field中的move方法来移动
                        对了,调试的时候想快速看某个函数的声明(使用说明)可以设置快捷键来查询,当然你也可以用转到->实现/声明鼠标右击*/
                        if( loc != null ){//如果存在有效(可以移动的空位置loc),通过field执行移动操作
                            /*因为这是在二重循环中遍历field中每个cell,当前位置是(row,col)位置,thefield.move()方法
                            让animal从当前的(row,col)位置移动到loc位置处,同时调用内部的remove()删除原来位置的对象*/
                            thefield.move(row, col, loc);/*//Field类中的move函数的参数列表是:(int row, int col, Location loc)*/
                        }
                        //eat   animal.eat(thefield);
                        /*模拟狐狸吃兔子的过程:*/
                        if( animal instanceof Fox){//如果当前位置上的animal是fox,
                            Cell[] neighbour = thefield.getNeighbour(row, col);
                            ArrayList<Animal> listRabbit = new ArrayList<Animal>();//创建一个管理兔子的list容器对象
                            for( Cell an : neighbour ){/*遍历这个fox周围的邻居,找到其中是兔子的邻居,将Rabbit放入到一个列表中(an->animal)*/
                                if( an instanceof Rabbit ){
                                    listRabbit.add( (Rabbit)an );
                                }
                            }
                            /*如果fox周围确实存在>0只的兔子:*/
                            if( !listRabbit.isEmpty() ){
                                Animal fed = animal.feed(listRabbit);//调用animal(fox)的捕食方法
                                if( fed != null ){/*如果捕食成功*/
                                    thefield.remove((Cell)fed);/*清理被捕食的rabbit对象的位置上的图形(其实是取消显示)*/
                                }
                            }
                        }
                        /*模拟生产过程.*/
                        Animal baby = animal.breed();
                        if( baby != null ){
                            thefield.placeRandomAdj(row, col, (Cell)baby);/*将baby随机地放置到其亲代周围某个空位置上.*/
                        }
                    }//如果该动物死去了:
                    else{
                        thefield.remove(row, col);
                    }//endif(animal.isAlive())
                }
            }
        }
    }//step()
/*设置模拟规模*/
    public void start( int steps ){
        for( int i = 0; i < steps; i++){
            step();//调用单次模拟
            /*呈现图形*/
            theview.repaint();//模拟结束后,调用重画函数,
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
//程序开端
    public static void main(String[] args) {
        FoxAndRabbit fnr = new FoxAndRabbit(30);//30*30的规格的网
        fnr.start(500);//执行500次模拟(应该来说,模拟次数足够多的时候,最终网格中将没有动物了.(当然是因为我们对这些动物的生育率做了强烈的限制.)
    }
}//class FoxAndRabbit
