package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.Item;
import tk.tubbygames.tubbycraft.Tile;

public class ItemGrass extends Item {
    public ItemGrass()
    {
        super(new Tile("./tex/tiles/grass.png"),"./tex/tiles/grass.png", 64);
        this.assignedTile = new Tile("./tex/tiles/grass.png");
        this.ItemTexture = "./tex/tiles/grass.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
