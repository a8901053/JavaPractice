package 重構策略模式RPG;

public class Attack implements NormalAttack {


    @Override
    public int attack(Role attack,Role attacked) {
        int damage = 0;

        damage = attack.getAtk() - attacked.getDef();
        if (damage > 0) {
            attacked.setHp(attacked.getHp() - damage);
            return damage;
        }

        return 0;
    }
}
