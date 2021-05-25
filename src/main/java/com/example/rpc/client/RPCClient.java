package com.example.rpc.client;

import com.example.rpc.model.RequestData;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @desc
 * @auther huanghua
 * @create 2021-05-25 10:08
 */
public class RPCClient {

    @SuppressWarnings("unchecked")
    public <T> T importor(Class<?> serviceClass, InetSocketAddress address) {
        // 使用jdk动态代理
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class[]{serviceClass}, (proxy, method, args) -> {
            Socket socket = new Socket();
            socket.connect(address);
            try (ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

                RequestData data = new RequestData();

                data.setInterfaceName(serviceClass.getName());
                data.setMethodName(method.getName());
                data.setParameters(args);
                data.setParameterTypes(method.getParameterTypes());
                output.writeObject(data);
                return input.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;

        });
    }

}

