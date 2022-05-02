package tk.tubbygames.tubbycraft;

import com.badlogic.gdx.Gdx;

public class Item {
    public Tile assignedTile;
    public String ItemTexture;
    public int maxStack;
    public Item(Tile tile, String texture, int maxStack){}

    public void ItemUse()
    {

    }
    public void PlaceTile()
    {
        Vector2 MousePos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        System.out.println(MousePos);
    }
}
