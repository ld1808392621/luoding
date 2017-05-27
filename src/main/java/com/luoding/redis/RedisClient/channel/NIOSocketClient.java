package com.luoding.redis.RedisClient.channel;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Date：16-7-6
 * Time：下午9:59
 *
 * @author ding.luo@corp.luoding .com
 */
public class NIOSocketClient {
    private static final int CLIENT_PORT = 10200;

    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        Selector sel = Selector.open();
        try {
            sc.configureBlocking(false);
            //sc.socket().bind(new InetSocketAddress(CLIENT_PORT));
            sc.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE
                    | SelectionKey.OP_CONNECT);
            int i = 0;
            boolean written = false;
            boolean done = false;

            ByteBuffer buf = ByteBuffer.allocate(16);
            while (!done) {
                Iterator it = sel.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = (SelectionKey) it.next();
                    it.remove();
                    //获取创建通道选择器事件键的套接字通道
                    //当前通道选择器产生连接已经准备就绪事件，并且客户端套接字
//通道尚未连接到服务端套接字通道
                    if (!sc.isConnected()) {
                        InetAddress addr = InetAddress.getByName(null);
                        //客户端套接字通道向服务端套接字通道发起非阻塞连接
                        boolean success = sc.connect(new InetSocketAddress(
                                "127.0.0.1", NIOSocketServer.PORT));
                        //如果客户端没有立即连接到服务端，则客户端完成非立即连接操作
                        if (!success) sc.finishConnect();
                    }
//如果通道选择器产生读取操作已准备好事件，且已经向通道写入数据
                    if (key.isReadable() && written) {
                        if (sc.read((ByteBuffer) buf.clear()) > 0) {
                            written = false;
                            //从套接字通道中读取数据
                            buf.flip();
                            String response = new String(buf.array(), 0, buf.limit());
                            System.out.println(response);
                            if (response.indexOf("END") != -1) done = true;
                        }
                    }
//如果通道选择器产生写入操作已准备好事件，并且尚未想通道写入数据
                    if (key.isWritable() && !written) {
                        //向套接字通道中写入数据
                        if (i < 10) sc.write(ByteBuffer.wrap(new String("howdy " + i +
                                '\n').getBytes()));
                        else if (i == 10) sc.write(ByteBuffer.wrap(new String("END").
                                getBytes()));
                        written = true;
                        i++;
                    }
                }
            }
        } finally {
            sc.close();
            sel.close();
        }
    }
}