import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { ProfileItem } from "./profileSlice";
import undoable, { includeAction } from 'redux-undo';

const clearBoard = (height: number, width: number) =>
  [...Array(Number(height))].map((_) => [...Array(Number(width))]);

export interface NewGame {
    height: number;
    width: number;
    players: ProfileItem[];
}

export enum GameProgressStatus {
  NOT_STARTED,
  IN_PROGRESS,
  FINISHED
}

export enum Symbol {
  X = 'X',
  O = 'O'
}

export interface Player extends ProfileItem {
  symbol: Symbol
}

interface PlayerMovePayload {
  x: number;
  y: number;
}

interface EndGamePayload {
  winner?: Player;
}

export interface GameState {
    player1: Player | null,
    player2: Player | null
    board: Symbol[][];
    activePlayer: Player | null;
    progressStatus: GameProgressStatus;
    totalMoves: number;
    winner: Player | null;
}

  const initialState: GameState = {
    player1: null,
    player2: null,
    board: clearBoard(3,3),
    activePlayer: null,
    totalMoves: 0,
    progressStatus: GameProgressStatus.NOT_STARTED,
    winner: null,
}

export const currentGameSlice = createSlice({
    name: "GameState",
    initialState,
    reducers: {
      newGameStart: (state, action: PayloadAction<NewGame>) => {
        state.board = clearBoard(action.payload.height,action.payload.width);
        state.totalMoves = 0;
        state.player1 = { ...action.payload.players[0], symbol: Symbol.X };
        state.player2 ={ ...action.payload.players[1], symbol: Symbol.O };
        state.activePlayer = state.player1;
        state.progressStatus = GameProgressStatus.IN_PROGRESS;
      },
      switchAndRestart: (state) => {
        state.board = clearBoard(state.board.length, state.board[0].length);
        state.totalMoves = 0;
        const player1 = state.player1;
        state.player1 = state.player2;
        state.player2 = player1;
        state.activePlayer = state.player1;
        state.progressStatus = GameProgressStatus.IN_PROGRESS;
      },
      addMove: (state, action: PayloadAction<PlayerMovePayload>) => {
        state.totalMoves++;
        const payload = action.payload
        state.board[payload.y][payload.x] = state.activePlayer!.symbol;
      },
      switchActivePlayer: (state) => {
        state.activePlayer = state.activePlayer!.symbol === state.player1!.symbol ? state.player2 : state.player1;
      },
      endGame: (state, action: PayloadAction<EndGamePayload>) => {
        state.progressStatus = GameProgressStatus.FINISHED;
        if (action.payload.winner) {
          state.winner = action.payload.winner;
        }
      },
    }
});

export const { newGameStart, switchAndRestart, addMove, endGame, switchActivePlayer } =
currentGameSlice.actions;

export default undoable(currentGameSlice.reducer,
  {
    groupBy: (action, currentState, previousHistory) => {
      if (action.type === addMove.type) {
        return currentState.activePlayer!.id;
      }
      return previousHistory.present.activePlayer!.id

    },
    filter: includeAction([addMove.type, switchActivePlayer.type])
  });
