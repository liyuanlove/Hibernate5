package com.powernode.test;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.junit.Test;

import com.powernode.beans.Student;
import com.powernode.utils.HibernateUtils;

public class MyTest {

    //准备测试数据
    @Test
    public void test00() {
        //1.获取Session对象
        Session session = HibernateUtils.getSession();
        try {
            //2.开启事务
            session.beginTransaction();
            //3.执行操作
            for (int i = 1; i < 11; i++) {
                Student student = new Student("n_" + i, 15 + i, 85 + i);
                session.save(student);
            }
            //4.事务提交
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //5.事务回滚
            session.getTransaction().rollback();
        }
    }

    @Test
    public void test01() {
        //1.获取Session对象
        Session session = HibernateUtils.getSession();
        try {
            //2.开启事务
            session.beginTransaction();
            //3.执行操作
            //直接加载
            Student student = session.get(Student.class, 2, LockMode.PESSIMISTIC_WRITE);
            System.out.println(student);
            //4.事务提交
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //5.事务回滚
            session.getTransaction().rollback();
        }
    }

    @Test
    public void test02() {
        //1.获取Session对象
        Session session = HibernateUtils.getSession();
        try {
            //2.开启事务
            session.beginTransaction();
            //3.执行操作
            //直接加载
            Student student = session.get(Student.class, 2, LockMode.PESSIMISTIC_READ);
            System.out.println(student);
            //4.事务提交
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //5.事务回滚
            session.getTransaction().rollback();
        }
    }

}
