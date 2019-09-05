package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
      if (!isDiagonal(source, dest)) {
          throw new IllegalStateException(
                  String.format("Could not move by diagonal from %s to %s", source, dest)
          );
      }
      int deltaX = dest.x - source.x;
      int deltaY = dest.y - source.y;
      int size = Math.abs(deltaX);
      deltaX = deltaX > 0 ? 1 : -1;
      deltaY = deltaY > 0 ? 1 : -1;
      Cell[] steps = new Cell[size];
      for (int index = 0; index < size; index++) {
              for (Cell value : Cell.values()) {
                  if (value.x == source.x + (index + 1) * deltaX && value.y == source.y + (index + 1) * deltaY) {
                      steps[index] = value;
                  }
              }
      }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
       return (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
