package tk.tubbygames.tubbycraft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import tk.tubbygames.tubbycraft.Items.*;
import tk.tubbygames.tubbycraft.gui.GUiMainMenu;
import tk.tubbygames.tubbycraft.gui.GuiScreen;
import tk.tubbygames.tubbycraft.utils.TubbyInputListner;
import tk.tubbygames.tubbycraft.utils.Vector2;
import tk.tubbygames.tubbycraft.world.TileManager;

import java.io.IOException;
import java.util.Random;

public class TubbyCraft extends ApplicationAdapter {
	private OrthographicCamera cam;
	public Vector2 Size;
	public static AssetManager aManager;
	public static float PlayerSpeed = 8f;
	public static Random rnd;
	public static SpriteBatch batch;
	public static BitmapFont font;

	public static GuiScreen screen;

	static GlyphLayout layout;
	boolean isLoading = true;
	boolean firstLoadFrame = true;

	@Override
	public void create () {
		screen = null;
		Size = new Vector2(1920, 1080);
		batch = new SpriteBatch();
		aManager = new AssetManager();
		font = new BitmapFont();
		layout = new GlyphLayout();
		rnd = new Random();

		cam = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		cam.setToOrtho(false,Size.X/2, Size.Y/2);
		cam.position.set(Size.X,Size.Y,0);

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		aManager.finishLoading();
		aManager.update();
		aManager.finishLoading();
		TileManager.GenerateRandomMap();
		Inventory.Stacks.add(new ItemStack(new ItemWoodenPickaxe()));
		Inventory.Stacks.add(new ItemStack(new ItemOakPlanks(), 64));
		Inventory.Stacks.add(new ItemStack(new ItemCobble(), 64));

		Gdx.input.setInputProcessor(new TubbyInputListner());
		ConsoleManager.InitCommands();
	}

	@Override
	public void resize(int width, int height) {
		cam = new OrthographicCamera(width, height);
		cam.update();
		cam.translate(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
		batch.setProjectionMatrix(cam.combined);
	}

	@Override
	public void render () {
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		float dt = Gdx.graphics.getDeltaTime();
		try {
			if(screen == null)
				HandleInput(dt);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		ScreenUtils.clear(121/255f, 166/255f, 255/255f, 1);
		batch.begin();
		TileManager.DrawToScreen(batch);
		Inventory.DrawInventory(batch);
		Inventory.UpdateItem(batch);
		if(screen != null)
			screen.onRender(batch);

		MouseManager.DrawCrosshair(batch);

		font.draw(batch, new String(String.valueOf(Gdx.graphics.getFramesPerSecond())), 0, 22);
		font.draw(batch, "Dev Build ;)", 0, 11);
		batch.end();
	}
	private void HandleInput(float dt) throws IOException {

		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1))
			Inventory.SelectedSlot = 0;
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2))
			Inventory.SelectedSlot = 1;
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3))
			Inventory.SelectedSlot = 2;
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_4))
			Inventory.SelectedSlot = 3;
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_5))
			Inventory.SelectedSlot = 4;
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_6))
			Inventory.SelectedSlot = 5;
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_7))
			Inventory.SelectedSlot = 6;
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_8))
			Inventory.SelectedSlot = 7;
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_9))
			Inventory.SelectedSlot = 8;

		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			screen = new GUiMainMenu();
		}
		if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
			MouseManager.OnClick();
		}
		if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
			if(Inventory.GetCurrentItem() != null)
				Inventory.GetCurrentItem().ItemUse();
		}

		if(Gdx.input.isKeyPressed(Input.Keys.UP))
			Camera.pos.Y-=PlayerSpeed*dt;
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
			Camera.pos.Y+=PlayerSpeed*dt;
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
			Camera.pos.X+=PlayerSpeed*dt;
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			Camera.pos.X-=PlayerSpeed*dt;

		if(Gdx.input.isKeyPressed(Input.Keys.W))
			Player.pos.Y+=PlayerSpeed*dt;
		if(Gdx.input.isKeyPressed(Input.Keys.S))
			Player.pos.Y-=PlayerSpeed*dt;
		if(Gdx.input.isKeyPressed(Input.Keys.A))
			Player.pos.X-=PlayerSpeed*dt;
		if(Gdx.input.isKeyPressed(Input.Keys.D))
			Player.pos.X+=PlayerSpeed*dt;


		if(Gdx.input.isKeyJustPressed(Input.Keys.E))
			TileManager.SetTileSize(GameSettings.TileSize+5f);

		if(Gdx.input.isKeyJustPressed(Input.Keys.Q))
			TileManager.SetTileSize(GameSettings.TileSize-5f);
		if(Gdx.input.isKeyJustPressed(Input.Keys.R))
			System.out.println("Yes");


		if(Player.pos.X < 1)
			Player.pos.X = 1;
		if(Player.pos.Y < 1)
			Player.pos.Y = 1;
		if(Player.pos.X > TileManager.ChunkMap.length)
			Player.pos.X = TileManager.ChunkMap.length;
		if(Player.pos.Y > TileManager.ChunkMap[0].length)
			Player.pos.Y = TileManager.ChunkMap[0].length;
	}
	public static void DrawCenteredString(SpriteBatch batch, String str, BitmapFont font)
	{
		font.draw(batch, str, (Gdx.graphics.getWidth()/2f) - (GetStringSize(str, font).X/2), (Gdx.graphics.getHeight()/2f) + (GetStringSize(str, font).Y/2));
	}
	public static Vector2 GetStringSize(String str, BitmapFont font)
	{
		layout.setText(font, str);
		return new Vector2(layout.width, layout.height);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
