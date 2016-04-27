package com.Karayvansky.Game;

abstract class Gladiator {
	// ������� �����, �� �������� ����� ������������� ��������� ������
	// �����������
	protected String name;
	protected int hitPoints; 
	protected int attacks = 0; // ���� ����
	protected int blocks = 0; // ��� ���������
	protected int damage; // ����
	protected int ultimateDamage;
	protected int ultimatesLeft = 3;

	// �����������
	public Gladiator(int hitPoints, int damage) {
		this.hitPoints = hitPoints;
		this.damage = damage;
		ultimateDamage = damage * 2-1;
	}

	public Gladiator() {

	}

	// ����������� �����
	public Boolean attack (Gladiator attacker, Gladiator enemy){
        // ���� ������� �� ��, ��� �������������
        if (attacks != enemy.getBlocks() || attacks - 10 != enemy.getBlocks()){
            switch (attacks){
                case 1:
                    System.out.println(attacker.getType() + " ����� �������� ���� � ������.");
                    enemy.takeHits(damage); 
                    break;
                case 2:
                    System.out.println(attacker.getType() + " ����� �������� ���� �� ��������.");
                    enemy.takeHits(damage); 
                    break;
                case 3:
                    System.out.println(attacker.getType() + " ����� �������� ���� � ���.");
                    enemy.takeHits(damage); 
                    break;
                case 4:
                    System.out.println(attacker.getType() + " ����� �������� ���� �� �����.");
                    enemy.takeHits(damage); 
                    break;
                case 11:
                	if(ultimateDamage <= 0) {
                        System.out.println("� ��� ����������� ����������, ������� ��� ������ ������� ����.");
                        System.out.println(attacker.getType() + " ����� �������� ���� � ������.");
                        enemy.takeHits(damage); 
                		break;
                	}
                	ultimateDamage--;
                    System.out.println(attacker.getType() + " ����� ����������� ���� � ������. (����������� ��������: " + ultimateDamage + ").");
                    enemy.takeHits(ultimateDamage);
                    break;
                case 12:
                	if(ultimateDamage <= 0) {
                        System.out.println("� ��� ����������� ����������, ������� ��� ������ ������� ����.");
                        System.out.println(attacker.getType() + " ����� �������� ���� �� ��������.");
                        enemy.takeHits(damage); 
                		break;
                	}
                	ultimateDamage--;
                    System.out.println(attacker.getType() + " ����� ����������� ���� �� ��������. (����������� ��������: " + ultimateDamage + ").");
                    enemy.takeHits(ultimateDamage);
                    break;
                case 13:
                	if(ultimateDamage <= 0) {
                        System.out.println("� ��� ����������� ����������, ������� ��� ������ ������� ����.");
                        System.out.println(attacker.getType() + " ����� �������� ���� � ���.");
                        enemy.takeHits(damage); 
                		break;
                	}
                	ultimateDamage--;
                    System.out.println(attacker.getType() + " ����� ����������� ���� � ��� (����������� ��������: " + ultimateDamage + ").");
                    enemy.takeHits(ultimateDamage);
                    break;
                case 14:
                	if(ultimateDamage <= 0) {
                        System.out.println("� ��� ����������� ����������, ������� ��� ������ ������� ����.");
                        System.out.println(attacker.getType() + " ����� �������� ���� �� �����.");
                        enemy.takeHits(damage); 
                		break;
                	}
                	ultimateDamage--;
                    System.out.println(attacker.getType() + " ����� ����������� ���� �� ����� (����������� ��������: " + ultimateDamage + ").");
                    enemy.takeHits(ultimateDamage);
                    break;
            }
            System.out.println("�������� " + enemy.getType() + "�: " + enemy.getHitPoints());
        }
        else { switch (enemy.getBlocks()){
            case 1:
                System.out.println(enemy.getType() + " ������������ ���� � ������");
                break;
            case 2:
                System.out.println(enemy.getType() + " ������������ ���� �� ��������");
                break;
            case 3:
                System.out.println(enemy.getType() + " ������������ ���� � ���");
                break;
            case 4:
                System.out.println(enemy.getType() + " ������������ ���� �� �����");
                break;
        }}
 
 
 
        if (enemy.getHitPoints() <= 0) {
        	return false;
        }
        
        return true; // ���� ����� �����, ���������� true
    }

	// ���������, ��� ����������� ��� ������� ����������
	public Boolean special(Gladiator enemy) {
		if (enemy.getHitPoints() < 0)
			return false;
		else
			return true; // ���� ����� �����, ���������� true
	}

	// ������� ��� ������
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
		return "������!";
	}
}
