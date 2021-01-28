package sql;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author xuchaoxin
 * @Date 2021/1/23 22:35
 * @Version 1.0
 * the detail and improved version(if I update it ) to see:
 * the github repository (search the article):https://github.com/xuchaoxin1375/LearnJava
 */
public class UseMySql {
    /*Statement 和 PreparedStatement之间的关系和区别.
    关系：PreparedStatement继承自Statement,都是接口
    区别：PreparedStatement可以使用占位符，是预编译的，批处理比Statement效率高
     PreparedStatement prepareStatement?(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException
创建一个PreparedStatement对象，该对象将生成具有给定类型，并发性和可ResultSet对象。
此方法与上面的prepareStatement方法相同，但它允许覆盖默认结果集类型，并发性和可保持性。

参数
sql - 一个String对象，它是要发送到数据库的SQL语句; 可能包含一个或多个'？' IN参数
resultSetType -下列操作之一 ResultSet常量： ResultSet.TYPE_FORWARD_ONLY ， ResultSet.TYPE_SCROLL_INSENSITIVE ，或 ResultSet.TYPE_SCROLL_SENSITIVE
resultSetConcurrency - 以下 ResultSet常量之一： ResultSet.CONCUR_READ_ONLY或 ResultSet.CONCUR_UPDATABLE
resultSetHoldability - 以下 ResultSet常量之一： ResultSet.HOLD_CURSORS_OVER_COMMIT或 ResultSet.CLOSE_CURSORS_AT_COMMIT
结果
一个新的 PreparedStatement对象，包含预编译的SQL语句，它将生成具有给定类型，并发性和可 ResultSet对象
异常
SQLException - 如果发生数据库访问错误，则在关闭的连接上调用此方法，或者给定的参数不是 ResultSet常量，指示类型，并发性和可保持性
SQLFeatureNotSupportedException - 如果JDBC驱动程序不支持此方法，或者指定的结果集类型不支持此方法，则结果集可保持性和结果集并发。
     */
    /*统一输入流对象*/
    static Scanner scanner = new Scanner(System.in);
    /*统一链接对象*/
    static ConnectMySql connectMySql = new ConnectMySql();

