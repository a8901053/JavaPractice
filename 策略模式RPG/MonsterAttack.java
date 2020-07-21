package 重構策略模式RPG;

import java.util.List;

public class MonsterAttack implements AiAttack {
    RpgSystem rpg;
    List<Role> monsters;

    public MonsterAttack(RpgSystem rpg) {
        this.rpg = rpg;
        monsters = rpg.getMonsters();
    }

    @Override
    public void aiAttack() {
        try {
            for (int i = 0; i < monsters.size(); i++) {
                int damage;
                int selectSkill = 0;
                int randomAttackMethod = (int) (Math.random() * 2);
                if(!monsters.get(i).getSkills().isEmpty()){
                    selectSkill = (int)(Math.random()*monsters.get(i).getSkills().size());
                }

                if (monsters.get(i).isAction()) {
                    if (randomAttackMethod == 0) {
                        damage = rpg.normalAttack(monsters.get(i), rpg.getHero());
                    } else {
                        if (rpg.getMonsters().get(i).getSkills().isEmpty()) {
                            damage = rpg.normalAttack(monsters.get(i), rpg.getHero());
                        } else {
                            damage = rpg.skillAttack(selectSkill, monsters.get(i), rpg.getHero());
                        }
                    }
                    System.out.println("[怪物]" + monsters.get(i).getName() + "造了玩家" + damage + "的傷害");
                    Thread.sleep(1000);
                } else {
                    monsters.get(i).setActionCount(monsters.get(i).getActionCount() - 1);
                    if (monsters.get(i).getActionCount() == 0) {
                        monsters.get(i).setAction(true);
                    }
                }

            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}