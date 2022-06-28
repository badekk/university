import React from "react";
import { createRoot } from "react-dom/client";
import { Provider } from "react-redux";
import { store } from "./app/store";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import { ROUTES } from "./Routes";

import Header from "./header/Header";
import NewGame from "./features/newgame/NewGame";
import HighScore from "./features/highscore/HighScore";
import Profiles from "./features/profiles/Profiles";
import Profile from "./features/profiles/Profile";
import Game from "./features/game/Game";

import "./index.scss";

const container = document.getElementById("root")!;
const root = createRoot(container);

root.render(
  <React.StrictMode>
    <Provider store={store}>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path={ROUTES.MAIN} element={<NewGame />} />
          <Route path={ROUTES.GAME} element={<Game />} />
          <Route path={ROUTES.HIGH_SCORES} element={<HighScore />} />
          <Route path={ROUTES.PROFILES} element={<Profiles />}>
            <Route path={ROUTES.PROFILE} element={<Profile />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </Provider>
  </React.StrictMode>
);
