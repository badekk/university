import React from "react";
import { Container } from "react-bootstrap";
import { ProfileItem } from "../profiles/profileSlice";

import "./HighScore.scss";
import ScoreTable from "./ScoreTable";

const WINNERS = "Biggest winners";
const LOSERS = "Biggest losers";
const DRAWERS = "Can't figure this game out";

export default function HighScore() {
  const getWins = (profile: ProfileItem) => profile.stats.win;
  const getLoses = (profile: ProfileItem) => profile.stats.lose;
  const getDraws = (profile: ProfileItem) => profile.stats.draw;

  return (
    <Container className="content highscore-container">
      <ScoreTable label={WINNERS} supplier={getWins} />
      <ScoreTable label={LOSERS} supplier={getLoses} />
      <ScoreTable label={DRAWERS} supplier={getDraws} />
    </Container>
  );
}
