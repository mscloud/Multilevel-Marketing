/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.service;

import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Combos;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Company;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Customer;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Members;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Points;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Products;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.security.Group;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.security.User;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Jay
 */
@Singleton
@Startup
public class DatabasePopulator {

    @EJB
    private ProductsService productService;

    @EJB
    private UserService userService;

    @EJB
    private GroupService groupService;

    @EJB
    private MembersService memberService;

    @EJB
    private CustomerService customerService;

    @EJB
    private CompanyService companyService;

    @EJB
    private CombosService combosService;

    @EJB
    private PointsService pointsService;

    public DatabasePopulator() {
    }

    @PostConstruct
    private void seedDatabase() {

        
        User admin = new User("admin", "admin");
        Group adminGroup = new Group("ADMIN", "Administrator Only");
        admin.addGroup(adminGroup);
        
        Group member = new Group("MEMBER", "Members Group");
        Group customer = new Group("CUSTOMER", "Customers Group");

        User jack = new User("jack", "xyz123");
        User david = new User("david", "xyz123");
        User michale = new User("michale", "xyz123");
        User anny = new User("anny", "xyz123");
        
        jack.addGroup(customer);
        david.addGroup(customer);
        michale.addGroup(member);
        anny.addGroup(member);

        
        Points pt1 = new Points("dg@gmail.com",
                "$1600");
        Points pt2 = new Points("mc@gmail.com",
                "$5099");
        
        Company cm1 = new Company("Pepsico",
                "Pepsi",
                "Soda");
        Company cm2 = new Company("Pepsico",
                "CocaCola",
                "Soda");
        Company cm3 = new Company("Sams",
                "Sneakers",
                "Candy");
        Company cm4 = new Company("Sams",
                "M&M",
                "Candy");
         
          Products p1 = new Products("Pepsi",
                 "$3.19",
                 "Soda",
                 "25oz",
                "22"
                );
          Products p2 = new Products("CocoCola",
                 "$3.19",
                 "Soda",
                 "25oz",
                "15"
                );
          Products p3 = new Products("Sneakers",
                 "$2.22",
                 "Candy",
                 "10oz",
                "50"
                );
          Products p4 = new Products("M&M",
                 "$1.89",
                 "Candy",
                 "10oz",
                "41"
                );
          p1.setCompany(cm1);
          cm1.getProducts().add(p1);
          p2.setCompany(cm1);
          cm1.getProducts().add(p2);
          p3.setCompany(cm2);
          cm2.getProducts().add(p3);
          p4.setCompany(cm2);
          cm2.getProducts().add(p4);
        
        
        Combos c1 = new Combos("Soda",
                "$5.99",
                "Pepsi+CocaCola",
                "5",
                "$2.15");
        c1.getProducts().add(p1);
        p1.getCombos().add(c1);
        c1.getProducts().add(p2);
        p2.getCombos().add(c1);
        
        Combos c2 = new Combos("Candy",
                "$2.99",
                "Sneakers+M&M",
                "10",
                "$0.50");
        c2.getProducts().add(p3);
        p3.getCombos().add(c2);
        c2.getProducts().add(p4);
        p4.getCombos().add(c2);

        Combos c3 = new Combos("Diet",
                "$5.99",
                "Sneakers+Pepsi",
                "10",
                "$1.50");
        c3.getProducts().add(p3);
        p3.getCombos().add(c3);
        c3.getProducts().add(p1);
        p1.getCombos().add(c3);

        
         Customer ct1 = new Customer("abc123",
                 "Jack",
                 "Danial",
                "jd@gmail.com",
                new GregorianCalendar(1982, 10, 12).getTime()
                );
         ct1.setUser(jack);
         Customer ct2 = new Customer("abc123",
                 "Anny",
                 "Watson",
                "aw@gmail.com",
                new GregorianCalendar(1985, 07, 05).getTime()
                );
         ct2.setUser(anny);
         
         Members m1 = new Members("abc123",
                 "David",
                 "Gutta",
                "dg@gmail.com",
                new GregorianCalendar(1972, 2, 3).getTime()
                );
         m1.setUser(david);
         m1.setPnt(pt1);
         pt1.getMembers().add(m1);
         m1.getCustomer().add(ct1);
         ct1.getMembers().add(m1);
         m1.getCustomer().add(ct2);
         ct2.getMembers().add(m1);
         Members m2 = new Members("pqr123",
                 "Michale",
                 "Clark",
                "mc@gmail.com",
                new GregorianCalendar(1978, 5, 2).getTime()
                );
         m2.setUser(michale);
         m2.setPnt(pt2);
         pt2.getMembers().add(m2);
          
          groupService.create(member);
          groupService.create(customer);
          groupService.create(adminGroup);
          
          userService.create(jack);
          userService.create(david);
          userService.create(michale);
          userService.create(anny);
          userService.create(admin);
          
          pointsService.create(pt1);
          pointsService.create(pt2);
          
          combosService.create(c1);
          combosService.create(c2);
          
          companyService.create(cm1);
          companyService.create(cm2);
          companyService.create(cm3);
          companyService.create(cm4);

          customerService.create(ct1);
          customerService.create(ct2);
          
          memberService.create(m1);
          memberService.create(m2);
          
          productService.create(p1);
          productService.create(p2);
          productService.create(p3);
          productService.create(p4);
    }
}