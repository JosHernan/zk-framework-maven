package com.servicios.ServiceEmpleado.entity;
import java.io.Serializable;

public class Empleado implements Serializable{
	
	private String emp_no;
	private String fechaNacimiento;
	private String nombre;
	private String apellidoPaterno;
	private String sexo;
	private String fechaContratacion;
	
	
	public String getEmp_no() {
		return emp_no;
	}


	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getFechaContratacion() {
		return fechaContratacion;
	}


	public void setFechaContratacion(String fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}


	@Override
	public String toString() {
		return "Empleado [emp_no=" + emp_no + ", fechaNacimiento="
				+ fechaNacimiento + ", nombre=" + nombre + ", apellidoPaterno="
				+ apellidoPaterno + ", sexo=" + sexo + ", fechaContratacion="
				+ fechaContratacion + "]";
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
