package com.example;

public class PlatilloComida {

	private long codigoPlatillo;
	private String nombrePlatillo;
	private double costoPlatillo;
	private String categoria;
	private boolean estadoPlatillo;
	
	
	public PlatilloComida(long codigoPlatillo, String nombrePlatillo, double costoPlatillo, String categoria,
			boolean estadoPlatillo) {
		super();
		this.codigoPlatillo = codigoPlatillo;
		this.nombrePlatillo = nombrePlatillo;
		this.costoPlatillo = costoPlatillo;
		this.categoria = categoria;
		this.estadoPlatillo = estadoPlatillo;
	}
	//
	
	
	
	public long getCodigoPlatillo() {
		return codigoPlatillo;
	}
	
	public void setCodigoPlatillo(long codigoPlatillo) {
		this.codigoPlatillo = codigoPlatillo;
	}
	public String getNombrePlatillo() {
		return nombrePlatillo;
	}
	public void setNombrePlatillo(String nombrePlatillo) {
		this.nombrePlatillo = nombrePlatillo;
	}
	public double getCostoPlatillo() {
		return costoPlatillo;
	}
	public void setCostoPlatillo(double costoPlatillo) {
		this.costoPlatillo = costoPlatillo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean isEstadoPlatillo() {
		return estadoPlatillo;
	}
	public void setEstadoPlatillo(boolean estadoPlatillo) {
		this.estadoPlatillo = estadoPlatillo;
	}
	
	
	
}
