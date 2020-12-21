package experiment4.exp4;
/*����?��Point �࣬���� double x,y,z ������
������double distance()����������õ㵽ԭ��ľ��롣
*/
public class Point implements Comparable<Point> {
    double x,y,z;
    double distance(){
        return Math.sqrt(x*x+y*y+z*z);
    }
    /*constructor:*/
    Point(double x_,double y_,double z_){
        x=x_;y=y_;z=z_;
    }

    /**
     * implement Comparable Interface to make it comparable .
     * what's more ,generally ,we use this.members to make the condition .
     * @param o
     * @return
     */
    /*Further more ,the overload method return int type ,we can't change it to double and so on .*/
    @Override
    public int compareTo(Point o) {
        return (int) (this.distance() - o.distance());
/*        if(this.distance()>o.distance()){
            return 1;
        }
        else if(this.distance()==o.distance()){
            return 0;
        }
        else{
            return -1;
        }*/
        /**/

    }
}
