package com.luoding.zk;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * author: ding.luo
 * time: 17-3-17 下午5:02
 */
public class ZKTest {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        String host = "192.168.230.129:2181";

        ZooKeeper zk = new ZooKeeper(host, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("已经触发了事件 " + event.getType() + " !");
            }
        });
        zk.create("/testRootPath","testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/testRootPath","testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        zk.create("/testRootPath/testChildPathOne","testChildPathOne".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);


        System.out.println(new String(zk.getData("/testRootPath",false,null)));
        System.out.println(zk.getChildren("/testRootPath",true));
        zk.setData("/testRootPath/testChildPathOne","modifyChildPathOne".getBytes(),-1);
        System.out.println("目录节点状态["+zk.exists("/testRootPath",true)+"]");

        zk.create("/testRootPath/testChildPathTwo","testChildPathTwo".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null)));
        zk.delete("/testRootPath/testChildPathTwo",-1);
        zk.delete("/testRootPath/testChildPathOne",-1);
        zk.close();

    }
}
