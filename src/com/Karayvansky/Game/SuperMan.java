package com.Karayvansky.Game;

public class SuperMan extends Gladiator {
    public SuperMan() {
    	super (20,2);
    }
 
    @Override
    public Boolean special(Gladiator enemy) {
        System.out.println( name + " закинул сеть на соперника");
        enemy.takeHits(damage);
        if (enemy.getHitPoints() < 0) return false;
        else return true; // если убили врага, возвращаем true
    }
    
    public String getType(){
    	return "Супермэн";
    }
    
}
