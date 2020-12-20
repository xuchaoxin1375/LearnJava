package experiment4.exp4;
/*定义?个Point 类，包含 double x,y,z 变量，
并包含double distance()函数来计算该点到原点的距离。
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
