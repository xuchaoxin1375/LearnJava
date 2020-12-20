package study.fox_and_rabbit.field;

import java.util.ArrayList;

import study.fox_and_rabbit.cell.Cell;

public class Field {
//����(��¼)
    private int width;
    private int height;
    private Cell[][] field;//����һ��Cell���͵Ķ�ά����field,��Field����Ҫʵ��

    public Field(int width, int height){
        this.height = height;
        this.width = width;
        field = new Cell[height][width];//ʵ����field
    }//��Ұ��Ĺ�����

    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
//ȡ������(row,col)����λ���ϵĶ���
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
    //�г���������Χ��cell������
    public Location[] getFreeNeighbour(int row, int col) {
        ArrayList<Location> list = new ArrayList<Location>();//����һ��Location���͵��б�(��̬����)
        /*�����i��j����Ϊƫ����*/
        for( int i = -1; i<2; i++ ) {//i=-1,0,1
            for( int j = -1; j<2; j++ ) {//i=-1,0,1
                /*�ӾŹ�������½��ж�.*/
                int r = row+i;
                int c = col+j;
                /*���ж�ƫ�Ƽ�����λ���Ƿ���field�������ܹ��ҵ���Ӧ��λ��(�Ϸ���),��Ϊ��������(row,col)�����Ǳ�Ե(��Ե��ȻҲ��������)��λ��,������û��ʵ�ʵľŹ���*/
                if( r>=0 && r<height && c>=0 && c<width && field[r][c] == null ) {/*�к��ж��ڸ���ά�����������ĺϷ�ֵ֮��*/
                    list.add(new Location(r, c));/*��ô���λ����Ϊ����Ч��,������뵽�����ص�������*/
                }//end_if
            }//end_for
        }//end_for
        return list.toArray(new Location[list.size()]);//�����ɵ��б���toArray()�������б�ת��Ϊ��ͨ����.(�÷�����Ҫһ������һ���������ͺ��ʵ��������:Location[list.size()],���������(Ԫ�ص�)����һ���Ǻ�list�е�Ԫ�ص�������һ�µ�.
    }

    public boolean placeRandomAdj( int row, int col, Cell cell ){/*����ʵ������field�ĺ��ʵĿ�λ��ɾ��Cell�ӿڽӹ����baby ����(��ֵ����)*/
        boolean ret = false;
        Location[] FreeAdj = getFreeNeighbour(row, col);
        if( FreeAdj.length > 0 ){//���п�λ��
            int idx = (int)(Math.random()*FreeAdj.length);//����شӿ�λ������FreeAdj��ѡȡĳ����λ��(����)
            field[FreeAdj[idx].getRow()][FreeAdj[idx].getCol()] = cell;//���¶�����������λ����(��Ҫ�������λ�ö���FreeAdj[idx]����field���������Ϣ.
            ret = true;
        }
        return ret;
    }
/*remove������(row,col)λ��cell��������Ϊnull*/
    public Cell remove( int row, int col ){
        Cell ret = field[row][col];
        field[row][col] = null;
        return ret;//���ر�ɾ���Ķ�������һ��
    }

    public void remove( Cell cell ){
        /*Ϊ�˹رոö�������λ�õ�����ͼ�����,��Ҫͨ������ѭ���ҵ��������(ƥ�䵽)*/
        for( int row = 0; row < height; row++ ){
            for( int col = 0; col <width; col++ ){
                if( field[row][col] == cell ){//ʹ��==���ж�ƥ�����(�ǱȽ϶��������(��ַ),��ֹ���ֲ�����ͬ�Ķ�����������ɲ�Ψһ��.(ÿ��������ڴ��ַ��Ψһ��.)
                    field[row][col] = null;//����Ϊnull,���ر���ʾ
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
        /*�ƶ�����ʵ���Ͼ��ǽ�field(row,col)λ�õĶ�������ô�ֵ����λ�ô�*/
        field[loc.getRow()][loc.getCol()] = field[row][col];
        /*���Ӿ������ϲ�����λ���ϵ�ͼ��*/
        remove(row,col);
    }

    public Cell place(int row, int col, Cell c) {
        Cell ret = field[row][col];
        field[row][col] = c;
        return ret;
    }
}
