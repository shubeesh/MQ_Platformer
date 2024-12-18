package utilz;

import java.awt.geom.Rectangle2D;

import main.Game;

public class HelpMethods {

    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
        // TODO: check if not IsSolid(x, y, lvlData)
        // TODO: if so check if not isSolid(x + width, y + heigth, lvlData)
        // TODO: if so check if not isSolid(x + width, y, lvlData)
        // TODO: if so check if not isSolid(x, y + height, lvlData) and return true
        // TODO: if not do nothing
        // TODO: if not do nothing
        // TODO: if not do nothing
        // TODO: if not return false.
    }

    private static boolean IsSolid(float x, float y, int[][] lvlData) {
        // TODO: if x is less than 0 or x is greater than or equal to Game.GAME_WIDTH -> return true
        // TODO: if y is less than 0 or y is greater than or equal to Game.GAME_HEIGHT -> return true
        // TODO: create a float called xIndex and set to x divided by Game.TILES_SIZE
        // TODO: repeat for yIndex.

        // TODO: get an integer named value from lvlData[(int) yIndex][(int) xIndex]

        // TODO: if value is greater than or equal to 48 or value is less than 0 or value is not equal to 11 -> return true

        return false;
    }

    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
        // TODO: create an int called currentTile and set to (int) (hitbox.x / Game.TILES_SIZE
        // TODO: if xSpeed is positive
        // TODO: create an int called tileXPos and set to currentTile * Game.TILES_SIZE
        // TODO: create an int called xOffset and set to (int) (Game.TILES_SIZE - hitbox.width)
        // TODO: return tileXPos + xOffset - 1
        // TODO: else return currentTile * Game.TILES_SIZE
    }

    public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
        // TODO: create an int called currentTile and set ot (int) (hitbox.y / Game.TILES_SIZE)
        // TODO: if airSpeed is positive
        // TODO: create an int called tileYPos and set to currentTile * Game.TILES_SIZE
        // TODO: create an int called yOffset and set to (int) (Game.TILES_SIZE - hitbox.height)
        // TODO: return tileYPos + yOffset - 1
        // TODO: else return currentTile * Game.TILES_SIZE
    }

    public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
        // TODO: if not isSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData)
        // TODO: if not isSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData)
        // TODO: return false
        // TODO: else nothing

        return true;

    }

}
