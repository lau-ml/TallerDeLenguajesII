package todo;

public enum TiempoMedida{
 S("s",1),
 M("m",1/60),
 H("h",(1/60)/60);
	private String abrev;
	 private double multiplicador;
	 TiempoMedida(String abrev, double multiplicador) {
	 this.abrev = abrev;
	 this.multiplicador = multiplicador;
	 }
	 public String abrev() { return abrev; }
	 public double multiplicador() { return multiplicador; }
	}

