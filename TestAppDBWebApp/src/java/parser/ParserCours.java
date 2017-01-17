/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;


/**
 *
 * @author Gaetan
 */
public class ParserCours {
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static Table_Course[] parse (String start) {

        System.out.print(start);
        String[] items = start.split("=");
        Table_Course[] results=null;
        System.out.print(Integer.parseInt(items[0]));
            if(Integer.parseInt(items[0])!=0){
       
            results = new Table_Course[Integer.parseInt(items[0])];
          
            Table_Course u = new Table_Course();
           
            for (int i = 0; i < Integer.parseInt(items[0]) ; i++) {
                try {
                  
                    u.setId(Integer.parseInt(items[3*i+1]));
                    u.setCourseName(items[3*i+2]);
                    u.setNbHours(Integer.parseInt(items[3*i+3]));
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