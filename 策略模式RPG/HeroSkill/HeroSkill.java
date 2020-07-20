package 策略模式RPG.HeroSkill;

import 策略模式RPG.Hero;
import 策略模式RPG.Monster.Monster;

public interface HeroSkill {
    int skillAttack(Hero hero,Monster attacked);

    String getName();

    String getSkillDescribe();

    int getConsumeMp();
}
