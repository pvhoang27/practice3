/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import RMI.ObjectService;
import RMI.Product;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author hoang
 */
public class qaFQfIxY {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN550", qCode = "qaFQfIxY";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Product product = (Product) sv.requestObject(studentCode, qCode);
        System.out.println(product);
        
        // lam tron 2 chu so thap phan cho dung vs log 
        double xuat = (double) Math.round(product.getImportPrice() * 1.2 * 100) /100 ;
        product.setExportPrice(xuat);
        // ma sp la code chu k phai la id 
        String h  = product.getCode().toUpperCase();
        product.setCode(h);
        System.out.println(product);
        
        sv.submitObject(studentCode, qCode, product);
        
    }
}
