
package MVC;

import Controlador.Ctr_formulario;
import Modulo.SQLconsulta;
import Modulo.Datos_Usuario;
import Vista_fight.Formulario;
import Vista_fight.fight_or_die;

public class mvc {


    public static void main(String args[]) {
        Datos_Usuario mod = new Datos_Usuario();
        
        fight_or_die frm_Principal = new fight_or_die();
        Formulario frm = new Formulario();
        SQLconsulta modc = new SQLconsulta();
        Ctr_formulario ctrl = new Ctr_formulario(mod, modc, frm_Principal,frm );
        ctrl.iniciar();
        frm.setVisible(true);
    }
}
