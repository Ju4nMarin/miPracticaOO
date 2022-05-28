/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author Ruben
 */
public class Empleado {
    private String idEmpleado;
    private String nomEmpleado;
    private float sueldo;
    private String cargo;

    public Empleado(String idEmpleado, String nomEmpleado, float sueldo, String cargo) {
        this.idEmpleado = idEmpleado;
        this.nomEmpleado = nomEmpleado;
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public float getSueldo() {
        return sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
