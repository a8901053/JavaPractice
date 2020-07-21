package 重構策略模式RPG.Monsters;

import 重構策略模式RPG.Role;
import 重構策略模式RPG.RpgSystem;
import 重構策略模式RPG.Skill.Lightning;

public class Witch extends Role {

    public Witch(RpgSystem rpg) {
        super.setName("法師");
        super.setHp(90);
        super.setMp(700);
        super.setAtk(5);
        super.setDef(20);
        super.setMdf(60);
        super.setRpg(rpg);
        super.getSkills().add(new Lightning(rpg));
    }

}
