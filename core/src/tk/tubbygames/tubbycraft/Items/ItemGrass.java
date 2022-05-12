package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.world.Tile;

public class ItemGrass extends Item {
    public ItemGrass()
    {
        super(new Tile("./tex/tiles/grass.png", true),"./tex/tiles/grass.png", 64);
        this.assignedTile = new Tile("./tex/tiles/grass.png", true);
        this.ItemTexture = "./tex/tiles/grass.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
