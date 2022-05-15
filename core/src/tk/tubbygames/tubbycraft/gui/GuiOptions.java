package tk.tubbygames.tubbycraft.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.GameSettings;
import tk.tubbygames.tubbycraft.gui.widgets.Button;
import tk.tubbygames.tubbycraft.gui.widgets.Slider;
import tk.tubbygames.tubbycraft.utils.Vector2;

public class GuiOptions extends GuiScreen{
    Slider fovSlider = new Slider("FOV", 0.5f, Button.ButtonSize.ThreeByOne, new Vector2(100, 10));
    Button loadPackButton = new Button("Load Resource Pack", Button.ButtonSize.ThreeByOne, new Vector2(100, 10));
    Button enableCheatsButton = new Button("Enable Cheats", Button.ButtonSize.ThreeByOne, new Vector2(100, 10));
    public GuiOptions()
    {
        super(true);
    }

    @Override
    public void onRender(SpriteBatch batch) {
        fovSlider.bounds.Pos1.X = ( Gdx.graphics.getWidth()/2f)-150;
        fovSlider.bounds.Pos1.Y = Gdx.graphics.getHeight()-100;
        loadPackButton.bounds.Pos1.X = ( Gdx.graphics.getWidth()/2f)-150;
        loadPackButton.bounds.Pos1.Y = Gdx.graphics.getHeight()-200;
        enableCheatsButton.bounds.Pos1.X = ( Gdx.graphics.getWidth()/2f)-150;
        enableCheatsButton.bounds.Pos1.Y = Gdx.graphics.getHeight()-300;
        fovSlider.Draw(batch);
        loadPackButton.Draw(batch);
        enableCheatsButton.Draw(batch);
        GameSettings.TileSize = (int) (118-((118 * fovSlider.Value)-10));
    }
}
