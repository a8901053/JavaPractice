package 策略模式RPG.Monster;

import 策略模式RPG.MonsterSkill.Summon;
import 策略模式RPG.RpgSystem;

public class Boss extends Monster {

    public Boss(RpgSystem rpg) {
        super.setName("Boss");
        super.setHp(1000);
        super.setMp(300);
        super.setAtk(90);
        super.setDef(40);
        super.setMdf(40);
        super.setRpg(rpg);
        super.setSkill(new Summon(rpg));
    }
}
