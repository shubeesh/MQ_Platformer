package entities;

import static utilz.Constants.PlayerConstants.*;
import static utilz.HelpMethods.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class Player extends Entity {
    private BufferedImage[][] animations;
    private int aniTick;
    private int aniIndex;
    private int playerAction = IDLE;
    private boolean moving = false;
    private boolean attacking = false;
    private boolean left, up, right, down, jump;
    private float playerSpeed = Game.SCALE;
    private int[][] lvlData;

    // Jumping / Gravity
    private float airSpeed = 0f;
    private final float gravity = 0.04f * Game.SCALE;
    private final float fallSpeedAfterCollision = 0.5f * Game.SCALE;
    private boolean inAir = false;

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
        initHitbox(x, y);
    }

    public void update() {
        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        float xDrawOffset = 21 * Game.SCALE;
        float yDrawOffset = 4 * Game.SCALE;
        g.drawImage(animations[playerAction][aniIndex], (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
    }

    private void updateAnimationTick() {
        aniTick++;
        int aniSpeed = 25;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() {
        int startAni = playerAction;
        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
        if (inAir) {
            if (airSpeed < 0) {
                playerAction = JUMP;
            } else {
                playerAction = FALLING;
            }
        }

        if (attacking) {
            playerAction = ATTACK_1;

        }

        if (startAni != playerAction) {
            resetAniTick();
        }
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updatePos() {
        moving = false;

        if (jump) {
            jump();
        }

        if (!left && !right && !inAir) {
            return;
        }

        float xSpeed = 0;

        if (left) {
            playerSpeed -= xSpeed;
        }

        if (right) {
            playerSpeed += xSpeed;
        }


        if (!inAir) {
            if (!IsEntityOnFloor(hitbox, lvlData)) {
                inAir = true;
            }
        }

        if (inAir) {
            CanMoveHere(hitbox.x, hitbox.y + airSpeed, hitbox.width, hitbox.height, lvlData);
        }


    }

    private void jump() {
        if (inAir)
            return;
        inAir = true;
        airSpeed = -2.25f * Game.SCALE;
    }

    private void resetInAir() {
        inAir = false;
        airSpeed = 0;
    }

    private void updateXPos(float xSpeed) {
        if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData)) {
            xSpeed += hitbox.x;
        } else {
            hitbox.x = GetEntityXPosNextToWall(hitbox, xSpeed);
        }
    }
    private void loadAnimations () {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);

        animations = new BufferedImage[9][6];
        for (int row = 0; row < animations.length; row++)
            for (int col = 0; col < animations[row].length; col++)
                animations[row][col] = img.getSubimage(col * 64, row * 40, 64, 40);

    }

    public void loadLvlData ( int[][] lvlData){
        this.lvlData = lvlData;
        if (!IsEntityOnFloor(hitbox, lvlData)){
            inAir = true;
        }
    }

    public void resetDirBooleans () {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking ( boolean attacking){
        this.attacking = attacking;
    }

    public boolean isLeft () {
        return left;
    }

    public void setLeft ( boolean left){
        this.left = left;
    }

    public boolean isRight () {
        return right;
    }

    public void setRight ( boolean right){
        this.right = right;
    }

    public boolean isUp () {
        return up;
    }

    public void setUp ( boolean up){
        this.up = up;
    }

    public boolean isDown () {
        return left;
    }

    public void setDown ( boolean down){
        this.down = down;
    }


    public void setJump ( boolean jump){
        this.jump = jump;
    }

}