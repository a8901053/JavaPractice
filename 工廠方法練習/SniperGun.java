package 工廠方法練習;

import Bullet.Bullet;
import Bullet.SniperBullet;

public class SniperGun implements Gun {
    @Override
    public Bullet attack() {
        return new SniperBullet();
    }

}
