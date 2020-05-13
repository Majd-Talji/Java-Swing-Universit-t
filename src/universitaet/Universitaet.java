/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitaet;

import com.majdtalji.universitaet.hilfe.ChangeStyle;

/**
 *
 * @author Majd
 */
public class Universitaet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new ChangeStyle().lookAndFeel(7);
        
        new Login().setVisible(true);
        
    }
    
}
