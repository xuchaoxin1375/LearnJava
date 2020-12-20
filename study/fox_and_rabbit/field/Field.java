package study.fox_and_rabbit.field;

import java.util.ArrayList;

import study.fox_and_rabbit.cell.Cell;

public class Field {
//数据(记录)
    private int width;
    private int height;
    private Cell[][] field;//声明一个Cell类型的二维数组field,是Field的主要实现

    public Field(int width, int height){
        this.height = height;
        this.width = width;
        field = new Cell[height][width];//实例化field
    }//田野类的构造器

    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
//取得网格(row,col)处的位置上的对象
    public Cell get(int row, int col){
        return field[row][col];
    }

    public Cell[] getNeighbour(int row, int col) {
        ArrayList<Cell> list = new ArrayList<Cell>();
        for( int i = -1; i<2; i++ ) {
            for( int j = -1; j<2; j++ ) {
                int r = row+i;
                int c = col+j;
                if( r>-1 && r<height && c>-1 && c<width && !(r == row && c == col)) {
                    list.add(field[r][c]);
                }
            }
        }
        return list.toArray(new Cell[list.size()]);
    }
    //列出并返回周围空cell的数组
    public Location[] getFreeNeighbour(int row, int col) {
        ArrayList<Location> list = new ArrayList<Location>();//申请一个Location类型的列表(动态数组)
        /*这里的i和j还作为偏移量*/
        for( int i = -1; i<2; i++ ) {//i=-1,0,1
            for( int j = -1; j<2; j++ ) {//i=-1,0,1
                /*从九宫格的左下角判断.*/
                int r = row+i;
                int c = col+j;
                /*再判断偏移计算后的位置是否在field网格上能够找到相应的位置(合法性),因为如果传入的(row,col)可能是边缘(边缘当然也包括角落)的位置,这样就没有实际的九宫格*/
                if( r>=0 && r<height && c>=0 && c<width && field[r][c] == null ) {/*行和列都在各自维度数组索引的合法值之内*/
                    list.add(new Location(r, c));/*那么这个位置认为是有效的,将其加入到待返回的数组中*/
                }//end_if
            }//end_for
        }//end_for
        return list.toArray(new Location[list.size()]);//将生成的列表用toArray()方法将列表转换为普通数组.(该方法需要一个传入一个规格和类型合适的数组对象:Location[list.size()],数组参数的(元素的)类型一般是和list中的元素的类型是一致的.
    }

    public boolean placeRandomAdj( int row, int col, Cell cell ){/*基本实现是让field的合适的空位置删的Cell接口接管这个baby 动物(赋值引用)*/
        boolean ret = false;
        Location[] FreeAdj = getFreeNeighbour(row, col);
        if( FreeAdj.length > 0 ){//还有空位置
            int idx = (int)(Math.random()*FreeAdj.length);//随机地从空位置数组FreeAdj中选取某个空位置(对象)
            field[FreeAdj[idx].getRow()][FreeAdj[idx].getCol()] = cell;//将新动物放置于这个位置上(需要访问这个位置对象FreeAdj[idx]的在field里的坐标信息.
            ret = true;
        }
        return ret;
    }
/*remove方法将(row,col)位置cell管理者设为null*/
    public Cell remove( int row, int col ){
        Cell ret = field[row][col];
        field[row][col] = null;
        return ret;//返回被删除的对象是哪一个
    }

    public void remove( Cell cell ){
        /*为了关闭该对象所在位置的网格图形填充,需要通过二重循环找到这个对象(匹配到)*/
        for( int row = 0; row < height; row++ ){
            for( int col = 0; col <width; col++ ){
                if( field[row][col] == cell ){//使用==来判断匹配与否(是比较对象的引用(地址),防止出现参数相同的多个对象对象造成不唯一性.(每个对象的内存地址是唯一的.)
                    field[row][col] = null;//设置为null,即关闭显示
                    break;
                }
            }
        }
    }

    public void clear(){
        for( int i = 0; i < height; i++){
            for( int j = 0; j < width; j++){
                field[i][j] = null;
            }
        }
    }

    public void move(int row, int col, Location loc){
        /*移动操作实际上就是将field(row,col)位置的对象的引用传值给新位置处*/
        field[loc.getRow()][loc.getCol()] = field[row][col];
        /*在视觉表现上擦除就位置上的图形*/
        remove(row,col);
    }

    public Cell place(int row, int col, Cell c) {
        Cell ret = field[row][col];
        field[row][col] = c;
        return ret;
    }
}
