package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.player;
import levels.LevelManager;
import main.Game;

public class Playing extends State implements Statemethods {
    // TODO: all fields are private
    // TODO: create a Player called player
    // TODO: create a LevelManager called levelManager

    public Playing(Game game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        // TODO: set levelManager to new LevelManager(game)
        // TODO: set player to new Player(200, 200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE)
        // TODO: call player.loadLvlData(levelManager.getCurrentLevel().getLevelData())
    }

    @Override
    public void update() {
        levelManger.update();
        player.update();
    }

    @Override
    public void draw(Graphics g) {
        levelManger.draw(g);
        player.render(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO: if (e.getButton() is equal to MouseEvent.Button1);
        player.setAttacking(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                player.setLeft(true);
                break;
            case KeyEvent.VK_D:
                player.setRight(true);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(true);
                break;
            case KeyEvent.VK_BACK_SPACE:
                Gamestate.state = Gamestate.MENU;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                player.setLeft(false);
                break;
            case KeyEvent.VK_D:
                player.setRight(false);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(false);
                break;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }

    public player getPlayer() {
        return player;
    }

}
