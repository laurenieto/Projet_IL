/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import java.util.Date;

public class ParserStudent {
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static Table_Student[] parse (String start) {

        System.out.print(start);
        String[] items = start.split("=");
        Table_Student[] results=null;
        System.out.print(Integer.parseInt(items[0]));
            if(Integer.parseInt(items[0])!=0){
            System.out.print("je suis la");
            results = new Table_Student[Integer.parseInt(items[0])];
            System.out.println("coucou");
            Table_Student u = new Table_Student();
            System.out.println("prout");
            for (int i = 0; i < Integer.parseInt(items[0]) ; i++) {
                try {
                    System.out.println("KAK["+i+"]");
                    u.setId(Integer.parseInt(items[9*i+1]));
                    u.setUsername(items[9*i+2]);
                    u.setPassword(items[9*i+3]);
                    u.setFirstname(items[9*i+4]);
                    u.setSurname(items[9*i+5]);
                    u.setEmail(items[9*i+6]);
                    u.setTelephone(items[9*i+7]);
                    u.setYearAtInsa(Integer.parseInt(items[9*i+8]));
                    u.setINSAspeciality(items[9*i+9]);
                    results[i] = u.Clone();//new Table_Univ(Integer.parseInt(items[8*i+1]),items[8*i+2],items[8*i+3],items[8*i+4],items[8*i+5],items[8*i+6],items[8*i+7],items[8*i+8], Integer.parseInt(items[8*i+9]));
                    System.out.println(results[i]);
                } catch (NumberFormatException nfe) {
                    //NOTE: write something here if you need to recover from formatting errors
                };
            }
        }
        return results;//results ;
    }

}