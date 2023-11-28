// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("----------START GAME-------------");
        Character a = new Character("VANDA", 1);
        Character b = new Character("VAN", 1);
        Character m = new Character("Monster", 2);
        Equipment sword = new Equipment("sword", 25);
        Equipment shield = new Equipment("shield", 15);
        Equipment fire = new Equipment("fire", 20);
        a.attack(m, sword, 1);
        m.attack(b, fire,2);
        b.protect(b, shield, 1);
        b.attack(m, sword, 10);
        a.attack(m,sword,1);
        m.attack(b, fire,2);
        a.protect(a,shield,1);
        b.attack(m,sword,1);
        System.out.println(a.name+"'s speed :"+a.maxRunSpeed(100, 1, sword));
        System.out.println(b.name+"'s speed :"+b.maxRunSpeed(100, 1, shield));
        System.out.println(a.name + " [ level : " + a.level + ", " + "Hp : " + a.currentHP + "]");
        System.out.println(b.name + " [ level : " + b.level + ", " + "Hp : " + b.currentHP + "]");
        System.out.println(m.name + " [ level : " + m.level + ", " + "Hp : " + m.currentHP + "]");
        System.out.println("----------------------------------");
        //System.out.println("level a : " + a.get );
//        System.out.println(a.getRunSpeed());
//        System.out.println(b.);
    }
}
