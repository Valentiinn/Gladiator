package com.Karayvansky.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static int round = 1;

	public static void main(String[] args) {
		Fight();
	}

	public static void Fight() {
		Boolean isWin = false;
		Random random = new Random();
		Gladiator enemy = new Gladiator() {
		};
		Gladiator anotherBattleWinner = new Gladiator() {
		};
		Gladiator anotherBattleLooser = new Gladiator() {
		};
		Gladiator player = new Gladiator() {
		};
		String input1 = "";
		String input2 = "";
		Boolean security = true; // ������ �� ������������� �����
		if (round == 1) {
			System.out.println("***����� ���������� �� ������������� ���!!!***"
					+ "\n��� ������ ��� ����� ������� ��������� ����� ������ ������.");
			System.out.println("�������� ����������: 1 - ��������, 2 - ������, 3 - ������� ����, 4 - ���������� ");
		}

		while (security) {
			if (round == 1) {
				Scanner sc = new Scanner(System.in);
				input1 = sc.next();

				if (!player.getType().equals("������!")) {
					input1 = "10";
				}

				switch (input1) {
				case "1":
					player = new SuperMan();
					enemy = randomType(player);
					security = false;
					break;
				case "2":
					player = new Batman();
					enemy = randomType(player);
					security = false;
					break;
				case "3":
					player = new SpiderMan();
					enemy = randomType(player);
					security = false;
					break;
				case "4":
					player = new Terminator();
					enemy = randomType(player);
					security = false;
					break;
				default:
					System.out.println("������ �����");
					System.out.println(
							"�������� ����������: 1 - ������, 2 - ��������, 3 - ������� ����, 4 - ���������� ");
					security = true;
				}
			}

			if (round == 2) {
				break;
			}
		}

		if (round == 1) {
			List<Gladiator> anotherBattleGladiators = anotherBattle(player, enemy);
			if (random.nextBoolean()) {
				anotherBattleWinner = anotherBattleGladiators.get(0);
				anotherBattleLooser = anotherBattleGladiators.get(1);
			} else {
				anotherBattleWinner = anotherBattleGladiators.get(1);
				anotherBattleLooser = anotherBattleGladiators.get(0);
			}
		}

		if (round == 2) {
			if (isWin) {
				enemy = anotherBattleWinner;
			} else {
				enemy = anotherBattleLooser;
			}
			security = false;
		}

		System.out.println("�� ������� ���������� " + player.getType() + "!");
		System.out.println("��� ���������: " + enemy.getType() + "!");
		System.out.println("�����: " + round + "!");
		System.out.println("===================\n" + "���������: 1 ����� ������� ����� ������� ���� �����������.\n"
				+ "===================");
		// ������� ����������, ������ ���!
		while (true) {
			// �������
			System.out.println("�������� ���� ����: 1 - ������, 2 - ��������, 3 - ���, 4 - ����");
			security = true;
			while (security) {
				Scanner sc = new Scanner(System.in);
				input1 = sc.next();
				switch (input1) {
				case "1":
				case "2":
				case "3":
				case "4":
				case "11":
				case "12":
				case "13":
				case "14":
					security = false;
					break;
				default:
					System.out.println("�������� ���� ����: 1 - ������, 2 - ��������, 3 - ���, 4 - ����");
					security = true;
				}
			}
			// ����������
			System.out.println("�������� ��� ��������: 1 - ������, 2 - ��������, 3 - ���, 4 - ����");
			security = true;
			while (security) {
				Scanner sc = new Scanner(System.in);
				input2 = sc.next();
				switch (input2) {
				case "1":
				case "2":
				case "3":
				case "4":
					security = false;
					break;
				default:
					System.out.println("�������� ��� ��������: 1 - ������, 2 - ��������, 3 - ���, 4 - ����");
					security = true;
				}
			}
			player.setTactics(Integer.parseInt(input1), Integer.parseInt(input2));

			if (random.nextBoolean()) {
				enemy.setTactics((int) (Math.random() * 4 + 1), (int) (Math.random() * 4 + 1));
			} else {
				enemy.setTactics((int) (Math.random() * 4 + 11), (int) (Math.random() * 4 + 1));
			}

			if (!player.attack(player, enemy)) {
				if (round == 1) {
					System.out.println("�� �������� � ������ ������! ���������� ����� ���!");
					round++;
					isWin = true;
					System.out.println("��� ��������� ���������: " + anotherBattleWinner.getType());
					enemy = anotherBattleWinner;
					Fight();
					break;
				} else {
					if (isWin) {
						System.out.println("�� ������ I �����! �����������!");
					} else {
						System.out.println("�� ����� �������! �����������!");
					}
				}
				break;
			}

			if (!enemy.attack(enemy, player)) {
				if (round == 1) {
					System.out.println("�� ��������� :-( ���������� ����� ���!");
					round++;
					System.out.println("��� ��������� ���������: " + anotherBattleLooser.getType());
					enemy = anotherBattleLooser;
					Fight();
					break;
				} else {
					if (isWin) {
						System.out.println("�� ����� ������! �����������!");
					} else {
						System.out.println("��������, �� �� ������ ��������� (4) �����.");
					}
					break;
				}
			}
		}
	}

	public static Gladiator randomType() {
		int rand = new Random().nextInt(4);
		Gladiator returnim = new Gladiator() {
		};
		switch (rand) {
		case 1:
			returnim = new Batman();
			return returnim;
		case 2:
			returnim = new SpiderMan();
			return returnim;
		case 3:
			returnim = new SuperMan();
			return returnim;
		case 4:
			returnim = new Terminator();
			return returnim;
		default:
			returnim = new SuperMan();
			return returnim;
		}
	}

	private static List<Gladiator> anotherBattle(Gladiator firstExc, Gladiator secondExc) {
		Gladiator temp = new Gladiator() {
		};
		@SuppressWarnings("serial")
		List<Gladiator> anotherBattleGladiators = new ArrayList<Gladiator>() {
		};
		temp = new Batman();
		if (!temp.getType().equals(firstExc.getType()) && !temp.getType().equals(secondExc.getType())) {
			anotherBattleGladiators.add(temp);
		}
		temp = new SpiderMan();
		if (!temp.getType().equals(firstExc.getType()) && !temp.getType().equals(secondExc.getType())) {
			anotherBattleGladiators.add(temp);
		}
		temp = new Terminator();
		if (!temp.getType().equals(firstExc.getType()) && !temp.getType().equals(secondExc.getType())) {
			anotherBattleGladiators.add(temp);
		}
		temp = new SuperMan();
		if (!temp.getType().equals(firstExc.getType()) && !temp.getType().equals(secondExc.getType())) {
			anotherBattleGladiators.add(temp);
		}
		return anotherBattleGladiators;
	}

	public static Gladiator randomType(Gladiator exc) {
		int rand = new Random().nextInt(4);
		Gladiator returnim = new Gladiator() {
		};
		switch (rand) {
		case 1:
			returnim = new Batman();
			if (returnim.getType().equals(exc.getType())) {
				returnim = new SpiderMan();
			}
			return returnim;
		case 2:
			returnim = new SpiderMan();
			if (returnim.getType().equals(exc.getType())) {
				returnim = new SuperMan();
			}
			return returnim;
		case 3:
			returnim = new SuperMan();
			if (returnim.getType().equals(exc.getType())) {
				returnim = new Terminator();
			}
			return returnim;
		case 4:
			returnim = new Terminator();
			if (returnim.getType().equals(exc.getType())) {
				returnim = new Batman();
			}
			return returnim;
		default:
			returnim = new SuperMan();
			if (returnim.getType().equals(exc.getType())) {
				returnim = new SpiderMan();
			}
			return returnim;
		}
	}

}