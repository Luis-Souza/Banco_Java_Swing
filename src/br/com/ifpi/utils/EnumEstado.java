package br.com.ifpi.utils;

public enum EnumEstado {

	Selecione("0"), PIAUÍ("01"), MARANHÃO("02"), TOCANTINS("03"), SAO_PAULO("04"), RIO_DE_JANEIRO("05"), MATO_GROSSO("06"), MATO_GROSSO_DO_SUL("07"), CEARA("08"),
	SANTA_CATARINA("09"), BRASILIA("10"), MINAS_GERAIS("11"), PARÁ("12"), BAHIA("13"), PERNAMBUCO("14"), GOIAS("15"), PARANA("16");

	private String siglas;

	EnumEstado(String siglas){
		this.siglas = siglas;
	}

	String getSiglas(){
		return this.siglas;	
	}
}
