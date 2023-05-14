
package Controlador;

import Modulo.SQLconsulta;
import Modulo.Datos_Usuario;
import Vista_fight.Formulario;
import Vista_fight.fight_or_die;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Ctr_formulario implements ActionListener{
    private Datos_Usuario mod;
    private SQLconsulta modC;
    private Formulario frm;
    private fight_or_die frm_Principal;

    public Ctr_formulario(Datos_Usuario mod, SQLconsulta modC, fight_or_die frm_Principal,Formulario frm ) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm_Principal = frm_Principal;
        this.frm.btnSend_Form.addActionListener(this);
    }


    
    public void iniciar(){
        frm.setTitle("Juego");
        frm.setLocationRelativeTo(null);
        /*Es la manera de inactivar la barra de busqueda de un codigo(profesor)
        frm.txtId.setVisible(false);*/        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnSend_Form){
            mod.setNombre(frm.nombre);
            mod.setApellido(frm.apellido);
            /*cambio string a entero edad*/
            String cambio = frm.T_edad.getText();
            int edad = Integer.parseInt(cambio);
            mod.setEdad(edad);
            mod.setNick(frm.nickname);
            mod.setCorreo(frm.correo);
            mod.setContrasena(frm.password);
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Datos ingresados");
                limpiar();
            }
            else{
                JOptionPane.showMessageDialog(null, "Los datos no pudieron ser ingresados");
                limpiar();
            }
        }
    }
    
   public void limpiar(){
        frm.T_nombre.setText("");
        frm.T_apellido.setText("");
        frm.T_edad.setText("");
        frm.T_nickname.setText("");
        frm.T_correo.setText("");
        frm.T_password.setText("");
   }
}
