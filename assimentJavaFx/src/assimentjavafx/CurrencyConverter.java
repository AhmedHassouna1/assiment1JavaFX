/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assimentjavafx;


public class CurrencyConverter {
    private static final double USD_TO_ILS = 3.25;

    public static double convertToILS(double usd) {
        return usd * USD_TO_ILS;
    }

    public static double convertToUSD(double ils) {
        return ils / USD_TO_ILS;
    }
}