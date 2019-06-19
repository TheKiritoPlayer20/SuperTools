/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.main;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Utils {

    public static void setNames(Object obj, String name){
        if(obj instanceof Block) {
            Block block = (Block) obj;
            block.setUnlocalizedName(name);
            block.setRegistryName(name);
        } else if (obj instanceof Item) {
            Item item = (Item) obj;
            item.setUnlocalizedName(name);
            item.setRegistryName(name);
        } else {
            throw new IllegalArgumentException("Item or Block required");
        }

    }
}
