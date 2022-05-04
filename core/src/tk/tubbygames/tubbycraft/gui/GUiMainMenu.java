package tk.tubbygames.tubbycraft.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.TubbyCraft;
import tk.tubbygames.tubbycraft.Vector2;
import tk.tubbygames.tubbycraft.gui.widgets.Button;

public class GUiMainMenu extends GuiScreen{

    Button exitButton = new Button( null, null, null);
    Button resumeButton = new Button( null, null, null);
    Button optionsButton = new Button( null, null, null);
    int timeAlive = 0;
    public GUiMainMenu()
    {
        super(true);
        this.resumeButton = new Button("Resume", Button.ButtonSize.ThreeByOne, new Vector2((Gdx.graphics.getWidth()/2)-150,Gdx.graphics.getHeight()/2+100));
        this.optionsButton = new Button("Options", Button.ButtonSize.ThreeByOne, new Vector2((Gdx.graphics.getWidth()/2)-150,Gdx.graphics.getHeight()/2));
        this.exitButton = new Button("Exit", Button.ButtonSize.ThreeByOne, new Vector2((Gdx.graphics.getWidth()/2)-150,Gdx.graphics.getHeight()/2-100));
    }

    @Override
    public void onRender(SpriteBatch batch)
    {
        timeAlive++;
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) && timeAlive > 10){
            TubbyCraft.screen = null;
        }else{
            resumeButton.Draw(batch);
            optionsButton.Draw(batch);
            exitButton.Draw(batch);
            if(exitButton.isClicked())
            {
                Gdx.app.exit();
            }
            if(resumeButton.isClicked())
            {
                TubbyCraft.screen = null;
            }
        }
    }
}
