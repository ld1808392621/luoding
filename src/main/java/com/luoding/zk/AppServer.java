package com.luoding.zk;

import org.apache.zookeeper.*;

/**
 * Date：16-10-12
 * Time：下午8:38
 *
 * @author ding.luo@corp.luoding .com
 */
public class AppServer {

    private String groupNode = "sgroup";

    private String subNode = "sub";

    /**
     * 连接zookeeper
     *
     * @param address server的地址
     */
    public void connectZookeeper(String address) throws Exception {
        ZooKeeper zk = new ZooKeeper("192.168.14.48:5180,192.168.14.48:5181,192.168.14.48:5182", 5000, new Watcher() {
            public void process(WatchedEvent event) {
                // 不做处理
            }
        });
        // 在"/sgroup"下创建子节点
        // 子节点的类型设置为EPHEMERAL_SEQUENTIAL, 表明这是一个临时节点, 且在子节点的名称后面加上一串数字后缀
        // 将server的地址数据关联到新创建的子节点上
        String createdPath = zk.create("/" + groupNode + "/" + subNode, address.getBytes("utf-8"),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("create: " + createdPath);
    }

    /**
     * server的工作逻辑写在这个方法中
     * 此处不做任何处理, 只让server sleep
     */
    public void handle() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {
        // 在参数中指定server的地址

        AppServer as = new AppServer();
        as.connectZookeeper("luoding");

        as.handle();
    }
}