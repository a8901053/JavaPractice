package 工廠方法練習;


import Bullet.Bullet;
import Bullet.ExplosionBullet;

public class ExplosionGun implements Gun {
    @Override
    public Bullet attack() {
        return new ExplosionBullet();
    }
}
