package sql;


import java.sql.*;
import java.util.Scanner;

/**
 * @Author xuchaoxin
 * @Date 2021/1/24 8:33
 * @Version 1.0
 * the detail and improved version(if I update it ) to see:
 * the github repository (search the article):https://github.com/xuchaoxin1375/LearnJava
 */
public class SimpleSearch {
    /**
     * 本类涉及的核心类(的实例)包括:ResultSet类,ResultSetMetaData类
     * @return
     */
//    public static void simpleSearch() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入你要查看的表(视图)");
//        System.out.println("普通客户可以查找的表(视图)");
//        String sql = scanner.nextLine();
//        //todo 执行sql语句，并返回结果
//        /*查询一张视图的所有信息*/
//        ConnectMySql connectMySql = new ConnectMySql();
//        /*执行查询的语句*/
//        // ResultSet rs = connectMySql.getStatement().executeQuery("select * from " + sqlInquiry);
//        PreparedStatement pstmt = null; //= connectMySql.getConnection().prepareStatement()
//        pstmt = connectMySql.getPreparedStatement("select * from " + sql);
//        ResultSet rs = null;
//        rs = pstmt.executeQuery();
//        ResultSetMetaData rsmd = rs.getMetaData();//Retrieves the number, types and properties of this ResultSet object's columns.
//        while (rs.next()) {
//            for (int i = 0; i < rsmd.getColumnCount(); i++) {
//                String col_name = rsmd.getCatalogName(i + 1);
//                Object value = rs.getObject(col_name);
//                System.out.println(value);
//                /*Field field;//反射
//                field=*/
//            }
//        }
//
//        //关闭资源链接
//        rs.close();
//        connectMySql.closeConnection();
//    }
    /*获得当前时间:*/
//    public static String gainTime() {
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = sdf.format(date);
//        return dateString;
//    }
        /*
     * 测试ResultSet获得SQL查询结果
     */
    public static void main(String[] args) throws SQLException {
        System.out.println("testing...");
        ConnectMySql connectMySql = new ConnectMySql();
        System.out.println("输入sql查询语句:示例:select * from Goods where kid=2");
        Scanner scanner = new Scanner(System.in);
        String sqlSearch = scanner.nextLine();

        /*对查询结果进行处理并打印出来:*/
        try {
            //查询语句
            //String sql1 = "select * from Goods";
            //System.out.println("简单查询:示例:select * from Goods where kid=2");
            //String sqlSearch="select * from "+table+" where kid=2";
//            System.out.println("输入需要查询的字段:例如:Gid GName");
//            String columns=scanner.nextLine();
//            System.out.println("输入需要查询的表:示例:The_goods");
//            String tables=scanner.nextLine();
//            System.out.println("输入需本次查询需要满足的条件:示例:where kid=2");
//            String where=scanner.nextLine().trim();
            // String sqlSearch="select "+columns+" from "+tables+" "+where;
            /*由于我将sql查询的字段名称的打印方法封装到了ConnectMySql，故可一键打印。*/
            connectMySql.printColumnNames(sqlSearch);
            connectMySql.printSearchResult(sqlSearch);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭顺序: ResultSet-->(Prepared)Statement-->Connection
            connectMySql.closeAll();
        }
    }
/*    public static void main(String[] args) throws SQLException{
      //  simpleSearch();
    }*/
//    public static void simpleSearch() {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入需要查询的表:示例:The_goods_a");
//        String tables = scanner.nextLine();
//        /*查找视图字典:*/
//        String[] tableArray = tables.split(" ");
//        SqlDictionary sqlDictionary = new SqlDictionary();
//        for (String tableName : tableArray) {
//            sqlDictionary.getInformation(tableName);
//        }
//        try {
//            //注册类
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //建立连接
//            conn = new ConnectMySql().getConnection();
//
//            System.out.println("输入需要查询的字段(逗号分隔不同字段):例如:Gid,GName");
//            String columns = scanner.nextLine();
//            System.out.println("输入需本次查询需要满足的条件:示例:where kid=2");
//            String where = scanner.nextLine().trim();
//            String sqlSearch = "select " + columns + " from " + tables + " " + where;
//            ps = conn.prepareStatement(sqlSearch);
//            rs = ps.executeQuery();
//            //获取列数
//            ResultSetMetaData md = rs.getMetaData();
//            int columnSize = md.getColumnCount();
//            System.out.println("查询结果如下:");
//            //打印字段名
//            for (int i = 1; i <= columnSize; i++) {
//                System.out.printf("%-12s", md.getColumnName(i));
//            }
//            System.out.println();
//            //打印所有记录
//            while (rs.next()) {
//                for (int i = 1; i <= columnSize; i++) {
//                    System.out.printf("%-12s", rs.getObject(i));
//                }
//                System.out.println();
//            }
//            System.out.println("\n结束查询");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //关闭顺序: ResultSet-->Statement-->Connection
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            try {
//                if (ps != null) {
//                    ps.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
