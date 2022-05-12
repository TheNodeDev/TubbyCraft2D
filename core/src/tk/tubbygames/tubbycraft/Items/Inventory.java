package tk.tubbygames.tubbycraft.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.TubbyAssets;
import tk.tubbygames.tubbycraft.TubbyCraft;
import tk.tubbygames.tubbycraft.utils.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public static List<ItemStack> Stacks;
    static {
        Stacks = new ArrayList<ItemStack>();
    }
    public static int SelectedSlot = 0;
    public static ItemStack GetCurrentItemStack()
    {
        return Stacks.get(SelectedSlot);
    }
    public static Item GetCurrentItem()
    {
        if(SelectedSlot > Stacks.size()-1)
            return null;
        ItemStack stack = Stacks.get(SelectedSlot);

        if(stack != null)
            return stack.ItemType;
        return null;
    }
    public static void DrawInventory(SpriteBatch batch)
    {
        batch.draw(TubbyAssets.LoadTexture("./tex/gui/hotbar.png"), (Gdx.graphics.getWidth()/4f), 0, Gdx.graphics.getWidth()/2f, 0.12f * Gdx.graphics.getWidth()/2f);

        //Drawing the Selector
        batch.draw(TubbyAssets.LoadTexture("./tex/gui/hotbarSelector.png"), (Gdx.graphics.getWidth()/4f) + ((Gdx.graphics.getWidth()/18f)*SelectedSlot), 0, 0.12f * Gdx.graphics.getWidth()/2f, 0.12f * Gdx.graphics.getWidth()/2f);
        Vector2 HotBarPos = new Vector2((Gdx.graphics.getWidth()/4f) + ((Gdx.graphics.getWidth()/18f)*SelectedSlot), 0);
        for(int i = 0; i < Math.min(Stacks.size(), 9); i++)
        {
            ItemStack stack = Stacks.get(i);
            if(stack == null)
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
    public static void UpdateItem(SpriteBatch batch)
    {
        if(SelectedSlot > Stacks.size()-1)
            return;
        if(Stacks.get(SelectedSlot) != null)
            Stacks.get(SelectedSlot).ItemType.Update(batch);
    }
    public static void AddItem(Item itemtype, int amount)
    {
        for(ItemStack s : Stacks)
        {
            if(s.ItemType.equals(itemtype))
            {
                s.Add(amount);
                return;
            }
        }
        Stacks.add(new ItemStack(itemtype));
    }
}
