import React, { useState } from "react";
import { Button, Container, Table } from "react-bootstrap";
import { useSelector } from "react-redux";
import { useLocation } from "react-router-dom";

import { useAppSelector, useAppDispatch } from "../../app/hooks";
import { RootState } from "../../app/store";
import { GameState } from "../storage/currentGameSlice";
import { endGameFinish } from "../storage/profileSlice";

import { Direction, DIRECTIONS } from "./Directions";
import "./Game.scss";

const PLAY_AGAIN = "Play again";

interface BoardState {
  readonly width: number;
  readonly height: number;
  readonly winCount: number;
  readonly availableMoves: number;
  readonly playerOne: number;
  readonly playerTwo: number;
}

const clearBoard = (height: number, width: number) =>
  [...Array(Number(height))].map((_) => [...Array(Number(width))]);

export default function Game() {
  const currentGame = useSelector((state:RootState) => state.currentGame)
  const boardSettings = useLocation().state as BoardState;
  const dispatch = useAppDispatch();

  const [board, setBoard] = useState(
    clearBoard(boardSettings.height, boardSettings.width)
  );
  const [sym, setSym] = useState("X");
  const [end, setEnd] = useState(false);
  const [moves, setMoves] = useState(1);

  const isDraw = () => moves === boardSettings.availableMoves;

  const endGame = (draw: boolean) => {
    const winner =
      sym === "X" ? boardSettings.playerOne : boardSettings.playerTwo;
    const loser =
      sym === "X" ? boardSettings.playerTwo : boardSettings.playerOne;
    dispatch(endGameFinish({ winnerId: winner, loserId: loser, draw: draw }));
  };

  const clickButton = (i: number, j: number) => {
    board[i][j] = sym;
    setBoard((board) => [...board]);
    setMoves(moves + 1);

    const didWin = checkForWin(i, j, sym);
    if (didWin) {
      setEnd(true);
      endGame(false);
      alert(`${sym} has won !`);
      return;
    }

    if (isDraw()) {
      setEnd(true);
      endGame(true);
      alert("draw");
      return;
    }

    const newsym = "X" === sym ? "O" : "X";
    setSym(newsym);
  };

  const playAgain = () => {
    setBoard((board) => [
      ...clearBoard(boardSettings.height, boardSettings.width),
    ]);
    setSym("X");
    setMoves(1);
    setEnd(false);
  };

  const checkForWin = (i: number, j: number, symbol: string) => {
    const count = Math.max(
      countPath(DIRECTIONS.UP_LEFT, DIRECTIONS.DOWN_RIGHT, i, j),
      countPath(DIRECTIONS.UP, DIRECTIONS.DOWN, i, j),
      countPath(DIRECTIONS.UP_RIGHT, DIRECTIONS.DOWN_LEFT, i, j),
      countPath(DIRECTIONS.LEFT, DIRECTIONS.RIGHT, i, j)
    );
    return count >= boardSettings.winCount;
  };

  const countPath = (
    dir_left: Direction,
    dir_right: Direction,
    y: number,
    x: number
  ) => {
    return (
      1 + countInDirection(dir_left, y, x) + countInDirection(dir_right, y, x)
    );
  };

  const countInDirection = (dir: Direction, y: number, x: number) => {
    let row = y + dir.y;
    let column = x + dir.x;
    let count = 0;
    while (board?.[row]?.[column] === sym) {
      row += dir.y;
      column += dir.x;
      count++;
    }
    return count;
  };

  return (
    <Container className="content">
      <h2>{currentGame.players[0].name} vs {currentGame.players[1].name}</h2>
      <h3> Now is {currentGame.activePlayer?.name} turn !</h3>
      <Container className="board">
        <Table className="board-table" bordered>
          <tbody>
            {board.map((row, i) => (
              <tr>
                {row.map((cell, j) => (
                  <td>
                    <Button
                      className="board-cell"
                      key={`${i}_${j}`}
                      disabled={board[i][j] || end}
                      onClick={(x: any) => clickButton(i, j)}
                    >
                      {board[i][j]}
                    </Button>
                  </td>
                ))}
              </tr>
            ))}
          </tbody>
        </Table>
        {end && (
          <Button variant="success" onClick={playAgain}>
            {PLAY_AGAIN}
          </Button>
        )}
      </Container>
    </Container>
  );
}
