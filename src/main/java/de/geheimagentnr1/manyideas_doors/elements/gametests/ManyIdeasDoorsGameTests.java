package de.geheimagentnr1.manyideas_doors.elements.gametests;

import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.neoforged.neoforge.gametest.GameTestHolder;


@GameTestHolder( "manyideas_doors" )
public class ManyIdeasDoorsGameTests {

    @GameTest( templateNamespace = "neoforge", template = "floor_3x3x3" )
    public static void modLoadsSuccessfully( GameTestHelper helper ) {

        helper.succeed();
    }
}
