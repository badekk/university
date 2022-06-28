import React from "react";
import { Col, Container, Row, Image } from "react-bootstrap";
import logo from "../assets/logo.jpeg";

import { ROUTES } from "../Routes";
import LinkButton from "./LinkButton";

import "./Header.scss";

const NEW_GAME = "NEW GAME";
const PROFILES = "PROFILES";
const HIGH_SCORES = "HIGH SCORES";

export default function Header() {
  return (
    <Container className="header">
      <Row>
        <Col className="justify-content-center col-img">
          <Image fluid src={logo} roundedCircle />
        </Col>
      </Row>
      <Row className="nav-button-row">
        <LinkButton linkTo={ROUTES.MAIN} label={NEW_GAME} />
        <LinkButton linkTo={ROUTES.PROFILES} label={PROFILES} />
        <LinkButton linkTo={ROUTES.HIGH_SCORES} label={HIGH_SCORES} />
      </Row>
    </Container>
  );
}
