package com.zhang.factory.abs2;

import com.zhang.factory.abs2.elf.ElfKing;
import com.zhang.factory.abs2.elf.ElfKingdomFactory;
import com.zhang.factory.abs2.orc.OrcKing;
import com.zhang.factory.abs2.orc.OrcKingdomFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class AbstractFactoryTest {

    private App app = new App();
    private KingdomFactory elfFactory;
    private KingdomFactory orcFactory;

    @Before
    public void setUp() {
        elfFactory = new ElfKingdomFactory();
        orcFactory = new OrcKingdomFactory();
    }

    @Test
    public void king() {
        final King elfKing = app.getKing(elfFactory);
        assertTrue(elfKing instanceof ElfKing);
        assertEquals(ElfKing.NAME, elfKing.getName());
        final King orcKing = app.getKing(orcFactory);
        assertTrue(orcKing instanceof OrcKing);
        assertEquals(OrcKing.NAME, orcKing.getName());
    }

}
