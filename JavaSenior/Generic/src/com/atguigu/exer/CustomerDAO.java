package com.atguigu.exer;

/**
 * @author Hewang
 * @create 2020-05-11 11:23
 * @title
 */
public class CustomerDAO extends DAO<Customer>{
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());
    }
}
