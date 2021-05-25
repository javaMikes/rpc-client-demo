package com.example.rpc;

import com.example.rpc.client.RPCClient;
import com.example.rpc.service.ISayHello;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class RpcClientDemoApplication {

    public static void main(String[] args) {
        RPCClient client = new RPCClient();
        ISayHello say = client.importor(ISayHello.class, new InetSocketAddress("localhost", 12345));

        System.out.println(say.sayHello("Tom"));
    }

}
