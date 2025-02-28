package com.mariana.parcialDos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	@NonNull
	private Integer prodcodi;
	@NonNull
	private String prodnomb;

	private double prodprec;

	/*@Override
	public String toString() {
		return "Producto{" + "Código='" + prodcodi + '\'' + "Nombre='" + prodnomb + '\'' + "Precio=" + prodprec + '}';
	}*/
	
	@Override
	public String toString() {
		return "Código=" + prodcodi + "\n"+
				 "Nombre=" + prodnomb +"\n"+
				 "Precio= $" + prodprec +"\n";
	}

}
