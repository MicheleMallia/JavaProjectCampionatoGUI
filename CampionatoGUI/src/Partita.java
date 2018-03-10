import java.util.Random;

public class Partita {
	public String casa;
	public String ospite;
	private int goalCasa;
	private int goalOspite;
	private Random rand = new Random();
	
	public Partita(String casa, String ospite){		
		this.casa = casa;
		this.ospite = ospite;
	}
	
	public Partita(String casa, String ospite, int gC, int gO){		
		this.casa = casa;
		this.ospite = ospite;
		this.goalCasa = gC+ rand.nextInt((3) + 1);
		this.goalOspite = gO+ rand.nextInt((3) + 1);
	}

	
	public String toString(){
		return casa+" "+ospite;
	}
	
	public String getCasa(){
		return casa;
	}
	
	public String getOspite(){
		return ospite;
	}
	
	public void gioca(){
		this.goalCasa = this.rand.nextInt((3) + 1);
		this.goalOspite = this.rand.nextInt((3) + 1);
		System.out.println(goalCasa+" "+goalOspite);
	}
	
	public int getGoalCasa(){
		return goalCasa;
	}
	public int getGoalOspite(){
		return goalOspite;
	}
}
