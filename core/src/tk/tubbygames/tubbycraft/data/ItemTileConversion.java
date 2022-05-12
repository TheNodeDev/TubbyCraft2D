package tk.tubbygames.tubbycraft.data;

import tk.tubbygames.tubbycraft.Items.*;

import java.util.HashMap;
import java.util.Map;

public class ItemTileConversion {
    public static Map<String, Item> itemMap;
    static {
        itemMap = new HashMap<>();
        itemMap.put(new ItemCobble().assignedTile.Texture       , new ItemCobble()       );
        itemMap.put(new ItemGrass().assignedTile.Texture        , new ItemGrass()        );
        itemMap.put(new ItemAcaciaPlanks().assignedTile.Texture , new ItemAcaciaPlanks() );
        itemMap.put(new ItemBirchPlanks().assignedTile.Texture  , new ItemBirchPlanks()  );
        itemMap.put(new ItemDarkOakPlanks().assignedTile.Texture, new ItemDarkOakPlanks());
        itemMap.put(new ItemJunglePlanks().assignedTile.Texture , new ItemJunglePlanks() );
        itemMap.put(new ItemOakPlanks().assignedTile.Texture    , new ItemOakPlanks()    );
        itemMap.put(new ItemStoneBrick().assignedTile.Texture   , new ItemStoneBrick()   );
    }
}
