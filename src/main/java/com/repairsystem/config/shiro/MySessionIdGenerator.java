package com.repairsystem.config.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;
import java.util.UUID;

public class MySessionIdGenerator implements SessionIdGenerator{
  private String name;
  public MySessionIdGenerator(String name){
    this.name = name;

  }

  @Override
  public Serializable generateId(Session session) {
    System.out.println("generator生成的sessionhost："+session.getHost());
    return name+ UUID.randomUUID().toString()+session.getHost();
  }
}
