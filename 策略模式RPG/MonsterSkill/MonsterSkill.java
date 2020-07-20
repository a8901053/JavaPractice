package 策略模式RPG.MonsterSkill;

import 策略模式RPG.Hero;
import 策略模式RPG.Monster.Monster;

public interface MonsterSkill {

    int skillAttack(Monster attack, Hero attacked);

    String getName();

}
