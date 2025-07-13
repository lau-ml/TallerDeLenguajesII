package todo;

public enum MagnitudIng {
	PULGADA("pulgada",0.12),
	PIE("pie",1),
	YARDA("yarda",3),
	MILLA("milla",5280);
	private String abrev;
	private double multiplicador;
	MagnitudIng(String abrev, double multiplicador) {
	this.abrev = abrev;
	this.multiplicador = multiplicador;
	}
	public String abrev() { return abrev; }
	public double multiplicador() { return multiplicador; }
}
