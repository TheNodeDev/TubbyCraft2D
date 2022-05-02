package tk.tubbygames.tubbycraft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Inventory {
    public static ItemStack[] Stacks = new ItemStack[9];
    public static int SelectedSlot = 0;
    public static ItemStack GetCurrentItemStack()
    {
        return Stacks[SelectedSlot];
    }
    public static Item GetCurrentItem()
    {
        return Stacks[SelectedSlot].ItemType;
    }
    public static void DrawInventory(SpriteBatch batch)
    {
        batch.draw(TubbyAssets.LoadTexture("./tex/gui/hotbar.png"), (Gdx.graphics.getWidth()/4f), 0, Gdx.graphics.getWidth()/2f, 0.12f * Gdx.graphics.getWidth()/2f);

        //Drawing the Selector
        batch.draw(TubbyAssets.LoadTexture("./tex/gui/hotbarSelector.png"), (Gdx.graphics.getWidth()/4f) + ((Gdx.graphics.getWidth()/18f)*SelectedSlot), 0, 0.12f * Gdx.graphics.getWidth()/2f, 0.12f * Gdx.graphics.getWidth()/2f);
        Vector2 HotBarPos = new Vector2((Gdx.graphics.getWidth()/4f) + ((Gdx.graphics.getWidth()/18f)*SelectedSlot), 0);
        for(int i = 0; i < 9; i++)
        {
            ItemStack stack = Stacks[i];
            if(stack == null)
                return;
            if(stack.ItemType == null)
                return;

            Item item = stack.ItemType;
            if(item.ItemTexture != null)
            {
                batch.draw(
                        TubbyAssets.LoadTexture(item.ItemTexture),
                        (Gdx.graphics.getWidth()/4f) + ((Gdx.graphics.getWidth()/18f)*i) + (0.12f * Gdx.graphics.getWidth()/2f)*0.14f,
                        (0.12f * Gdx.graphics.getWidth()/2f)*0.14f,
                        (0.12f * Gdx.graphics.getWidth()/2f)*0.72f,
                        (0.12f * Gdx.graphics.getWidth()/2f)*0.72f
                );
                TubbyCraft.font.draw(
                        batch,
                        String.valueOf(stack.amount),
                        (Gdx.graphics.getWidth()/4f) + ((Gdx.graphics.getWidth()/18f)*i) + (0.12f * Gdx.graphics.getWidth()/2f)*0.14f,
                        (0.12f * Gdx.graphics.getWidth()/2f)*0.14f + 10
                );

            }
        }
    }
}
