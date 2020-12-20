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
//constructor:����һ��size*size������
    public FoxAndRabbit( int size ){
        thefield = new Field(size, size);//����һ������(��Ұ),ͬʱ���÷�������Ĺ�ģ(�ڲ���һ��Cell���͵Ķ�ά����)
        for( int row = 0; row <thefield.getHeight(); row++ ){
            for( int col = 0; col < thefield.getWidth(); col++ ){
                double probability = Math.random();//����һ�������,��Ϊĳ�¼����������ж�����(����)Math.random ����Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0
                if( probability <0.05 ){
                    thefield.place( row, col, new Fox());//��һ���ĸ����¸���������һֻ����.
                }else if( probability < 0.15 ){//���û������һֻ����,��ô������ӻ���0.15�ĸ�������һֻ����
                    thefield.place( row, col, new Rabbit());
                }
            }
        }//����,field���Ѿ�����������ֻ���������.
        theview = new View(thefield);//����Ҫ��ѭ�����Ķϵ������Ʋ���ĳ���ط�ʱ,����ʹ��ǿ�����е���괦.(��ȻҲ�����ڴ˴�����ϵ�,Ȼ��ȡ������ѭ�����Ķϵ�.Ҳ����.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("study/fox_and_rabbit/stimulate");
        frame.add(theview);
        frame.pack();
        frame.setVisible(true);
    }//FoxAndRabbit()������
/*��дÿһ�˵�ģ��Ĳ�������(������ʳ,����)��Щ������field���ӹܵ�Cell�����仯*/
    public void step(){
        /*������ȡfield��ÿ�����ӵ���Ϣ(��ȡ����λ�õ�Cell�Ƿ�ĳ�ֶ�����ʵ����(ʵ��)*/
        int height=thefield.getHeight();
        int width=thefield.getWidth();
        for( int row = 0; row <height; row++ ){
            for( int col = 0; col < width; col++ ){
                Cell cell = thefield.get(row, col);//��ȡ��Ұ��(row,col)λ�õ�Cell�ӿڵĶ���,��cell������
                if( cell != null ){//����ղŻ�õ�(row,col)λ�õ�cell����ĳ�ֶ���.
                    Animal animal = (Animal)cell;/*//���˴���cell����������(Cell�ӿ�)ǿ��ת��ΪAnimal,
                    �Ա�ʹ��Animal���еķ���(��̬)��Ȼ����֪��,cell������Ķ���һ����Animal�������ʵ������*/
                    animal.grow();/*ÿһ��ģ�ⶼ��field�ϵĶ�������+1,��һ�������ܵ���ĳ����������*/
                    if( animal.isAlive()){//�жϸö����Ƿ񻹻���
                        /*//move(��cell��ָ����(����)����Ұ���ƶ�.);����һ��location���͵ı���,���ղ�����move�������ص�location���͵ı���,
                        loc��animal�ƶ���Ŀ��λ�ô�*/
                        Location loc = animal.moveToLocation(thefield.getFreeNeighbour(row, col));/*getFreeNighbour()����
                        ��moveToLocation(row,col)�����ڵļ���λ����Ϊ�յ�λ�õĹ��ɵ�����,
                        Ȼ��,Animal���е�move����ֻ�Ƿ���һ��animal���ƶ���λ����Ϣloc,��������������ƶ���loc��,ֻ��ͨ��field�е�move�������ƶ�
                        ����,���Ե�ʱ������ٿ�ĳ������������(ʹ��˵��)�������ÿ�ݼ�����ѯ,��Ȼ��Ҳ������ת��->ʵ��/��������һ�*/
                        if( loc != null ){//���������Ч(�����ƶ��Ŀ�λ��loc),ͨ��fieldִ���ƶ�����
                            /*��Ϊ�����ڶ���ѭ���б���field��ÿ��cell,��ǰλ����(row,col)λ��,thefield.move()����
                            ��animal�ӵ�ǰ��(row,col)λ���ƶ���locλ�ô�,ͬʱ�����ڲ���remove()ɾ��ԭ��λ�õĶ���*/
                            thefield.move(row, col, loc);/*//Field���е�move�����Ĳ����б���:(int row, int col, Location loc)*/
                        }
                        //eat   animal.eat(thefield);
                        /*ģ���������ӵĹ���:*/
                        if( animal instanceof Fox){//�����ǰλ���ϵ�animal��fox,
                            Cell[] neighbour = thefield.getNeighbour(row, col);
                            ArrayList<Animal> listRabbit = new ArrayList<Animal>();//����һ���������ӵ�list��������
                            for( Cell an : neighbour ){/*�������fox��Χ���ھ�,�ҵ����������ӵ��ھ�,��Rabbit���뵽һ���б���(an->animal)*/
                                if( an instanceof Rabbit ){
                                    listRabbit.add( (Rabbit)an );
                                }
                            }
                            /*���fox��Χȷʵ����>0ֻ������:*/
                            if( !listRabbit.isEmpty() ){
                                Animal fed = animal.feed(listRabbit);//����animal(fox)�Ĳ�ʳ����
                                if( fed != null ){/*�����ʳ�ɹ�*/
                                    thefield.remove((Cell)fed);/*������ʳ��rabbit�����λ���ϵ�ͼ��(��ʵ��ȡ����ʾ)*/
                                }
                            }
                        }
                        /*ģ����������.*/
                        Animal baby = animal.breed();
                        if( baby != null ){
                            thefield.placeRandomAdj(row, col, (Cell)baby);/*��baby����ط��õ����״���Χĳ����λ����.*/
                        }
                    }//����ö�����ȥ��:
                    else{
                        thefield.remove(row, col);
                    }//endif(animal.isAlive())
                }
            }
        }
    }//step()
/*����ģ���ģ*/
    public void start( int steps ){
        for( int i = 0; i < steps; i++){
            step();//���õ���ģ��
            /*����ͼ��*/
            theview.repaint();//ģ�������,�����ػ�����,
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
//���򿪶�
    public static void main(String[] args) {
        FoxAndRabbit fnr = new FoxAndRabbit(30);//30*30�Ĺ�����
        fnr.start(500);//ִ��500��ģ��(Ӧ����˵,ģ������㹻���ʱ��,���������н�û�ж�����.(��Ȼ����Ϊ���Ƕ���Щ���������������ǿ�ҵ�����.)
    }
}//class FoxAndRabbit
