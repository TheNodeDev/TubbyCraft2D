package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.Item;
import tk.tubbygames.tubbycraft.Tile;

public class ItemAcaciaPlanks extends Item {
    public ItemAcaciaPlanks()
    {
        super(new Tile("./tex/tiles/planks2.png"),"./tex/tiles/planks2.png", 64);
        this.assignedTile = new Tile("./tex/tiles/planks2.png");
        this.ItemTexture = "./tex/tiles/planks2.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
