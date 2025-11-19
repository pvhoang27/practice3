/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import RMI.ObjectService;
import RMI.ProductX;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author hoang
 */
public class DA4hS42c {
    public static void main(String[] args ) throws Exception{
        String studentCode = "B21DCCN596", qCode = "DA4hS42c";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        ProductX pro = (ProductX) sv.requestObject(studentCode, qCode);
        System.out.println(pro);
        String disCode= pro.getDiscountCode();
        int sum = 0 ; 
        for(int i = 0 ; i < disCode.length();i++){
            char c = disCode.charAt(i);
            if(Character.isDigit(c)) sum += (c - '0');
        }
        System.out.println(sum);
        pro.setDiscount(sum);
        sv.submitObject(studentCode, qCode, pro);
     }
}
