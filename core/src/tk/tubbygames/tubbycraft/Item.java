package tk.tubbygames.tubbycraft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Item {
    public Tile assignedTile;
    public String ItemTexture;
    public int maxStack;
    public Item(Tile tile, String texture, int maxStack){}

    public void ItemUse()
    {

    }
    public void BreakTile(float rate)
    {
        Vector2 MousePos = new Vector2(
                Gdx.input.getX(),
                Gdx.graphics.getHeight()-Gdx.input.getY()
        );
        Vector2 TilePos = new Vector2(
                (float) Math.floor((MousePos.X-(TileManager.TileSize*Camera.pos.X))/TileManager.TileSize),
                (float) Math.floor((MousePos.Y-(TileManager.TileSize*Camera.pos.Y))/TileManager.TileSize)
        );
        if(TileManager.TileMap[(int) TilePos.X][(int) TilePos.Y].isFloor)
            return;
        TileManager.TileMap[(int) TilePos.X][(int) TilePos.Y].breakamount+=rate;
        System.out.println(TileManager.TileMap[(int) TilePos.X][(int) TilePos.Y].breakamount);
        if(TileManager.TileMap[(int) TilePos.X][(int) TilePos.Y].breakamount > 1f){
            TileManager.TileMap[(int) TilePos.X][(int) TilePos.Y].isFloor = true;
            TileManager.TileMap[(int) TilePos.X][(int) TilePos.Y].breakamount = 0f;
            Inventory.AddItem(TileManager.TileMap[(int) TilePos.X][(int) TilePos.Y].linkedItem, 1);
        }
    }
    public void PlaceTile()
    {
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
                    Inventory.Stacks.get(i).amount++;
                }
            }
        }
    }
    public void Update(SpriteBatch batch)
    {

    }
}
