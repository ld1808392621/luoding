package com.luoding.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * author: ding.luo
 * time: 17-1-18 下午5:23
 */
public class HBaseTest {

    static Configuration cfg = null;
    static {
        cfg = HBaseConfiguration.create();
        cfg.set("hbase.zookeeper.quorum", "linux-platform-storm-234-5,linux-platform-storm-234-6,linux-platform-storm-234-7");
        cfg.set("hbase.zookeeper.property.clientPort", "2182");
    }

    /**
     * 创建一张表
     */
    public static void creatTable(String tablename) throws Exception {
        HBaseAdmin admin = new HBaseAdmin(cfg);
        if (admin.tableExists(tablename)) {
            System.out.println("table   Exists!!!");
        }
        else{
            HTableDescriptor tableDesc = new HTableDescriptor(tablename);
            tableDesc.addFamily(new HColumnDescriptor("name"));
            admin.createTable(tableDesc);
            System.out.println("create table ok .");
        }

    }

    /**
     * 添加一条数据
     */
    public static void addData (String tablename) throws Exception{
        HTable table = new HTable(cfg, tablename);
        Put put = new Put(Bytes.toBytes("Huangyi"));
        put.add(Bytes.toBytes("name"),Bytes.toBytes("java"), "http://www.javabloger.com".getBytes());
        table.put(put);
        System.out.println("add data ok .");
    }

    /**
     * 显示所有数据
     */
    public static void getAllData (String tablename) throws Exception{
        HTable table = new HTable(cfg, tablename);
        Scan s = new Scan();
        ResultScanner ss = table.getScanner(s);
        for(Result r:ss){
            for(KeyValue kv:r.raw()){
                System.out.print(new String(kv.getKeyString()));
                System.out.println(new String(kv.getValue()));
            }
        }
    }


    public static void  main (String [] agrs) {
        try {
            String tablename="table";
            HBaseTest.creatTable(tablename);
            HBaseTest.addData(tablename);
            HBaseTest.getAllData(tablename);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
