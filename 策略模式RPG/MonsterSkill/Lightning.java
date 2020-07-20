package 策略模式RPG.MonsterSkill;

import 策略模式RPG.Hero;
import 策略模式RPG.Monster.Monster;
import 策略模式RPG.RpgSystem;

public class Lightning implements MonsterSkill {
    private int consumeMP;
    private String name;
    private RpgSystem rpg;

    public Lightning(RpgSystem rpg) {
        this.name = "雷擊";
        this.rpg = rpg;
        this.consumeMP = 100;
    }

    @Override
    public int skillAttack(Monster attack, Hero attacked) {
        int damage = 0;

        if (attack.getMp() > consumeMP) {
            attack.setMp(attack.getMp() - consumeMP);
            System.out.println("[怪物]" + attack.getName() + "使用了" + name);
            damage = 250 - attacked.getMdf();
            if (damage > 0) {
                attacked.setHp(attacked.getHp() - damage);
                return damage;
            }
        }
        return rpg.monsterNormalAttack(attack, attacked);
    }

    @Override
    public String getName() {
        return name;
    }

}
