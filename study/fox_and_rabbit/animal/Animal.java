package study.fox_and_rabbit.animal;

import java.util.ArrayList;

import study.fox_and_rabbit.field.Location;

public abstract class Animal{
    private int ageLimit;
    private int breedableAge;
    private int age;
    private boolean isAlive = true;
/*构造器:(设置子类动物的最大年龄和可生育年龄)*/
    public Animal(int ageLimit, int breedableAge){
        this.ageLimit = ageLimit;
        this.breedableAge = breedableAge;
    }

/*生命进度条*/
    protected double getAgePercent(){
        return (double)age/ageLimit;
    }

    public abstract Animal breed();
/*生长方法,让对象的年龄+1,这一动作可能导致某个动物死亡(生长到年龄的极限时,调用die()来让自己凋亡)*/
    public void grow(){
        age++;
        if(age > ageLimit){
            die();
        }
    }

    private void die() {
        isAlive = false;
    }//凋亡方法将存活状态设置为false.

    public boolean isAlive(){
        return isAlive;
    }

    public boolean isBreedable(){
        return age >breedableAge;
    }
/*传入一个位置数组给move方法,move方法随机地从空位置数组中选中一个位置,返回,返回值是一个Location类型的值.*/
    public Location moveToLocation(Location[] freeAdj){//adj->adjoin(邻接)
        Location ret = null;
        /*求长度,如果在该阶段长度不变化,那么就在循环开始前将长度求出,并记住,减少不必要的重复计算/调用读取函数(当然如果这个长度是可以直接访问的成员变量,那就不必单独算了*/
        if( freeAdj.length > 0 && Math.random() < 0.02 ){//只有当这个传入的这个位置数组有空间;在给定满足一定概率下,才让返回更新值
            ret = freeAdj[(int)(Math.random()*freeAdj.length)];/*比如当freeAdj.length=8,那么Math.random()*freeAdj.length就回事一个[0,8)的浮点数,对其转换为int,得到一个[0,8)的整数,而它可以取得数有八种:从0-7,(因为数组从0计数,所以就刚好啦)*/
        }
        return ret;
    }

    @Override
    public String toString(){
        return " "+age+":"+(isAlive?"live":"dead");
    }

    public Animal feed(ArrayList<Animal> neighbour){
        return null;/*默认捕食失败*/
    }
/*通过捕食来提高自己的寿命上限.*/
    protected void longerlife( int addage ){
        ageLimit += addage;
    }
}
