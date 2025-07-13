package todo;

public enum LongitudMedida{
		MM("m",.001),
		 CM("c",.01),
		 DM("d",.1),
		 DAM("D",10.0),
		 HM("h",100.0),
		 KM("k",1000.0);
	private String abrev;
	 private double multiplicador;
	 LongitudMedida(String abrev, double multiplicador) {
	 this.abrev = abrev;
	 this.multiplicador = multiplicador;
	 }
	 public String abrev() { return abrev; }
	 public double multiplicador() { return multiplicador; }
	}

	

