/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import RMI.ByteService;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author hoang
 */
public class D0DficfF {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN596", qCode = "D0DficfF";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData(studentCode, qCode);
        
        byte[] kq = new byte[a.length];
        for(int i = 0 ; i < a.length; i++){
            kq[i] += (byte) (a[i]  + a.length);
        }
        sv.submitData(studentCode, qCode, kq);
    }
}
