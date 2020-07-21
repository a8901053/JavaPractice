package 重構策略模式RPG.Monsters;

import 重構策略模式RPG.Role;
import 重構策略模式RPG.RpgSystem;
import 重構策略模式RPG.Skill.Summon;

public class Boss extends Role {

    public Boss(RpgSystem rpg) {
        super.setName("Boss");
        super.setHp(1000);
        super.setMp(300);
        super.setAtk(90);
        super.setDef(40);
        super.setMdf(40);
        super.setRpg(rpg);
        super.getSkills().add(new Summon(rpg));
    }
}
