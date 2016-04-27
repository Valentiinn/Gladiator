package com.Karayvansky.Game;

public class Batman extends Gladiator {
	public Batman() {
		super (20,2);
	}

	@Override
	public Boolean special(Gladiator enemy) {
		System.out.println(name + " нанес двойной урон!");
		damage = 4;
		Boolean f;
		f = attack(enemy, enemy);
		damage = 2;
		return f;
	}
	
    public String getType(){
    	return "Бэтмен";
    }
    
}
