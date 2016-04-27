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
		Boolean security = true; // защита от неправильного ввода
		if (round == 1) {
			System.out.println("***Добро пожаловать на Гладиаторские бои!!!***"
					+ "\nДля начала Вам нужно выбрать персонажа каким хотите играть.");
			System.out.println("Выберите гладиатора: 1 - Супермэн, 2 - Бэтмэн, 3 - Человек паук, 4 - Терминатор ");
		}

		while (security) {
			if (round == 1) {
				Scanner sc = new Scanner(System.in);
				input1 = sc.next();

				if (!player.getType().equals("ОШИБКА!")) {
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
					System.out.println("Ошибка ввода");
					System.out.println(
							"Выберите гладиатора: 1 - Бэтмэн, 2 - Супермэн, 3 - Человек паук, 4 - Терминатор ");
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

		System.out.println("Вы выбрали гладиатора " + player.getType() + "!");
		System.out.println("Ваш противник: " + enemy.getType() + "!");
		System.out.println("Раунд: " + round + "!");
		System.out.println("===================\n" + "Запомните: 1 перед номером удара сделает удар критическим.\n"
				+ "===================");
		// выбрали гладиатора, начали бой!
		while (true) {
			// атакуем
			System.out.println("Выберите куда бить: 1 - голова, 2 - туловище, 3 - пах, 4 - ноги");
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
					System.out.println("Выберите куда бить: 1 - голова, 2 - туловище, 3 - пах, 4 - ноги");
					security = true;
				}
			}
			// защищаемся
			System.out.println("Выберите что защищать: 1 - голова, 2 - туловище, 3 - пах, 4 - ноги");
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
					System.out.println("Выберите что защищать: 1 - голова, 2 - туловище, 3 - пах, 4 - ноги");
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
					System.out.println("Вы победили в первом раунде! Начинается новый бой!");
					round++;
					isWin = true;
					System.out.println("Ваш следующий противник: " + anotherBattleWinner.getType());
					enemy = anotherBattleWinner;
					Fight();
					break;
				} else {
					if (isWin) {
						System.out.println("Вы заняли I место! Поздравляем!");
					} else {
						System.out.println("Вы взяли серебро! Поздравляем!");
					}
				}
				break;
			}

			if (!enemy.attack(enemy, player)) {
				if (round == 1) {
					System.out.println("Вы проиграли :-( Начинается новый бой!");
					round++;
					System.out.println("Ваш следующий противник: " + anotherBattleLooser.getType());
					enemy = anotherBattleLooser;
					Fight();
					break;
				} else {
					if (isWin) {
						System.out.println("Вы взяли бронзу! Поздравляем!");
					} else {
						System.out.println("Сожалеем, но Вы заняли последнее (4) место.");
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