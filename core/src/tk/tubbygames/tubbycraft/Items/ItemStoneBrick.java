package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.world.Tile;

public class ItemStoneBrick extends Item {
    public ItemStoneBrick()
    {
        super(new Tile("./tex/tiles/cbbl2.png", true),"./tex/tiles/cbbl2.png", 64);
        this.assignedTile = new Tile("./tex/tiles/cbbl2.png", true);
        this.ItemTexture = "./tex/tiles/cbbl2.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
