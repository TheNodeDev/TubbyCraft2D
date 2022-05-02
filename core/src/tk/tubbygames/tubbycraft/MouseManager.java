package tk.tubbygames.tubbycraft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MouseManager {
    public static void DrawCrosshair(SpriteBatch batch)
    {
        batch.draw(TubbyAssets.LoadTexture("./tex/gui/Crosshair.png"), Gdx.input.getX()-16, Gdx.graphics.getHeight()-Gdx.input.getY()-16, 32, 32);
    }
    public static void OnClick()
    {
        //Get Tile Co-ords By Mouse
        /*
            X = (Campos + x) * TileSize
            Campos+x = X/TileSize
            x=(X/TileSize)-CamPos
         */
        if(Inventory.GetCurrentItemStack().amount <= 0)
            return;
        Inventory.GetCurrentItemStack().amount--;
        Vector2 MousePos = new Vector2(
                Gdx.input.getX(),
                Gdx.graphics.getHeight()-Gdx.input.getY()
        );
        Vector2 TilePos = new Vector2(
                (float) Math.floor((MousePos.X-(TileManager.TileSize*Camera.pos.X))/TileManager.TileSize),
                (float) Math.floor((MousePos.Y-(TileManager.TileSize*Camera.pos.Y))/TileManager.TileSize)
        );
        Tile currentTile = new Tile(TileManager.TileMap[(int) TilePos.X][(int) TilePos.Y]);
        if(currentTile.loc.equals(new Tile(Inventory.GetCurrentItem().assignedTile).loc))
            TileManager.TileMap[(int) TilePos.X][(int) TilePos.Y].isFloor = false;
        else{
            TileManager.TileMap[(int) TilePos.X][(int) TilePos.Y] = new Tile(Inventory.GetCurrentItem().assignedTile);
            int i = -1;
            for(ItemStack is : Inventory.Stacks)
            {
                i++;
                if(is == null)
                    break;
                System.out.println(is.ItemType.assignedTile.loc);
                if(is.ItemType.assignedTile.loc.equals(currentTile.loc))
                {
                    Inventory.Stacks[i].amount++;
                }
            }
        }
    }
}
