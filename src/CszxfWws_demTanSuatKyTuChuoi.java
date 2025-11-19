    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import RMI.CharacterService;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author hoang
 */
public class CszxfWws_demTanSuatKyTuChuoi {
    public static void main(String[] args)throws Exception{
        String studentCode = "B21DCCN550",qCode = "CszxfWws";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter(studentCode, qCode);
        System.out.println(s);
        int [] cnt = new int[256];
        String kq = "{";
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            cnt[c] ++;
        }
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(cnt[c] > 0 ){
                kq += ("\"" +c  +"\""+ ": " + cnt[c] + ", ") ;
                cnt[c] = 0;
            }
        }
        kq = kq.substring(0, kq.length()-2);
        kq += "}";
        
        System.out.println(kq);
        sv.submitCharacter(studentCode, qCode, kq);
    }
}
