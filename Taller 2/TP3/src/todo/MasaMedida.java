package todo;

public enum MasaMedida {
	MG("mg",.001),
	 CG("cg",.01),
	 DG("dg",.1),
	 DAG("Dg",10.0),
	 HG("hg",100.0),
	 KG("kg",1000.0);
private String abrev;
private double multiplicador;
MasaMedida(String abrev, double multiplicador) {
this.abrev = abrev;
this.multiplicador = multiplicador;
}
public String abrev() { return abrev; }
public double multiplicador() { return multiplicador; }
}

