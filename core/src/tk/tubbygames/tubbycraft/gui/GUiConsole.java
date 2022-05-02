package tk.tubbygames.tubbycraft.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.Rectangle;
import tk.tubbygames.tubbycraft.TubbyCraft;
import tk.tubbygames.tubbycraft.Utils;
import tk.tubbygames.tubbycraft.Vector2;

public class GUiConsole extends GuiScreen{
    public static Rectangle ConsoleSize = new Rectangle(new Vector2(0, 0), new Vector2(100, 100));
    public GUiConsole()
    {
        super(true);
    }

    @Override
    public void onRender(SpriteBatch batch)
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            TubbyCraft.screen = null;
        }else{
            Utils.DrawColour(batch, Utils.Colour.CONSOLE1, new Rectangle(new Vector2(10,10), new Vector2(100,100)));
        }
    }
}
