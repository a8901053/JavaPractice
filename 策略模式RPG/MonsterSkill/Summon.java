package 策略模式RPG.MonsterSkill;

import 策略模式RPG.*;
import 策略模式RPG.Hero;
import 策略模式RPG.Monster.Guard;
import 策略模式RPG.Monster.Monster;
import 策略模式RPG.Monster.Soldier;
import 策略模式RPG.Monster.Witch;

public class Summon implements MonsterSkill {
    private String name;
    private RpgSystem rpg;
    private int consumeMp;


    public Summon(RpgSystem rpg) {
        this.rpg = rpg;
        this.name = "召喚";
        this.consumeMp = 50;
    }

    @Override
    public int skillAttack(Monster attack, Hero attacked) {
        int damage = 0;

        if (attack.getMp() > consumeMp) {
            attack.setMp(attack.getMp() - consumeMp);
            int summon = (int) (Math.random() * 3);
            switch (summon) {
                case 0:
                    rpg.getMonsters().add(new Soldier());
                    break;
                case 1:
                    rpg.getMonsters().add(new Guard());
                    break;
                case 2:
                    rpg.getMonsters().add(new Witch(rpg));
                    break;
            }
            System.out.println(attack.getName() + "召喚了" + rpg.getMonsters().get(rpg.getMonsters().size() - 1).getName());
        } else {
            rpg.monsterNormalAttack(attack, attacked);
        }
        return 0;
    }


    @Override
    public String getName() {
        return name;
    }
}
