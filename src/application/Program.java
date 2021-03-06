/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/**
 *
 * @author wagner
 */
public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Department obj = new Department(1, "Books");
        
        Seller seller = new Seller(21, "Wagner", "wagner@email.com", new Date(),3000.2, obj);
        
        SellerDao sellerDao = DaoFactory.creaSellerDao();
        
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller1 = sellerDao.findById(3);
        System.out.println(seller1);
        
        System.out.println("=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller seller2 : list) {
            System.out.println(seller2);
        }
        
        System.out.println("=== TEST 3: seller findAllt ===");
        list = sellerDao.findAll();
        for (Seller seller2 : list) {
            System.out.println(seller2);
        }

        System.out.println("=== TEST 4: seller update ===");
        Seller seller3 = new Seller(null, "Wagner", "wagner@email.com", new Date(), 4000.0, department);
        sellerDao.insert(seller3);
        System.out.println("Insert! New id= " + seller3.getId());

        System.out.println("=== TEST 5: seller insert ===");
        seller3 = sellerDao.findById(7);
        seller3.setName("João");
        sellerDao.update(seller3);
        System.out.println("Update completed");
        System.out.println(sellerDao.findById(7));
        
        System.out.println("=== TEST 6: seller insert ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.delete(id);
        System.out.println("Delete completed!");
    
    }
}
