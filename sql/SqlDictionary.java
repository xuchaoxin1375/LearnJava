package sql;

import java.util.HashMap;

/**
 * @Author xuchaoxin
 * @Date 2021/1/25 8:57
 * @Version 1.0
 * the detail and improved version(if I update it ) to see:
 * the github repository (search the article):https://github.com/xuchaoxin1375/LearnJava
 */
public class SqlDictionary {
    /*static*/ HashMap<String, String> map = new HashMap<>();

    public SqlDictionary() {

        map.put("The_admin", "该表可以操作的字段:Aid,AName,APhone,AAccount");
        map.put("The_customer", "该表可以操作的字段:CAccount,CName,CSex,CAge,CPhone,CAddress");
        map.put("The_discuss", "该表可以操作的字段:CName,GName,Content,DTime");
        map.put("The_goods", "该表可以操作的字段:Gid,KName,GName,Promotion,SaleNum,GAddress,SPrice,GStatus");
        map.put("The_kinds", "该表可以操作的字段:Kid,KName");
        map.put("The_manipulate", "该表可以操作的字段:Aid,AName,Gid,GName,Record,MTime");
        map.put("The_order", "该表可以操作的字段:Oid,Cid,CName,Gid,GName,GNumber,Fare,Remarks,Status");
        map.put("The_shopcart", "该表可以操作的字段:Aid,CName,Gid,GName,INumber");
    }

    public void getInformation(String tableName) {
        String columns=map.get(tableName);
        if(columns==null){
            System.out.println("如果管理员想直接修改表,则继续,如果想修改视图,不存在该视图,请检查是否输错视图名.");
        }else{
            System.out.println(columns);
        }

    }

    /*测试本类的帮助映射功能：*/
    public static void main(String[] args) {
//        this();
        new SqlDictionary().getInformation("The_customer");

        System.out.println();
    }
}
