import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { RootState } from "../../app/store";

export interface EndGameResult {
  winnerId: number;
  loserId: number;
  draw: boolean;
}

export interface GameStats {
  win: number;
  draw: number;
  lose: number;
}

export interface ProfileItem {
  id: number;
  name: string;
  stats: GameStats;
}

export interface ProfileState {
  profileList: Array<ProfileItem>;
  nextId: number;
}

const initialState: ProfileState = {
  profileList: [],
  nextId: 1,
};

// helper function
export const getById = (list: Array<ProfileItem>, id: number) =>
  list.find((profile) => profile.id === id);

// selectors
export const getProfileList = (state: RootState) => state.profile.profileList;

export const profileSlice = createSlice({
  name: "profile",
  initialState,
  reducers: {
    endGameFinish: (state, action: PayloadAction<EndGameResult>) => {
      let winner = getById(state.profileList, action.payload.winnerId);
      let loser = getById(state.profileList, action.payload.loserId);
      if (winner) {
        action.payload.draw ? winner.stats.draw++ : winner.stats.win++;
      }
      if (loser) {
        action.payload.draw ? loser.stats.draw++ : loser.stats.lose++;
      }
    },
    createProfile: (state, action: PayloadAction<ProfileItem>) => {
      state.profileList.push({ ...action.payload, id: state.nextId++ });
    },
    deleteProfile: (state, action: PayloadAction<number>) => {
      state.profileList = state.profileList.filter(
        (profile) => profile.id !== action.payload
      );
    },
  },
});

export const { endGameFinish, createProfile, deleteProfile } =
  profileSlice.actions;

export default profileSlice.reducer;
