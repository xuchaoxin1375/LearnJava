package experiment4.exp4.studyCompareTo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xuchaoxin
 * @Date 12/21/2020 8:31 PM
 * @Version 1.0
 */
public class DoubleNumber implements Comparable<DoubleNumber>{
    double number;

    public DoubleNumber(double number) {
        this.number = number;
    }
/*attention please:if you want to implements the Comparable Interface,then specify the
* correct type(class)in the  generic (input to the Comparable<Type > */
    @Override
    public int compareTo(DoubleNumber o) {
        //return (int) (this.number-o.number);//(not sgn function,that it couldn't to be used to compare double/float types)
        double difference=this.number-o.number;
        if(difference>0){
            return 1;
        }else if(difference==0){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
    //    void addSomeDoubleNumbers
}
