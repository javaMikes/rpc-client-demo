package com.example.rpc.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @desc
 * @auther huanghua
 * @create 2021-05-25 10:06
 */
@Getter
@Setter
public class RequestData implements Serializable {

    private static final long serialVersionUID = -3866469063627295476L;
    private String interfaceName;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] parameters;

}

