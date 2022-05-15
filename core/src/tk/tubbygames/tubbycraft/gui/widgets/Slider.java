package tk.tubbygames.tubbycraft.gui.widgets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.Rectangle;
import tk.tubbygames.tubbycraft.TubbyAssets;
import tk.tubbygames.tubbycraft.TubbyCraft;
import tk.tubbygames.tubbycraft.utils.Vector2;

public class Slider {
    public String tag;
    Button.ButtonSize size;
    public Rectangle bounds;
    public float Value = 0.5f;
    public Slider(String tag, float Value, Button.ButtonSize size, Vector2 pos)
    {
        if(tag == null)
            return;
        this.tag = tag;
        this.size = size;
        this.bounds = new Rectangle(new Vector2(), new Vector2());
        this.bounds.Pos1 = pos;
        switch (this.size)
        {
            case OneByOne:
                this.bounds.Pos2 = new Vector2(100,100);
                break;
            case TwoByOne:
                this.bounds.Pos2 = new Vector2(200,100);
                break;
            case ThreeByOne:
                this.bounds.Pos2 = new Vector2(300,100);
                break;
        }
    }
    public void Draw(SpriteBatch batch)
    {
        if(tag == null)
            return;
        this.HandleInput();
        String texName = "./tex/gui/button";
        switch (this.size)
        {
            case OneByOne:
                texName += "1.png";
                break;
            case TwoByOne:
                texName += "2.png";
                break;
            case ThreeByOne:
                texName += "3.png";
                break;
        }
        batch.setColor(new Color(0.4f, 0.4f, 0.4f, 1f));
        batch.draw(
                TubbyAssets.LoadTexture(texName),
                this.bounds.Pos1.X,
                this.bounds.Pos1.Y,
                this.bounds.Pos2.X,
                this.bounds.Pos2.Y
        );
        batch.setColor(Color.WHITE);
        batch.draw(
                TubbyAssets.LoadTexture("./tex/gui/slider.png"),
                this.bounds.Pos1.X + (Value*this.bounds.Pos2.X)-12.5f,
                this.bounds.Pos1.Y,
                25,
                100
        );
        TubbyCraft.font.draw(
                batch,
                tag,
                this.bounds.Pos1.X+(this.bounds.Pos2.X/2)-(TubbyCraft.GetStringSize(tag, TubbyCraft.font).X/2),
                this.bounds.Pos1.Y+(this.bounds.Pos2.Y/2)+(TubbyCraft.GetStringSize(tag, TubbyCraft.font).Y/2)
        );
    }
    private boolean HandleInput()
    {
        if(tag == null)
            return false;
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
        {
            Vector2 Mousepos = new Vector2(
                    Gdx.input.getX(),
                    Gdx.graphics.getHeight()-Gdx.input.getY()
            );
            if(PosInBounds(Mousepos))
            {
                Vector2 Localpos = new Vector2(
                    Mousepos.X - bounds.Pos1.X,
                        Mousepos.Y - bounds.Pos1.Y
                );
                Value = Localpos.X / bounds.Pos2.X;
                System.out.println(Value);
            }
        }
        return false;
    }
    public boolean PosInBounds(Vector2 pos)
    {
        if(tag == null)
            return false;
        if(pos.X > this.bounds.Pos1.X && pos.X < this.bounds.Pos1.X + this.bounds.Pos2.X)
        {
            if(pos.Y > this.bounds.Pos1.Y && pos.Y < this.bounds.Pos1.Y + this.bounds.Pos2.Y)
            {
                return true;
            }
        }
        return false;
    }
}
