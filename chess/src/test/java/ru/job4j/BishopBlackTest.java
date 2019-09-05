package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void checkPosition() {
        BishopBlack bishopBlack = new BishopBlack(C8);
        assertThat(bishopBlack.position(), is(C8));
    }

    @Test
    public void checkWay1() {
        BishopBlack bishopBlack1 = new BishopBlack(C1);
        Cell[] result = {D2, E3, F4, G5};
        assertThat (bishopBlack1.way(C1, G5), is (result));
    }

    @Test
    public void checkWay2() {
        BishopBlack bishopBlack1 = new BishopBlack(H1);
        Cell[] result = {G2, F3, E4, D5, C6, B7, A8};
        assertThat (bishopBlack1.way(H1, A8), is (result));
    }

    @Test
    public void checkWay3() {
        BishopBlack bishopBlack1 = new BishopBlack(H8);
        Cell[] result = {G7};
        assertThat (bishopBlack1.way(H8, G7), is (result));
    }

    @Test
    public void checkWay4() {
        BishopBlack bishopBlack = new BishopBlack(H8);
        try {
            Cell[] way = bishopBlack.way(H8, H6);
            fail("Could move by diagonal from H8 to H6");
        }
        catch (Exception e){
        }
    }

    @Test
    public void checkCopy() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Figure bishopBlackNew = bishopBlack.copy(C8);
        assertThat(bishopBlackNew.position(),(is (C8)));
    }
}
