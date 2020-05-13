/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majdtalji.universitaet.hilfe;

import javax.swing.UIManager;

/**
 *
 * @author Majd
 */
public class ChangeStyle {

    /*
    'Smart'         'com.jtattoo.plaf.smart.SmartLookAndFeel'
    'Aluminium'     'com.jtattoo.plaf.aluminium.AluminiumLookAndFeel'
    'Acryl'         'com.jtattoo.plaf.acryl.AcrylLookAndFeel'
    'Aero'          'com.jtattoo.plaf.aero.AeroLookAndFeel'
    'Bernstein'     'com.jtattoo.plaf.bernstein.BernsteinLookAndFeel'
    'Graphite'      'com.jtattoo.plaf.graphite.GraphiteLookAndFeel'
    'Fast'          'com.jtattoo.plaf.fast.FastLookAndFeel'
    'HiFi'          'com.jtattoo.plaf.hifi.HiFiLookAndFeel'
    'Luna'          'com.jtattoo.plaf.luna.LunaLookAndFeel'
    'McWin'         'com.jtattoo.plaf.mcwin.McWinLookAndFeel'
    'Mint'          'com.jtattoo.plaf.mint.MintLookAndFeel'
    'Noire'         'com.jtattoo.plaf.noire.NoireLookAndFeel'
     */
    String style[] = {"com.jtattoo.plaf.noire.NoireLookAndFeel","com.jtattoo.plaf.mint.MintLookAndFeel","com.jtattoo.plaf.mcwin.McWinLookAndFeel","com.jtattoo.plaf.luna.LunaLookAndFeel","com.jtattoo.plaf.hifi.HiFiLookAndFeel","com.jtattoo.plaf.fast.FastLookAndFeel","com.jtattoo.plaf.graphite.GraphiteLookAndFeel","com.jtattoo.plaf.bernstein.BernsteinLookAndFeel","com.jtattoo.plaf.aero.AeroLookAndFeel","com.jtattoo.plaf.acryl.AcrylLookAndFeel","com.jtattoo.plaf.aluminium.AluminiumLookAndFeel","com.jtattoo.plaf.smart.SmartLookAndFeel"};

    public void lookAndFeel(int index) {                

        try {
            UIManager.setLookAndFeel(style[index]);
        } catch (Exception e) {
        }

    }

    public void lookAndFeel() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

    }

}
