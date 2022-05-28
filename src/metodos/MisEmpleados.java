/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class MisEmpleados {
    public ArrayList losEmpleados;
    
    public MisEmpleados(){
        losEmpleados=new ArrayList();
    }
    
    public int getBuscarId(String id){
        int i;
        Empleado temp=null;
        for(i=0; i<losEmpleados.size(); i++){
            temp = (Empleado) losEmpleados.get(i);
            if(temp.getIdEmpleado().equals(id))
                return i;
        }
        return -1;
    }
    
    public void setAddEmpleado(
        JTextField jtfidEmp,
        JTextField jtfnomEmp,
        JTextField jtfsalario,
        JComboBox jcbcargo
    ){
        int posB = getBuscarId(jtfidEmp.getText());
        if(posB != -1){
            JOptionPane.showMessageDialog(null,
                "El idEmpleado ya esta registrado. "
                + "Intente nuevamente!");
            jtfidEmp.setText("");
            jtfidEmp.requestFocus();
        }else{
            Empleado info = new Empleado(
                jtfidEmp.getText(),
                jtfnomEmp.getText(),
                Float.parseFloat(jtfsalario.getText()),
                jcbcargo.getSelectedItem().toString()
            );
            losEmpleados.add(info);
            JOptionPane.showMessageDialog(null,
                "Nuevo empleado registrado!");
            jtfidEmp.setText("");
            jtfnomEmp.setText("");
            jtfsalario.setText("");
            jcbcargo.setSelectedIndex(0);
            jtfidEmp.requestFocus();
        }
    }
    
    public void setDelEmpleado(
        String idEmp        
    ){
        int posB = getBuscarId(idEmp);
        if(posB == -1){
            JOptionPane.showMessageDialog(null,
                "El idEmpleado a eliminar no esta registrado!");
        }else{
            losEmpleados.remove(posB);
            JOptionPane.showMessageDialog(null,
                "Empleado eliminado de la posición: "+posB);
        }
    }
    
    public void setModificarEmpleado(
        String idE,
        String nuevoNomE,
        float salario,
        String cargo
    ){
        int posB = getBuscarId(idE);
        if(posB==-1){
            JOptionPane.showMessageDialog(null,
                "El Dato no se encuetra");
        }else{
            Empleado temp = new Empleado(
              idE, nuevoNomE, salario, cargo
            );
            losEmpleados.set(posB, temp);
            JOptionPane.showMessageDialog(null, 
                "Datos de empleado modificado!");
        }
    }
    
    //Este método registra un dato al JTable
    //teniendo en cuenta el tipo de Persona
    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
        int Fila, int indiceArray){
        
        Empleado temp = (Empleado) losEmpleados.get(indiceArray);
        miModelo.setValueAt(temp.getIdEmpleado(), Fila, 0);
        miModelo.setValueAt(temp.getNomEmpleado(), Fila, 1);
        miModelo.setValueAt(temp.getSueldo(), Fila, 2);
        miModelo.setValueAt(temp.getCargo(), Fila, 3);
    }    
    
    
    //Este método actualiza el contenido de la fila
    //de un JTable a partir de su modelo de datos 
    //(JTableModel)
    public void setLlenarJTable(JTable tab){
        int indice=0; //Este índice recorre los elementos del ArrayList
        int i=0;  //Este índice para ubicar posición de fila en el JTable
        DefaultTableModel miModelo=new DefaultTableModel();
        miModelo.addColumn("IdEmpleado");
        miModelo.addColumn("Nombre Empleado");
        miModelo.addColumn("Sueldo Empleado");
        miModelo.addColumn("Cargo Empleado");
        while(indice<losEmpleados.size()){                        
            miModelo.addRow(new Object[]{"", "", "", ""});              
            setRegistrarFilaJTable(miModelo,i,indice);            
            i++;
            indice++;
        }
        tab.setModel(miModelo);
    }   
}
