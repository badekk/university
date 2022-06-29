import React from "react";
import { Col, Container, Image, Row } from "react-bootstrap";
import logo from "../assets/logo.jpeg";

import { ROUTES } from "../Routes";
import LinkButton from "./LinkButton";

import "./Header.scss";
import { useSelector } from 'react-redux';
import { RootState } from '../app/store';
import { GameProgressStatus } from '../features/store/currentGameSlice';

const NEW_GAME = "NEW GAME";
const CURRENT_GAME = "CONTINUE GAME";
const PROFILES = "PROFILES";
const HIGH_SCORES = "HIGH SCORES";

export default function Header() {

  const gameStatus = useSelector((state: RootState) =>
    state.currentGame.present.progressStatus)

  return (
    <Container className="header">
      <Row>
        <Col className="justify-content-center col-img">
          <Image fluid src={ logo } roundedCircle/>
        </Col>
      </Row>
      <Row className="nav-button-row">
        <LinkButton linkTo={ ROUTES.MAIN } label={ NEW_GAME }/>
        { gameStatus !== GameProgressStatus.NOT_STARTED ?
          <LinkButton linkTo={ ROUTES.GAME } label={ CURRENT_GAME }/>
          : null }
        <LinkButton linkTo={ ROUTES.PROFILES } label={ PROFILES }/>
        <LinkButton linkTo={ ROUTES.HIGH_SCORES } label={ HIGH_SCORES }/>
      </Row>
    </Container>
  );
}