    public static void search() throws SQLException {
        System.out.println("testing...");
        ConnectMySql connectMySql = new ConnectMySql();
        System.out.println("输入sql查询语句:示例:select * from Goods where kid=2");
        Scanner scanner = new Scanner(System.in);
        String sqlSearch = scanner.nextLine();

        /*对查询结果进行处理并打印出来:*/
        try {
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

    public static void simpleSearch() throws SQLException {
       /* System.out.println("输入要查询表:示例:Kinds");
        Scanner scanner = new Scanner(System.in);
        String table=scanner.nextLine();
        */
        System.out.println("将执行类似于：select g_name,k_name  from The_goods_a where kid='06'的查询动作");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入需要查询的表:示例:The_goods_a");
        String tables = scanner.nextLine();
        /*查找视图字典:*/
        String[] tableArray = tables.split(" ");
        for (String tableName : tableArray) {
            //sqlDictionary.getInformation(tableName);
            System.out.println("申请被插入的视图的信息...");
            System.out.println(connectMySql.getColumnNames(tableName));
        }
        try {
            //查询语句
            //String sql1 = "select * from Goods";
            //System.out.println("简单查询:示例:select * from Goods where kid=2");
            //String sqlSearch="select * from "+table+" where kid=2";
            /*交互阶段:*/
            System.out.println("输入需要查询的字段(逗号分隔不同字段):例如:Gid,GName");
            String columns = scanner.nextLine();
            System.out.println("输入需本次查询需要满足的条件(注意要由where引出条件:示例:where kid=2");
            String where = scanner.nextLine().trim();
            String sqlSearch = "select " + columns + " from " + tables + " " + where;
            System.out.println("将执行" + sqlSearch);
            /*开始处理sql命令*/
            System.out.println("查询结果如下:");
            connectMySql.printColumnNames(sqlSearch);
            connectMySql.printSearchResult(sqlSearch);
        } finally {
            connectMySql.closeAll();
        }
    }

    public static void simpleSearchTable() throws SQLException {
        System.out.println("输入要查询表:示例:Kinds");
        Scanner scanner = new Scanner(System.in);
        String table = scanner.nextLine();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql1 = "select * from " + table;
        //ps = conn.prepareStatement(sql1);
        ps = new ConnectMySql().getPreparedStatement(sql1);
        rs = ps.executeQuery();
        //获取列数
        ResultSetMetaData md = rs.getMetaData();
        int columnSize = md.getColumnCount();
        System.out.println("查询结果如下:");
        //打印字段名
        for (int i = 1; i <= columnSize; i++) {
            System.out.printf("%-12s", md.getColumnName(i));
        }
        System.out.println();
        //打印所有记录
        while (rs.next()) {
            for (int i = 1; i <= columnSize; i++) {
                System.out.printf("%-12s", rs.getObject(i));
            }
            System.out.println();
        }
        System.out.println("\n结束查询");
        //关闭顺序: ResultSet-->Statement-->Connection
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //
    }

    public static void insert() throws SQLException {
        //SimpleSearch.simpleSearch();
        System.out.println("输入插入语句:示例:insert into Kinds values('13','hhh')");
        Scanner scanner = new Scanner(System.in);
//插入语句示例:insert into Kinds values('13','hhh')
        String insertSql = scanner.nextLine();
        /*PreparedStatement extends Statement
         * 执行插入语句:(示例语句:
         * 插入语句示例:insert into Kinds values('13','hhh')
         */
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(insertSql);
        /*采用execute()方式执行语句*/
        preparedStatement.execute();
        System.out.println("插入成功.");

    }

    public static void simpleInsert() throws SQLException {
        //SimpleSearch.simpleSearch();
        System.out.println("简单插入模式:");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
//插入语句示例:insert into Kinds values('13','hhh')
        String insertPrefix = "insert into";

        // String insertSql = scanner.nextLine();
        System.out.println("输入被插入的表:");
        String table = scanner.nextLine();

        //new SqlDictionary().getInformation(table);
        System.out.println("申请被插入的视图的信息...");
        System.out.println(connectMySql.getColumnNames(table));

        System.out.println("输入values(形如values('13','hhh'):");
        String values = scanner1.nextLine();
        /*关闭流：*/
        scanner.close();
        scanner1.close();
        String insertSql = "insert into " + table.trim() + " " + values;
        /*PreparedStatement extends Statement
         * 执行插入语句:(示例语句:
         * 插入语句示例:insert into Kinds values('13','hhh')
         */
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(insertSql);
        /*采用execute()方式执行语句*/
        preparedStatement.execute();

    }

    public static void update() throws SQLException {
        System.out.println("输入更新语句sql:示例:update Admin set AName='ju' where Aid='111'");
        /* 语句示例:update Admin set AName='ju' where Aid='111'*/
        String updateSql = scanner.nextLine();
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(updateSql);
        preparedStatement.execute();
        System.out.println("修改/更新成功");
    }

    public static void simpleUpdate() throws SQLException {
        System.out.println("简单修改模式：");
        System.out.println("输入要更新(修改)的表名");
        /*只有一个Scanner不便二次读入*/
        Scanner scanner = new Scanner(System.in);
        String table = scanner.nextLine();
        //scanner.close();
        new SqlDictionary().getInformation(table);
        System.out.println("输入待修改的字段('='号形式）:(形如:AName='ju')");
        String columnModify = scanner.next().trim();
        System.out.println("输入修改条件:形如:where Aid='111' ");
        Scanner scanner1 = new Scanner(System.in);
        String where = scanner1.nextLine();
        // scanner1.close();

        String updateSql = "update " + table + " set " + columnModify + " " + where;
        System.out.println("testing...");
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(updateSql);
        preparedStatement.execute();
        System.out.println("修改/更新成功");

    }

    public static void simpleDelete() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("简单删除:");
        System.out.println("输入要被删除记录的表:");
        String table = scanner.nextLine();
        /*提示该表具有的字段。*/
        //new SqlDictionary().getInformation(table);
        System.out.println(connectMySql.getColumnNames(table));

        System.out.println("输入where(形如:where Aid='234')");
        String where = scanner1.nextLine().trim();
        scanner.close();
        scanner1.close();
        /*示例:  delete from Admin where Aid='234'*/
        String deleteSql = "delete from " + table + " " + where;
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(deleteSql);
        preparedStatement.execute();
        System.out.println("删除成功");
    }

    public static void delete() throws SQLException {
        System.out.println("输入sql删除语句:示例:  delete from Admin where Aid='234'");
        /*示例:  delete from Admin where Aid='234'*/
        String deleteSql = scanner.nextLine();
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(deleteSql);
        preparedStatement.execute();
        System.out.println("删除成功");
    }

    public static void printUsingHelp() {
        //todo
        System.out.println("管理员Admin（管理员ID?Aid，姓名?AName，电话?APhone，账号AAccount，密码APwd,等级Level）\n" +
                "主键：Aid ?外键：Level\n" +
                "权限Permission(等级 Level,权限名 PName,说明 Illustration)\n" +
                "主键：Level\n" +
                "管理Manage（管理员ID?Aid，商品ID?Gid，操作日志?Record,操作时间 MTime）\n" +
                "主键：Gid和Aid 外键 Aid、Gid\n" +
                "商品Goods（商品名Gname，促销?Sale，库存Repertory，销量?Snumber，图片Picture，简介Introduce，商品ID?Gid,品类ID?Kid，发货地?Gaddress，售价?Sprice,进价Pprice,状态Gstatus）\n" +
                "主键：Gid ?外键：Kid\n" +
                "购物车Shopcart（购物车ID?Sid,客户ID?Cid，商品数量 Cnumber）\n" +
                "主键：Sid和Cid? 外键：Sid、Cid\n" +
                "客户Customer（电话Cphone，地址Caddress，余额Balance，客户ID?Cid,性别Csex，姓名Cname,账号Caccount，密码Cpwd）\n" +
                "主键：Cid?\n" +
                "订单Orders（订单号Oid，状态OStatus，下单时间Otime，客户ID?Cid,商品ID?Gid，商品数量?Gnumber，运费 Fare，备注：Remarks）\n" +
                "主键：Oid 外键：Gid，Cid\n" +
                "商品品类Kind（品类名?Kname，品类ID?Kid）\n" +
                "主键:Kid\n" +
                "评论Discuss（商品Gid ,客户ID Cid ,评论ID Did，评论内容 Content，评论时间 Dtime）主键：Did 外键：Gid、Cid");
    }

    /*  connectMySql.closeConnection();*/
    /*测试用的main*/
    public static void main(String[] args) throws SQLException {
        //delete();
        //insert();
        // update();
        //simpleDelete();
        simpleSearch();
        //simpleDelete();
       // search();
    }
}


// System.out.println();
//处理结果
/*        while (rs.next()) {
 *//*遍历各条记录的各个字段(比如goods表有五个字段*//*
            for(int i=1;i<=7;i++){
                System.out.print(rs.getString(i++) + "\t");
            }
            System.out.println();
        }*/