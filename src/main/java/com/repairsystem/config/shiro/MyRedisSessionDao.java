package com.repairsystem.config.shiro;

import com.repairsystem.utils.ConstantUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class MyRedisSessionDao extends EnterpriseCacheSessionDAO {

    private RedisTemplate<byte[],byte[]> redisTemplate;
    public MyRedisSessionDao(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;

    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        redisTemplate.opsForValue().set(sessionId.toString().getBytes(),sessionToByte(session));
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = super.doReadSession(sessionId);
        if(session == null){
            byte[] bytes =  redisTemplate.opsForValue().get(sessionId.toString().getBytes());
            if(bytes != null && bytes.length > 0){
                session = byteToSession(bytes);
            }
        }
        return session;
    }

    //设置session的最后一次访问时间
    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        redisTemplate.opsForValue().set(session.getId().toString().getBytes(),sessionToByte(session));
    }

    // 删除session
    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
        redisTemplate.delete(session.getId().toString().getBytes());
    }

    private byte[] sessionToByte(Session session){
        if (null == session){
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        byte[] bytes = null;
        ObjectOutputStream oo ;
        try {
            oo = new ObjectOutputStream(bo);
            oo.writeObject(session);
            bytes = bo.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bytes;

    }
    private Session byteToSession(byte[] bytes){
        if(0==bytes.length){
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        ObjectInputStream in;
        SimpleSession session = null;
        try {
            in = new ObjectInputStream(bi);
            session = (SimpleSession) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return session;
    }

}
