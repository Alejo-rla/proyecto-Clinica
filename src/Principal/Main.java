
package Principal;
import Controlador.CLogin;
import Vista.FrmLogin;
import DAO.*;

public class Main {
    
    public static CLogin CLogin;
    public static FrmLogin fl;
    
    public static void main(String[] args) {
        fl = new FrmLogin();
        CLogin = new CLogin(fl);
    }
    
}
