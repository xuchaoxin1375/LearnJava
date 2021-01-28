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
    /*Statement �� PreparedStatement֮��Ĺ�ϵ������.
    ��ϵ��PreparedStatement�̳���Statement,���ǽӿ�
    ����PreparedStatement����ʹ��ռλ������Ԥ����ģ��������StatementЧ�ʸ�
     PreparedStatement prepareStatement?(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException
����һ��PreparedStatement���󣬸ö������ɾ��и������ͣ������ԺͿ�ResultSet����
�˷����������prepareStatement������ͬ������������Ĭ�Ͻ�������ͣ������ԺͿɱ����ԡ�

����
sql - һ��String��������Ҫ���͵����ݿ��SQL���; ���ܰ���һ������'��' IN����
resultSetType -���в���֮һ ResultSet������ ResultSet.TYPE_FORWARD_ONLY �� ResultSet.TYPE_SCROLL_INSENSITIVE ���� ResultSet.TYPE_SCROLL_SENSITIVE
resultSetConcurrency - ���� ResultSet����֮һ�� ResultSet.CONCUR_READ_ONLY�� ResultSet.CONCUR_UPDATABLE
resultSetHoldability - ���� ResultSet����֮һ�� ResultSet.HOLD_CURSORS_OVER_COMMIT�� ResultSet.CLOSE_CURSORS_AT_COMMIT
���
һ���µ� PreparedStatement���󣬰���Ԥ�����SQL��䣬�������ɾ��и������ͣ������ԺͿ� ResultSet����
�쳣
SQLException - ����������ݿ���ʴ������ڹرյ������ϵ��ô˷��������߸����Ĳ������� ResultSet������ָʾ���ͣ������ԺͿɱ�����
SQLFeatureNotSupportedException - ���JDBC��������֧�ִ˷���������ָ���Ľ�������Ͳ�֧�ִ˷������������ɱ����Ժͽ����������
     */
    /*ͳһ����������*/
    static Scanner scanner = new Scanner(System.in);
    /*ͳһ���Ӷ���*/
    static ConnectMySql connectMySql = new ConnectMySql();

    public static void search() throws SQLException {
        System.out.println("testing...");
        ConnectMySql connectMySql = new ConnectMySql();
        System.out.println("����sql��ѯ���:ʾ��:select * from Goods where kid=2");
        Scanner scanner = new Scanner(System.in);
        String sqlSearch = scanner.nextLine();

        /*�Բ�ѯ������д�����ӡ����:*/
        try {
            /*�����ҽ�sql��ѯ���ֶ����ƵĴ�ӡ������װ����ConnectMySql���ʿ�һ����ӡ��*/
            connectMySql.printColumnNames(sqlSearch);
            connectMySql.printSearchResult(sqlSearch);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�ر�˳��: ResultSet-->(Prepared)Statement-->Connection
            connectMySql.closeAll();
        }
    }

    public static void simpleSearch() throws SQLException {
       /* System.out.println("����Ҫ��ѯ��:ʾ��:Kinds");
        Scanner scanner = new Scanner(System.in);
        String table=scanner.nextLine();
        */
        System.out.println("��ִ�������ڣ�select g_name,k_name  from The_goods_a where kid='06'�Ĳ�ѯ����");
        Scanner scanner = new Scanner(System.in);
        System.out.println("������Ҫ��ѯ�ı�:ʾ��:The_goods_a");
        String tables = scanner.nextLine();
        /*������ͼ�ֵ�:*/
        String[] tableArray = tables.split(" ");
        for (String tableName : tableArray) {
            //sqlDictionary.getInformation(tableName);
            System.out.println("���뱻�������ͼ����Ϣ...");
            System.out.println(connectMySql.getColumnNames(tableName));
        }
        try {
            //��ѯ���
            //String sql1 = "select * from Goods";
            //System.out.println("�򵥲�ѯ:ʾ��:select * from Goods where kid=2");
            //String sqlSearch="select * from "+table+" where kid=2";
            /*�����׶�:*/
            System.out.println("������Ҫ��ѯ���ֶ�(���ŷָ���ͬ�ֶ�):����:Gid,GName");
            String columns = scanner.nextLine();
            System.out.println("�����豾�β�ѯ��Ҫ���������(ע��Ҫ��where��������:ʾ��:where kid=2");
            String where = scanner.nextLine().trim();
            String sqlSearch = "select " + columns + " from " + tables + " " + where;
            System.out.println("��ִ��" + sqlSearch);
            /*��ʼ����sql����*/
            System.out.println("��ѯ�������:");
            connectMySql.printColumnNames(sqlSearch);
            connectMySql.printSearchResult(sqlSearch);
        } finally {
            connectMySql.closeAll();
        }
    }

    public static void simpleSearchTable() throws SQLException {
        System.out.println("����Ҫ��ѯ��:ʾ��:Kinds");
        Scanner scanner = new Scanner(System.in);
        String table = scanner.nextLine();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql1 = "select * from " + table;
        //ps = conn.prepareStatement(sql1);
        ps = new ConnectMySql().getPreparedStatement(sql1);
        rs = ps.executeQuery();
        //��ȡ����
        ResultSetMetaData md = rs.getMetaData();
        int columnSize = md.getColumnCount();
        System.out.println("��ѯ�������:");
        //��ӡ�ֶ���
        for (int i = 1; i <= columnSize; i++) {
            System.out.printf("%-12s", md.getColumnName(i));
        }
        System.out.println();
        //��ӡ���м�¼
        while (rs.next()) {
            for (int i = 1; i <= columnSize; i++) {
                System.out.printf("%-12s", rs.getObject(i));
            }
            System.out.println();
        }
        System.out.println("\n������ѯ");
        //�ر�˳��: ResultSet-->Statement-->Connection
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
        System.out.println("����������:ʾ��:insert into Kinds values('13','hhh')");
        Scanner scanner = new Scanner(System.in);
//�������ʾ��:insert into Kinds values('13','hhh')
        String insertSql = scanner.nextLine();
        /*PreparedStatement extends Statement
         * ִ�в������:(ʾ�����:
         * �������ʾ��:insert into Kinds values('13','hhh')
         */
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(insertSql);
        /*����execute()��ʽִ�����*/
        preparedStatement.execute();
        System.out.println("����ɹ�.");

    }

    public static void simpleInsert() throws SQLException {
        //SimpleSearch.simpleSearch();
        System.out.println("�򵥲���ģʽ:");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
//�������ʾ��:insert into Kinds values('13','hhh')
        String insertPrefix = "insert into";

        // String insertSql = scanner.nextLine();
        System.out.println("���뱻����ı�:");
        String table = scanner.nextLine();

        //new SqlDictionary().getInformation(table);
        System.out.println("���뱻�������ͼ����Ϣ...");
        System.out.println(connectMySql.getColumnNames(table));

        System.out.println("����values(����values('13','hhh'):");
        String values = scanner1.nextLine();
        /*�ر�����*/
        scanner.close();
        scanner1.close();
        String insertSql = "insert into " + table.trim() + " " + values;
        /*PreparedStatement extends Statement
         * ִ�в������:(ʾ�����:
         * �������ʾ��:insert into Kinds values('13','hhh')
         */
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(insertSql);
        /*����execute()��ʽִ�����*/
        preparedStatement.execute();

    }

    public static void update() throws SQLException {
        System.out.println("����������sql:ʾ��:update Admin set AName='ju' where Aid='111'");
        /* ���ʾ��:update Admin set AName='ju' where Aid='111'*/
        String updateSql = scanner.nextLine();
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(updateSql);
        preparedStatement.execute();
        System.out.println("�޸�/���³ɹ�");
    }

    public static void simpleUpdate() throws SQLException {
        System.out.println("���޸�ģʽ��");
        System.out.println("����Ҫ����(�޸�)�ı���");
        /*ֻ��һ��Scanner������ζ���*/
        Scanner scanner = new Scanner(System.in);
        String table = scanner.nextLine();
        //scanner.close();
        new SqlDictionary().getInformation(table);
        System.out.println("������޸ĵ��ֶ�('='����ʽ��:(����:AName='ju')");
        String columnModify = scanner.next().trim();
        System.out.println("�����޸�����:����:where Aid='111' ");
        Scanner scanner1 = new Scanner(System.in);
        String where = scanner1.nextLine();
        // scanner1.close();

        String updateSql = "update " + table + " set " + columnModify + " " + where;
        System.out.println("testing...");
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(updateSql);
        preparedStatement.execute();
        System.out.println("�޸�/���³ɹ�");

    }

    public static void simpleDelete() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("��ɾ��:");
        System.out.println("����Ҫ��ɾ����¼�ı�:");
        String table = scanner.nextLine();
        /*��ʾ�ñ���е��ֶΡ�*/
        //new SqlDictionary().getInformation(table);
        System.out.println(connectMySql.getColumnNames(table));

        System.out.println("����where(����:where Aid='234')");
        String where = scanner1.nextLine().trim();
        scanner.close();
        scanner1.close();
        /*ʾ��:  delete from Admin where Aid='234'*/
        String deleteSql = "delete from " + table + " " + where;
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(deleteSql);
        preparedStatement.execute();
        System.out.println("ɾ���ɹ�");
    }

    public static void delete() throws SQLException {
        System.out.println("����sqlɾ�����:ʾ��:  delete from Admin where Aid='234'");
        /*ʾ��:  delete from Admin where Aid='234'*/
        String deleteSql = scanner.nextLine();
        PreparedStatement preparedStatement = connectMySql.getConnection().prepareStatement(deleteSql);
        preparedStatement.execute();
        System.out.println("ɾ���ɹ�");
    }

    public static void printUsingHelp() {
        //todo
        System.out.println("����ԱAdmin������ԱID?Aid������?AName���绰?APhone���˺�AAccount������APwd,�ȼ�Level��\n" +
                "������Aid ?�����Level\n" +
                "Ȩ��Permission(�ȼ� Level,Ȩ���� PName,˵�� Illustration)\n" +
                "������Level\n" +
                "����Manage������ԱID?Aid����ƷID?Gid��������־?Record,����ʱ�� MTime��\n" +
                "������Gid��Aid ��� Aid��Gid\n" +
                "��ƷGoods����Ʒ��Gname������?Sale�����Repertory������?Snumber��ͼƬPicture�����Introduce����ƷID?Gid,Ʒ��ID?Kid��������?Gaddress���ۼ�?Sprice,����Pprice,״̬Gstatus��\n" +
                "������Gid ?�����Kid\n" +
                "���ﳵShopcart�����ﳵID?Sid,�ͻ�ID?Cid����Ʒ���� Cnumber��\n" +
                "������Sid��Cid? �����Sid��Cid\n" +
                "�ͻ�Customer���绰Cphone����ַCaddress�����Balance���ͻ�ID?Cid,�Ա�Csex������Cname,�˺�Caccount������Cpwd��\n" +
                "������Cid?\n" +
                "����Orders��������Oid��״̬OStatus���µ�ʱ��Otime���ͻ�ID?Cid,��ƷID?Gid����Ʒ����?Gnumber���˷� Fare����ע��Remarks��\n" +
                "������Oid �����Gid��Cid\n" +
                "��ƷƷ��Kind��Ʒ����?Kname��Ʒ��ID?Kid��\n" +
                "����:Kid\n" +
                "����Discuss����ƷGid ,�ͻ�ID Cid ,����ID Did���������� Content������ʱ�� Dtime��������Did �����Gid��Cid");
    }

    /*  connectMySql.closeConnection();*/
    /*�����õ�main*/
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
//������
/*        while (rs.next()) {
 *//*����������¼�ĸ����ֶ�(����goods��������ֶ�*//*
            for(int i=1;i<=7;i++){
                System.out.print(rs.getString(i++) + "\t");
            }
            System.out.println();
        }*/