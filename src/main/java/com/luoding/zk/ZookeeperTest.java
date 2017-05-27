package com.luoding.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Date：16-9-20
 * Time：下午5:20
 *
 * @author ding.luo@corp.luoding .com
 */
public class ZookeeperTest {



    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {


        ZooKeeper zk = createConnection();
        System.out.println("hello");

        String node = "/app3";
        Stat stat = zk.exists(node, true);//检测/app1是否存在
        System.out.println(stat);

        if (stat == null) {
            //创建节点
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }

        //获取节点的值
        byte[] b = zk.getData(node, true, stat);
        System.out.println(new String(b));
        zk.close();

        System.out.println("结束");
    }

    static class DemoWatcher implements Watcher {
        @Override
        public void process(WatchedEvent event) {
            System.out.println("----------->");
            System.out.println("path:" + event.getPath());
            System.out.println("type:" + event.getType());
            System.out.println("stat:" + event.getState());
            System.out.println("<-----------");
        }
    }

    public static ZooKeeper createConnection() throws IOException {
        ZooKeeper zk = new ZooKeeper("192.168.234.5:2182",
                300000, new DemoWatcher());//连接zk server
        while (!zk.getState().equals(ZooKeeper.States.CONNECTED)) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return zk;
    }
}
