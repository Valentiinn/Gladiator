package com.Karayvansky.Game;

public class SpiderMan extends Gladiator {
	public SpiderMan() {
		super (20,2);
	}

	@Override
	public Boolean special(Gladiator enemy) {
		System.out.println(name + " ����� ������� ����!");
		damage = 4;
		Boolean f;
		f = attack(enemy, enemy);
		damage = 2;
		return f;
	}
	
    public String getType(){
    	return "����������";
    }
    
}
