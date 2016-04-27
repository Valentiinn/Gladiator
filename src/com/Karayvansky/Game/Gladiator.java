package com.Karayvansky.Game;

abstract class Gladiator {
	// главный класс, от которого будут наследоваться остальные классы
	// гладиаторов
	protected String name;
	protected int hitPoints; 
	protected int attacks = 0; // куда бьем
	protected int blocks = 0; // что блакируим
	protected int damage; // урон
	protected int ultimateDamage;
	protected int ultimatesLeft = 3;

	// конструктор
	public Gladiator(int hitPoints, int damage) {
		this.hitPoints = hitPoints;
		this.damage = damage;
		ultimateDamage = damage * 2-1;
	}

	public Gladiator() {

	}

	// стандартная атака
	public Boolean attack (Gladiator attacker, Gladiator enemy){
        // если атакуем не то, что заблокировано
        if (attacks != enemy.getBlocks() || attacks - 10 != enemy.getBlocks()){
            switch (attacks){
                case 1:
                    System.out.println(attacker.getType() + " нанес успешный удар в голову.");
                    enemy.takeHits(damage); 
                    break;
                case 2:
                    System.out.println(attacker.getType() + " нанес успешный удар по туловищу.");
                    enemy.takeHits(damage); 
                    break;
                case 3:
                    System.out.println(attacker.getType() + " нанес успешный удар в пах.");
                    enemy.takeHits(damage); 
                    break;
                case 4:
                    System.out.println(attacker.getType() + " нанес успешный удар по ногам.");
                    enemy.takeHits(damage); 
                    break;
                case 11:
                	if(ultimateDamage <= 0) {
                        System.out.println("У Вас закончились суперудары, поэтому был нанесён обычный удар.");
                        System.out.println(attacker.getType() + " нанес успешный удар в голову.");
                        enemy.takeHits(damage); 
                		break;
                	}
                	ultimateDamage--;
                    System.out.println(attacker.getType() + " нанес критический удар в голову. (суперударов осталось: " + ultimateDamage + ").");
                    enemy.takeHits(ultimateDamage);
                    break;
                case 12:
                	if(ultimateDamage <= 0) {
                        System.out.println("У Вас закончились суперудары, поэтому был нанесён обычный удар.");
                        System.out.println(attacker.getType() + " нанес успешный удар по туловищу.");
                        enemy.takeHits(damage); 
                		break;
                	}
                	ultimateDamage--;
                    System.out.println(attacker.getType() + " нанес критический удар по туловищу. (суперударов осталось: " + ultimateDamage + ").");
                    enemy.takeHits(ultimateDamage);
                    break;
                case 13:
                	if(ultimateDamage <= 0) {
                        System.out.println("У Вас закончились суперудары, поэтому был нанесён обычный удар.");
                        System.out.println(attacker.getType() + " нанес успешный удар в пах.");
                        enemy.takeHits(damage); 
                		break;
                	}
                	ultimateDamage--;
                    System.out.println(attacker.getType() + " нанес критический удар в пах (суперударов осталось: " + ultimateDamage + ").");
                    enemy.takeHits(ultimateDamage);
                    break;
                case 14:
                	if(ultimateDamage <= 0) {
                        System.out.println("У Вас закончились суперудары, поэтому был нанесён обычный удар.");
                        System.out.println(attacker.getType() + " нанес успешный удар по ногам.");
                        enemy.takeHits(damage); 
                		break;
                	}
                	ultimateDamage--;
                    System.out.println(attacker.getType() + " нанес критический удар по ногам (суперударов осталось: " + ultimateDamage + ").");
                    enemy.takeHits(ultimateDamage);
                    break;
            }
            System.out.println("Здоровье " + enemy.getType() + "а: " + enemy.getHitPoints());
        }
        else { switch (enemy.getBlocks()){
            case 1:
                System.out.println(enemy.getType() + " заблокировал удар в голову");
                break;
            case 2:
                System.out.println(enemy.getType() + " заблокировал удар по туловищу");
                break;
            case 3:
                System.out.println(enemy.getType() + " заблокировал удар в пах");
                break;
            case 4:
                System.out.println(enemy.getType() + " заблокировал удар по ногам");
                break;
        }}
 
 
 
        if (enemy.getHitPoints() <= 0) {
        	return false;
        }
        
        return true; // если убили врага, возвращаем true
    }

	// суперудар, его перегружаем для каждого гладиатора
	public Boolean special(Gladiator enemy) {
		if (enemy.getHitPoints() < 0)
			return false;
		else
			return true; // если убили врага, возвращаем true
	}

	// снимаем хит пониты
	public void takeHits(int hits) {
		this.hitPoints -= hits;
	}

	// getters/setters
	public void setTactics(int attacks, int blocks) {
		this.attacks = attacks;
		this.blocks = blocks;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getAttacks() {
		return attacks;
	}

	public int getBlocks() {
		return blocks;
	}

	public int getUltimates() {
		return ultimatesLeft;
	}

	public String getType() {
		return "ОШИБКА!";
	}
}
