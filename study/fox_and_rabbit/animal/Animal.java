package study.fox_and_rabbit.animal;

import java.util.ArrayList;

import study.fox_and_rabbit.field.Location;

public abstract class Animal{
    private int ageLimit;
    private int breedableAge;
    private int age;
    private boolean isAlive = true;
/*������:(�������ද����������Ϳ���������)*/
    public Animal(int ageLimit, int breedableAge){
        this.ageLimit = ageLimit;
        this.breedableAge = breedableAge;
    }

/*����������*/
    protected double getAgePercent(){
        return (double)age/ageLimit;
    }

    public abstract Animal breed();
/*��������,�ö��������+1,��һ�������ܵ���ĳ����������(����������ļ���ʱ,����die()�����Լ�����)*/
    public void grow(){
        age++;
        if(age > ageLimit){
            die();
        }
    }

    private void die() {
        isAlive = false;
    }//�������������״̬����Ϊfalse.

    public boolean isAlive(){
        return isAlive;
    }

    public boolean isBreedable(){
        return age >breedableAge;
    }
/*����һ��λ�������move����,move��������شӿ�λ��������ѡ��һ��λ��,����,����ֵ��һ��Location���͵�ֵ.*/
    public Location moveToLocation(Location[] freeAdj){//adj->adjoin(�ڽ�)
        Location ret = null;
        /*�󳤶�,����ڸý׶γ��Ȳ��仯,��ô����ѭ����ʼǰ���������,����ס,���ٲ���Ҫ���ظ�����/���ö�ȡ����(��Ȼ�����������ǿ���ֱ�ӷ��ʵĳ�Ա����,�ǾͲ��ص�������*/
        if( freeAdj.length > 0 && Math.random() < 0.02 ){//ֻ�е������������λ�������пռ�;�ڸ�������һ��������,���÷��ظ���ֵ
            ret = freeAdj[(int)(Math.random()*freeAdj.length)];/*���統freeAdj.length=8,��ôMath.random()*freeAdj.length�ͻ���һ��[0,8)�ĸ�����,����ת��Ϊint,�õ�һ��[0,8)������,��������ȡ�����а���:��0-7,(��Ϊ�����0����,���Ծ͸պ���)*/
        }
        return ret;
    }

    @Override
    public String toString(){
        return " "+age+":"+(isAlive?"live":"dead");
    }

    public Animal feed(ArrayList<Animal> neighbour){
        return null;/*Ĭ�ϲ�ʳʧ��*/
    }
/*ͨ����ʳ������Լ�����������.*/
    protected void longerlife( int addage ){
        ageLimit += addage;
    }
}
