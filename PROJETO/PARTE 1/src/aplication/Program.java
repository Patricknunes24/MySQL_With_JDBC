package aplication;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department db = new Department("patrick",5);
        Seller seller = new Seller(1,"patrick","patrick@gmail.com",new Date(),100,new Department("patrick",2));

        System.out.println(seller.toString());
        System.out.println(db.toString());
    }
}
