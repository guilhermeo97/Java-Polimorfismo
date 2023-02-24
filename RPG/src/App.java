public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("RPG Start");
        Warrior delfos = new Warrior("Delfos", 15, 1, 2);     
        Mage luiz = new Mage("Luiz", 3, 8, 4, 6);
        
        System.out.println(delfos.getHealth());
        System.out.println(luiz.getHealth());

        System.out.println(luiz.getName());
        System.out.println(delfos.getName());
        luiz.Hello(delfos);

        delfos.attack(luiz);
        System.out.println(luiz.actualHealth);

        System.out.println("RPG End");

    }
}

abstract class Character{
    protected String name;
    private int health;
    protected int strength;
    protected int inteligence;
    protected int constitution;

    public int actualHealth;


    public Character(String Name, int Strength, int Intelligence, int Constitution, int health) {
        this.name = Name;
        this.strength = Strength;
        this.inteligence = Intelligence;
        this.constitution = Constitution;
        this.health = health;
        this.actualHealth = health;
    }

    public void Hello(Character target){
        System.out.println(
            this.getName() +
            " diz oi para " +
            target.getName()
        );
    }

    public int getHealth() {
        return health;
    }

    public String getName(){
        return this.name;
    }

    public abstract void attack(Character target);

    public abstract void job();

}
class Mage extends Character {
    protected int mana;

    public Mage(String Name, int Strength, int Intelligence, int Constitution, int mana){
        super(Name, Strength, Intelligence, Constitution ,Constitution * 4);
        this.mana = mana;
    }

    public int getMana(){
        return this.mana;
    }

    @Override // sobrescrever o método do pai
    public void attack(Character target){
        int dano = inteligence * 2;
        System.out.println("Total de dano mágico: " + dano);
        target.actualHealth -= dano;
        if(target.actualHealth > 0) {
            System.out.println(target.getName() + " Sobreviveu");
        }else{
            System.out.println(target.getName() + " Morreu");  
        }
    }

    @Override
    public void job(){
        System.out.println("Mage");    
    }

}

class Warrior extends Character { //stregnh *3
    public Warrior(String Name, int Strength, int Intelligence, int Constitution) {
        super(Name, Strength, Intelligence, Constitution, Constitution * 5);
    }    
        @Override
        public void attack(Character target){
        int dano = this.strength * 3;
        System.out.println("Total de dano físico: " + dano);
        target.actualHealth -= dano;

        if(target.actualHealth > 0){
            System.out.println(target.getName() + " Sobreviveu");
        }else{
            System.out.println(target.getName() + " Morreu");
        }
        }

        @Override
        public void job(){
            System.out.println("Warrior");
    }
}
