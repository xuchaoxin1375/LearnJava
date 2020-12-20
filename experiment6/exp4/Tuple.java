package experiment6.exp4;

public class Tuple {
    String string;
    int num;

    public Tuple(String string, int num) {
        this.string = string;
        this.num = num;
    }

    public String getKey() {
        return string;
    }

    public int getValue() {
        return num;
    }

    @Override
    public String toString() {
        return getKey()+"\t"+getValue() +"\n";// +"\n"
    }
}
