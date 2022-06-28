export interface Direction {
  x: number;
  y: number;
}

export interface Directions {
  DOWN_LEFT: Direction;
  LEFT: Direction;
  UP_LEFT: Direction;
  UP: Direction;
  UP_RIGHT: Direction;
  RIGHT: Direction;
  DOWN_RIGHT: Direction;
  DOWN: Direction;
}

const d = (x: number, y: number) => ({ x: x, y: y });

export const DIRECTIONS: Directions = {
  DOWN_LEFT: d(-1, 1),
  LEFT: d(-1, 0),
  UP_LEFT: d(-1, -1),
  UP: d(0, -1),
  UP_RIGHT: d(1, -1),
  RIGHT: d(1, 0),
  DOWN_RIGHT: d(1, 1),
  DOWN: d(0, 1),
};
