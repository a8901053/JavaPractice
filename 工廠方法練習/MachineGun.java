package 工廠方法練習;

import Bullet.Bullet;
import Bullet.MachineBullet;

public class MachineGun implements Gun {
    @Override
    public Bullet attack() {
        return new MachineBullet();
    }
}
