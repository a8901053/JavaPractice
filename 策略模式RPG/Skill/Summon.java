package 重構策略模式RPG.Skill;

import 重構策略模式RPG.Monsters.Guard;
import 重構策略模式RPG.Monsters.Soldier;
import 重構策略模式RPG.Monsters.Witch;
import 重構策略模式RPG.Role;
import 重構策略模式RPG.RpgSystem;

public class Summon extends Skill {

    public Summon(RpgSystem rpg) {
        super.setConsumeMp(50);
        super.setName("召喚");
        super.setRpg(rpg);
        super.setSkillDescribe("召喚：消耗50點MP、場上增加一位敵人 (士兵、護衛隊 或 法師)");
    }

    @Override
    public int skillAttack(Role attack ,Role attacked) {
        int damage = 0;

        if (attack.getMp() > super.getConsumeMp()) {
            attack.setMp(attack.getMp() - getConsumeMp());
            int summon = (int) (Math.random() * 3);
            switch (summon) {
                case 0:
                    super.getRpg().getMonsters().add(new Soldier());
                    break;
                case 1:
                    super.getRpg().getMonsters().add(new Guard());
                    break;
                case 2:
                    super.getRpg().getMonsters().add(new Witch(super.getRpg()));
                    break;
            }
            System.out.println(attack.getName() + "召喚了"
                    + super.getRpg().getMonsters().get(super.getRpg().getMonsters().size() - 1).getName());
        } else {
            super.getRpg().normalAttack(attack, attacked);
        }
        return 0;
    }

}
