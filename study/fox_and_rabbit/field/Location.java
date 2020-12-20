package study.fox_and_rabbit.field;
/*记录field中位置信息的类*/
public class Location{
    private int row;
    private int col;
//constructor:
    public Location( int row, int col ){
        this.col = col;
        this.row = row;
    }

    public int getRow(){
        return row;
    }
    public int getCol() {
        return col;
    }
}
