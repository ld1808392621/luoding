package com.luoding.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.io.IOException;

/**
 * author: ding.luo
 * time: 17-1-19 下午5:25
 */
public class HBaseLearn {

    final static String tableName = "tablename1";

    static Configuration cfg = HBaseConfiguration.create();

    static HBaseAdmin admin;

    static {
        cfg.set("hbase.zookeeper.quorum", "linux-platform-CRM-233-80");
        cfg.set("hbase.zookeeper.property.clientPort", "2181");
        try {
            admin = new HBaseAdmin(cfg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        createTable();
        //listTable();
        //addColumn();
        //add();
        //get();
        //scan();
    }

    public static void createTable() throws IOException {

        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        tableDescriptor.addFamily(new HColumnDescriptor("personal"));
        tableDescriptor.addFamily(new HColumnDescriptor("professional"));
        admin.createTable(tableDescriptor);
        System.out.println("create table success");
    }

    public static void listTable() throws IOException {

        HTableDescriptor[] tableDescriptors = admin.listTables();
        for (HTableDescriptor tableDescriptor : tableDescriptors) {
            System.out.println(tableDescriptor.getTableName());
        }
    }

    public static void addColumn() throws IOException {
        HColumnDescriptor columnDescriptor = new HColumnDescriptor("age");
        admin.addColumn("emp1", columnDescriptor);
    }

    public static void add() throws IOException {

        HTable table = new HTable(cfg, tableName);
        Put put = new Put(Bytes.toBytes("4"));
        put.add(Bytes.toBytes("name"), Bytes.toBytes("last"), Bytes.toBytes("luoding"));
        table.put(put);
        table.close();
    }

    public static void get() throws IOException {

        HTable table = new HTable(cfg, tableName);
        Get get = new Get(Bytes.toBytes("2"));
        get.addFamily(Bytes.toBytes("name"));

        Result result = table.get(get);
        if(null == result.listCells()){
            System.out.println("helo");
        }
        for (Cell cell : result.listCells()) {
            System.out.println(new String(CellUtil.cloneQualifier(cell)));
            System.out.println(new String(CellUtil.cloneValue(cell)));
        }
        table.close();
    }

    public static void scan() throws IOException {

        HTable table = new HTable(cfg, tableName);
        Scan scan = new Scan();
        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result = resultScanner.next(); null != result; result = resultScanner.next()) {
            System.out.println(result);
            for (Cell cell : result.listCells()) {
                String str = "";
                str += new String(CellUtil.cloneValue(cell)) + "--";
                str += new String(CellUtil.cloneQualifier(cell)) + "--";
                str += new String(CellUtil.cloneFamily(cell));

                System.out.println(str);
            }
        }
        table.close();
    }

}
