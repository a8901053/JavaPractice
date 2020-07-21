package 重構策略模式RPG;

import 重構策略模式RPG.Monsters.Boss;
import 重構策略模式RPG.Monsters.Guard;
import 重構策略模式RPG.Monsters.Soldier;
import 重構策略模式RPG.Monsters.Witch;

public class MonsterFactory implements Monster {
    private int roundCount = 0;
    private int soliderAmount;
    private int guardAmount;
    private int witchAmount;
    private int bossAmount;
    private RpgSystem rpg;

    public MonsterFactory(RpgSystem rpg) {
        this.rpg = rpg;
    }

    @Override
    public void createAll() {
        roundAdjustmentMonsterAmount();
        createSoliderAmount();
        createWitch();
        createBoss();
        createGuardAmount();
    }

    @Override
    public void createSoliderAmount() {
        for (int j = 0; j < soliderAmount; j++) {
            rpg.getMonsters().add(new Soldier());
        }
    }

    @Override
    public void createGuardAmount() {
        for (int j = 0; j < guardAmount; j++) {
            rpg.getMonsters().add(new Guard());
        }
    }

    @Override
    public void createWitch() {
        for (int j = 0; j < witchAmount; j++) {
            rpg.getMonsters().add(new Witch(rpg));
        }
    }

    @Override
    public void createBoss() {
        for (int j = 0; j < bossAmount; j++) {
            rpg.getMonsters().add(new Boss(rpg));
        }
    }

    @Override
    public void roundAdjustmentMonsterAmount() {
        roundCount++;
        switch (roundCount) {
            case 1:
                soliderAmount = 4;
                guardAmount = 1;
                witchAmount = 0;
                bossAmount = 0;
                break;
            case 2:
                soliderAmount = 2;
                guardAmount = 0;
                witchAmount = 2;
                bossAmount = 0;
                break;
            case 3:
                soliderAmount = 0;
                guardAmount = 0;
                witchAmount = 0;
                bossAmount = 1;
                break;
        }
    }
}
