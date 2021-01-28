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

        map.put("The_admin", "�ñ���Բ������ֶ�:Aid,AName,APhone,AAccount");
        map.put("The_customer", "�ñ���Բ������ֶ�:CAccount,CName,CSex,CAge,CPhone,CAddress");
        map.put("The_discuss", "�ñ���Բ������ֶ�:CName,GName,Content,DTime");
        map.put("The_goods", "�ñ���Բ������ֶ�:Gid,KName,GName,Promotion,SaleNum,GAddress,SPrice,GStatus");
        map.put("The_kinds", "�ñ���Բ������ֶ�:Kid,KName");
        map.put("The_manipulate", "�ñ���Բ������ֶ�:Aid,AName,Gid,GName,Record,MTime");
        map.put("The_order", "�ñ���Բ������ֶ�:Oid,Cid,CName,Gid,GName,GNumber,Fare,Remarks,Status");
        map.put("The_shopcart", "�ñ���Բ������ֶ�:Aid,CName,Gid,GName,INumber");
    }

    public void getInformation(String tableName) {
        String columns=map.get(tableName);
        if(columns==null){
            System.out.println("�������Ա��ֱ���޸ı�,�����,������޸���ͼ,�����ڸ���ͼ,�����Ƿ������ͼ��.");
        }else{
            System.out.println(columns);
        }

    }

    /*���Ա���İ���ӳ�书�ܣ�*/
    public static void main(String[] args) {
//        this();
        new SqlDictionary().getInformation("The_customer");

        System.out.println();
    }
}
