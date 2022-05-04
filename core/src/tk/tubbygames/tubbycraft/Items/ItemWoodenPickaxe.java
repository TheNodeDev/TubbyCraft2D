package tk.tubbygames.tubbycraft.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.Item;
import tk.tubbygames.tubbycraft.Tile;

public class ItemWoodenPickaxe extends Item {
    public ItemWoodenPickaxe()
    {
        super(new Tile("./tex/tiles/planks1.png"),"./tex/tiles/planks1.png", 64);
        this.assignedTile = new Tile("./tex/tiles/planks1.png");
        this.ItemTexture = "./tex/tiles/planks1.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
    }

    @Override
    public void Update(SpriteBatch batch)
    {
        if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT))
            BreakTile(Gdx.graphics.getDeltaTime());
    }
}
