package experiment4.exp4;
/*����?��Point �࣬���� double x,y,z ������
������double distance()����������õ㵽ԭ��ľ��롣
*/
public class Point implements Comparable<Point> {
    double x,y,z;
    double distance(){
        return Math.sqrt(x*x+y*y+z*z);
    }
    Point(double x_,double y_,double z_){
        x=x_;y=y_;z=z_;
    }

    @Override
    public int compareTo(Point o) {
        if(this.distance()>o.distance()){
            return 1;
        }
        else if(this.distance()==o.distance()){
            return 0;
        }
        else{
            return -1;
        }
        /*return this.distance-o.distance;*/
    }
}
