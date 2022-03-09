package entities;

public class PessoaJuridica extends Contribuinte {
	
	protected Integer numFunc;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, double rendaAnual, Integer numFunc) {
		super(nome, rendaAnual);
		this.numFunc = numFunc;
	}

	public Integer getNumFunc() {
		return numFunc;
	}

	public void setNumFunc(Integer numFunc) {
		this.numFunc = numFunc;
	}
	
	@Override
	public double imposto() {
				if (numFunc > 10) {
					return getRendaAnual() * 0.14;
				}
				else {
					return getRendaAnual() * 0.16;
				}
	}

}
