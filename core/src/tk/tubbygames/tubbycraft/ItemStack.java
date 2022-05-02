package tk.tubbygames.tubbycraft;

public class ItemStack {
    public Item ItemType;
    public int maxStack;
    public int amount = 1;
    public ItemStack(Item i)
    {
        this.ItemType = i;
        this.maxStack = i.maxStack;
    }
    public void Add()
    {
        this.amount++;
    }
    public void Add(int amount)
    {
        this.amount+=amount;
    }
}
