/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package loginclientapplication;

/**
 *
 * @author laure
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try { // Call Web Service Operation
            fr.insa.login.LogInWSService service = new fr.insa.login.LogInWSService();
            fr.insa.login.LogInWS port = service.getLogInWSPort();
            // TODO initialize WS operation arguments here
            java.lang.String connexionParameter = "";
            // TODO process result here
            java.lang.String result = port.getUserInfo(connexionParameter);
           
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
        // TODO code application logic here
}
