package study.oop.example;

import java.util.HashMap;

class Room {
    private String description;
    boolean isOk=true;
    /*设有一个容器*/
    private HashMap<String, Room> exits = new HashMap<String, Room>();//String型对象保存方向的字符串,Room型对象为房间
//constructor:描述这是个什么房间:
    public Room(String description) {
        this.description = description;
    }
//重写toString以便打印对象(的指定属性(字段))
    public String toString() {
        return description;
    }

    //设置(该房间指定出口方向通往的房间)(具体实现是将dir和room映射对放入容器exits对象中
    public void setExit(String dir, Room room) {
        exits.put(dir, room);
    }
//获取出口的描述信息:(将容器中保存的键(房间名)打印出来
    public String getExitDesc() {
        StringBuffer sb = new StringBuffer();//StringBuffer对象中的内容可以方便变动,开销较小
        int cnt=0;
        for (String s : exits.keySet()) {//迭代容器exits中保存的键值.
            sb.append(s);//挨个地将内容(这里是表示方向的字符串)添加到StringBuffer对象中.
            sb.append(" ");//追加一个空格来隔开,
            cnt++;
        }//这样就达到提示玩家,当前有那些方向可以走
        //统一处理这些字符串
        if(cnt==0){
            System.out.print("没有其他方向可走啦,");
            System.out.print("你落入陷阱了!!\n 游戏结束!");
            isOk=false;
        }
        return sb.toString();//返回字符串
    }
//获取当前房间执行go direction操作时将会到达那个地方(房间)(这一个方法也是提供给game的接口
    public Room getExit(String direction) {
        return exits.get(direction);
    }
public boolean isSave(){return  isOk;}

}

