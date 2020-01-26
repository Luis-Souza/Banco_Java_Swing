package br.com.ifpi.utils;

public enum EnumUF {

	Selecione("0"), PI("01"), MA("02"), TO("03"), SP("04"), RJ("05"), MT("06"), MS("07"), CE("08"),
	SC("09"), DF("10"), MG("11"), PA("12"), BA("13"), PE("14"), GO("15"), PR("16");
	
	private String siglas;

	EnumUF(String siglas){
		this.siglas = siglas;
	}

	String getSiglas(){
		return this.siglas;	
	}
}
