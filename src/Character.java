public class Character {
        public String name;
        private int maxHP,maxMana;

        public int level;
        public int currentHP,currentMana;
        private double exp;
        private Equipment currentEquip;

        private int runSpeed = 20;
        public Character(String name,int level){
            this.name=name;
            this.level=level;
            this.maxHP = calculateMaxHP();
            this.maxMana = calculatemaxMana();
            this.currentHP = maxHP;
            this.currentMana = maxMana;
            this.exp= 0;
            this.currentEquip=null;
            this.runSpeed = 10;
            System.out.println("create : "+name + " [ level : " + level + ", " + "MaxHp : " + maxHP + "]");
            System.out.println("--------------------------------");

        }
        private int calculateMaxHP(){
            return 100+10*level;
        }
        private int calculatemaxMana(){
            return 50+2*level;
        }
        public void gainExp(double amount){
            this.exp += amount;
            checkLevelUp();

        }
        private void checkLevelUp(){
            if(exp >=40){
                level++;
                exp = 0; //reset
                maxHP = calculateMaxHP();
                maxMana = calculatemaxMana();
                currentHP=maxHP;
                currentMana =maxMana;
                System.out.println(name + " level up " + level +"!");
            }
        }
        public void receiveDamage(int damage){
            currentHP -=damage;
            if(name.equals("Monster")){
                if(currentHP < 0){
                    currentHP = 0;
                    System.out.println("We win !!!");
                    System.out.println("--------------------------------");
                }
            }
            else {
                if (currentHP < 0) {
                    currentHP = 0;
                    System.out.println("Game Over!!!");
                    System.out.println("--------------------------------");
                }
            }
        }
        public int getRunSpeed(){
            return runSpeed;
        }

        public double maxRunSpeed(int r,int level,Equipment a){
            if( a.nameEquip.equals("sword")){
                return Math.round(r*(0.1+0.04*level));
            }
            if( a.nameEquip.equals("shield")){
                return Math.round(r * (0.1 + 0.02  * level));
            }
            return Math.round(r*(0.1+0.06*level));
        }
        public void decreaseDamage(int protect){
            currentHP += protect;
            if(currentHP>100){
                currentHP=100;
            }
        }
        public void attack(Character target,Equipment a, int level){
            int currentDamage =calculateDamage(a,level);
            if(target.name.equals("Monster")){
                gainExp(20);
            }
            else{
                gainExp(10);
            }
            System.out.println(target.name + " is attacked" + " -" + currentDamage );
            System.out.println("--------------------------------");
            target.receiveDamage(currentDamage);
        }

        private int calculateDamage(Equipment a, int level){
            return (int) (a.damage * (1 + 0.1 * level));

        }
        private int calculateProtect(Equipment b,int level){
            return (int) (b.damage*(1+0.05*level));
        }
        public void protect(Character target,Equipment b,int level){
            int protect = calculateProtect(b,level);
            gainExp(10);
            System.out.println(target.name +" is protected" + " +" + protect);
            System.out.println("--------------------------------");
            target.decreaseDamage(protect);
        }


}
