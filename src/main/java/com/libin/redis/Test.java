package com.libin.redis;

import redis.clients.jedis.Jedis;

/**
 * Copyright (c) 2018/11/25. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose :
 */
public class Test {
    public static void main(String[] args){
        Jedis jedis = new Jedis("阿里云服务器IP", 6379);
        // 远端服务器开启redis的server服务，联通会输出：PONG
        System.out.println(jedis.ping());
    }
}
