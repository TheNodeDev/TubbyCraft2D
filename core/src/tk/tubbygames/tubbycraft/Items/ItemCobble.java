package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.world.Tile;

public class ItemCobble extends Item {
    public ItemCobble()
    {
        super(new Tile("./tex/tiles/cbbl1.png", true),"./tex/tiles/cbbl1.png", 64);
        this.assignedTile = new Tile("./tex/tiles/cbbl1.png", true);
        this.ItemTexture = "./tex/tiles/cbbl1.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
