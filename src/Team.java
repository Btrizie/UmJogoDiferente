public class Team {
    private String name, slogan, year;
	private int blots, plifs, advrunghs, total;

	//inicializa a classe
	public Team(String name, String slogan, String year) {
		this.name = name;
		this.slogan = slogan;
		this.year = year;
		blots = 0;
		plifs = 0;
		advrunghs = 0;
		total = 0;
	}

	public String getName() {
		return name;
	}

	public String getGrito(){
		return slogan;
	}

	public String getYear(){
		return year;
	}

	public void setPoints(int blots, int plifs, int advrunghs){
		this.blots += blots;
		this.plifs += plifs;
		this.advrunghs += advrunghs;
		this.total += 50 + (blots*5) + plifs - (advrunghs*10);
	}

	public void setTotal(int total){
		this.total += total;
	}

	public int getTotal(){
		return total;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Slogan: " + slogan + ", Year: " + year;
	}

	public String toStringPartida() {
		return "Name: " + name + "     || Blots: " + blots + "  | Plifs:" + plifs + "  | Advrunghs: " + advrunghs + "  | Total:" + total;
	}

	public String toStringEnding(){
		return "Name: " + name + "     || Total:" + total;
	}
}
