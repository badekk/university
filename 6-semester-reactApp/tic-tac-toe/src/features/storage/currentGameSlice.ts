import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { clear } from "console";
import { RootState } from "../../app/store";
import { ProfileItem } from "./profileSlice";

const clearBoard = (height: number, width: number) =>
  [...Array(Number(height))].map((_) => [...Array(Number(width))]);

export interface NewGame {
    height: number;
    width: number;
    players: ProfileItem[];
}

export interface BoardState {
    board: string[][];
  }

export interface GameState {
    players: Array<ProfileItem>;
    board: string[][];
    activePlayer: ProfileItem | null; 
}

  const initialState: GameState = {
    players: [],
    board: clearBoard(3,3),
    activePlayer: null
}

export const currentGameSlice = createSlice({
    name: "GameState",
    initialState,
    reducers: {
      newGameStart: (state, action: PayloadAction<NewGame>) => {
        state.board = clearBoard(action.payload.height,action.payload.width);
        state.players = action.payload.players;
        state.activePlayer = state.players[0];
      }
    }
});

export const { newGameStart } =
currentGameSlice.actions;

export default currentGameSlice.reducer;
      