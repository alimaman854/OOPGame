public class Player {
	String name;
	int HP = 100;
	int AP = 8;
	int EP = 60;
	boolean healing = false;
	boolean doubleturn = false;

	static void PrintStats(Player P1) {
		System.out.println("Stats:");
                System.out.println("Name: " + P1.name);
                System.out.println("HP: " + P1.HP);
                System.out.println("AP: " + P1.AP);
                System.out.println("EP: " + P1.EP);

                if (P1.healing == true) {
                        System.out.println("Healing: Aquired");
                } else {
                        System.out.println("Double Turn: Aquired");
                }
        }
}
