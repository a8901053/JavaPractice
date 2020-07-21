package 重構策略模式RPG.Monsters;

import 重構策略模式RPG.Role;

public class Guard extends Role {

    public Guard() {
        super.setName("護衛隊");
        super.setHp(270);
        super.setMp(0);
        super.setAtk(100);
        super.setDef(20);
        super.setMdf(40);
    }
}
