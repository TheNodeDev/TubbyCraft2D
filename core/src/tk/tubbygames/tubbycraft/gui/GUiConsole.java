package tk.tubbygames.tubbycraft.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.*;

import java.io.Console;

public class GUiConsole extends GuiScreen {
    public static Rectangle ConsoleSize = new Rectangle(new Vector2(100, 100), new Vector2(400, 250));
    public static Rectangle DragTopBounds = new Rectangle(new Vector2(), new Vector2());
    public static Rectangle TextBoxBounds = new Rectangle(new Vector2(), new Vector2());
    public static Vector2 DragTopOffset = new Vector2();
    public static boolean isTyping = false;
    public static String consoleText = "";
    private Integer dragTopPointer;

    public GUiConsole() {
        super(true);
        DragTopBounds.Pos1 = new Vector2(ConsoleSize.Pos1.X, ConsoleSize.Pos1.Y + ConsoleSize.Pos2.Y);
        DragTopBounds.Pos2 = new Vector2(ConsoleSize.Pos2.X, 39);
        TextBoxBounds.Pos1 = new Vector2(ConsoleSize.Pos1.X, ConsoleSize.Pos1.Y - 32);
        TextBoxBounds.Pos2 = new Vector2(ConsoleSize.Pos2.X-83, 22);
    }

    @Override
    public void onRender(SpriteBatch batch) {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            TubbyCraft.screen = null;
        } else {
            //Bottom Of Console
            batch.draw(TubbyAssets.LoadTexture("./tex/gui/consolebottom.png"), ConsoleSize.Pos1.X, ConsoleSize.Pos1.Y - 47, ConsoleSize.Pos2.X, 47);
            //Top Left Corner
            batch.draw(TubbyAssets.LoadTexture("./tex/gui/consolecorner.png"), ConsoleSize.Pos1.X - 17, ConsoleSize.Pos1.Y + ConsoleSize.Pos2.Y + 22, 17, 17);
            //Top Right Corner
            batch.draw(TubbyAssets.LoadTexture("./tex/gui/consoleclose.png"), ConsoleSize.Pos1.X + ConsoleSize.Pos2.X, ConsoleSize.Pos1.Y + ConsoleSize.Pos2.Y + 22, 17, 17);
            //Bottom Left Corner
            batch.draw(TubbyAssets.LoadTexture("./tex/gui/consolecorner.png"), ConsoleSize.Pos1.X - 17, ConsoleSize.Pos1.Y - 30, 17, -17);
            //Bottom Right Corner
            batch.draw(TubbyAssets.LoadTexture("./tex/gui/consolesubmit.png"), ConsoleSize.Pos1.X + ConsoleSize.Pos2.X - 83, ConsoleSize.Pos1.Y - 47, 100, 47);
            //Sides Of Console
            /*Left */
            batch.draw(TubbyAssets.LoadTexture("./tex/gui/consoleside.png"), ConsoleSize.Pos1.X - 17, ConsoleSize.Pos1.Y - 30, 17, ConsoleSize.Pos2.Y + 52);
            /*Right*/
            batch.draw(TubbyAssets.LoadTexture("./tex/gui/consoleside.png"), ConsoleSize.Pos1.X + ConsoleSize.Pos2.X, ConsoleSize.Pos1.Y - 30, 17, ConsoleSize.Pos2.Y + 52);
            //Top Of Console
            batch.draw(TubbyAssets.LoadTexture("./tex/gui/consoletop.png"), ConsoleSize.Pos1.X, ConsoleSize.Pos1.Y + ConsoleSize.Pos2.Y, ConsoleSize.Pos2.X, 39);
            Utils.DrawColour(batch, Utils.Colour.CONSOLE1, ConsoleSize);

            //Draw Console Text
            TubbyCraft.font.draw(batch,
                    consoleText,
                    ConsoleSize.Pos1.X,
                    ConsoleSize.Pos1.Y-16
                );
        }
    }

    @Override
    public void touchDragged(int screenX, int screenY, int pointer)
    {
        if(screenX < 0 || screenY < 0 || screenY > Gdx.graphics.getHeight())
            return;
        screenY = Gdx.graphics.getHeight()-screenY;
        if(dragTopPointer != null && pointer == dragTopPointer)
        {
            ConsoleSize.Pos1 = new Vector2(screenX - DragTopOffset.X, screenY - DragTopOffset.Y - ConsoleSize.Pos2.Y);
        }
    }
    @Override
    public void touchDown(int screenX, int screenY, int pointer, int button)
    {
        screenY = Gdx.graphics.getHeight()-screenY;
        if(PosInBounds(new Vector2(screenX, screenY), DragTopBounds)){
            DragTopOffset = new Vector2(screenX-DragTopBounds.Pos1.X, screenY-DragTopBounds.Pos1.Y);
            dragTopPointer = pointer;
        }
        if(PosInBounds(new Vector2(screenX, screenY), TextBoxBounds)){
            isTyping = true;
        }else{
            isTyping = false;
        }
    }
    @Override
    public void touchUp(int screenX, int screenY, int pointer, int button)
    {
        DragTopBounds.Pos1 = new Vector2(ConsoleSize.Pos1.X, ConsoleSize.Pos1.Y + ConsoleSize.Pos2.Y);
        DragTopBounds.Pos2 = new Vector2(ConsoleSize.Pos2.X, 39);
        dragTopPointer = null;
    }

    public boolean PosInBounds(Vector2 pos, Rectangle bounds)
    {
        if(pos.X > bounds.Pos1.X && pos.X < bounds.Pos1.X + bounds.Pos2.X)
        {
            if(pos.Y > bounds.Pos1.Y && pos.Y < bounds.Pos1.Y + bounds.Pos2.Y)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(char character) {
        if(isTyping)
        {
            consoleText+=character;
        }
    }
}
