import React from "react";
import { Button, Container, Table } from "react-bootstrap";
import { useSelector } from "react-redux";

import { useAppDispatch } from "../../app/hooks";
import { RootState } from "../../app/store";
import {
  addMove,
  endGame,
  GameProgressStatus,
  switchActivePlayer,
  switchAndRestart
} from "../store/currentGameSlice";

import { Direction, DIRECTIONS } from "./Directions";
import "./Game.scss";
import { ActionCreators } from 'redux-undo';
import { endGameFinish } from '../store/profileSlice';

const PLAY_AGAIN = "Play again";

export default function Game() {
  const currentGame = useSelector((state: RootState) => state.currentGame.present)
  const dispatch = useAppDispatch();
  const availableMoves = useSelector((state: RootState) => {
    return state.currentGame.present.board.length * state.currentGame.present.board[ 0 ].length;
  })

  const canUndo: boolean = useSelector((state: RootState) => state.currentGame.past.length > 0)

  const WIN_COUNT = 3;

  const board = currentGame.board;

  const clickButton = (i: number, j: number) => {
    const otherPlayer = currentGame.player1!.id === currentGame.activePlayer!.id ?
      currentGame.player2 : currentGame.player1;
    if (currentGame.board[ i ][ j ]) {
      return
    }
    dispatch(addMove({ x: j, y: i }))

    const didWin = checkForWin(i, j);
    if (didWin) {
      dispatch(endGame({ winner: currentGame.activePlayer! }))
      dispatch(endGameFinish({
        winnerId: currentGame.activePlayer!.id,
        loserId: otherPlayer!.id,
        draw: false
      }))
      setTimeout(() => alert(`${ currentGame.activePlayer?.name } has won !`), 0);
      return;
    }

    if (currentGame.totalMoves + 1 === availableMoves) {
      dispatch(endGame({}));
      dispatch(endGameFinish({
        winnerId: currentGame.activePlayer!.id,
        loserId: otherPlayer!.id,
        draw: true
      }))
      alert("draw");
      return;
    }
    dispatch(switchActivePlayer());
  };

  const playAgain = () => {
    dispatch(switchAndRestart());
    dispatch(ActionCreators.clearHistory());
  };

  const checkForWin = (i: number, j: number) => {
    const count = Math.max(
      countPath(DIRECTIONS.UP_LEFT, DIRECTIONS.DOWN_RIGHT, i, j),
      countPath(DIRECTIONS.UP, DIRECTIONS.DOWN, i, j),
      countPath(DIRECTIONS.UP_RIGHT, DIRECTIONS.DOWN_LEFT, i, j),
      countPath(DIRECTIONS.LEFT, DIRECTIONS.RIGHT, i, j)
    );
    return count >= WIN_COUNT;
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
    while (board?.[ row ]?.[ column ] === currentGame.activePlayer!.symbol) {
      row += dir.y;
      column += dir.x;
      count++;
    }
    return count;
  };

  return (
    <Container className="content">
      <h2>{ currentGame.player1!.name } ({ currentGame.player1!.symbol })
        vs { currentGame.player2!.name } ({ currentGame.player2!.symbol })</h2>
      { currentGame.progressStatus === GameProgressStatus.IN_PROGRESS ?
        <h3> Now is <span className="activePlayer">{ currentGame.activePlayer?.name }</span> turn !
        </h3>
        : null }
      <Container className="board">
        <Table className="board-table" bordered>
          <tbody>
          { currentGame.board.map((row, i) => (
            <tr>
              { row.map((cell, j) => (
                <td>
                  <Button
                    className="board-cell"
                    key={ `y${ i }_x${ j }` }
                    disabled={ currentGame.progressStatus !== GameProgressStatus.IN_PROGRESS }
                    onClick={ (x: any) => clickButton(i, j) }
                  >
                    { board[ i ][ j ] }
                  </Button>
                </td>
              )) }
            </tr>
          )) }
          </tbody>
        </Table>
        { currentGame.progressStatus !== GameProgressStatus.IN_PROGRESS && (
          <Button variant="success" onClick={ playAgain }>
            { PLAY_AGAIN }
          </Button>
        ) }
        { canUndo ?
          <Button variant="info" onClick={ () => {
            dispatch(ActionCreators.undo());
          } }>Undo</Button>
          : null }
      </Container>
    </Container>
  );
}
