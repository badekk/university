import React, { useState } from "react";
import { Button, Col, Container, Form, Image, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import { useDispatch } from "react-redux";

import board from "./newgame_board.jpeg";
import { ROUTES } from "../../Routes";
import "./NewGame.scss";
import { getProfileList } from "../storage/profileSlice";
import { useAppSelector } from "../../app/hooks";
import { newGameStart } from "../storage/currentGameSlice";

const SELECT_PROFILE = "Select profile...";
const PROFILE_REQUIRED = "Profile is required";
const KEEP_PROPORTIONS = "Keep proportions";
const START_GAME = "Start game";
const FIRST_PLAYER = "First Player";
const SECOND_PLAYER = "Second Player";

const SLIDER_OPTIONS = {
  min: 3,
  max: 7,
};

const sliderValue = (val: number) => {
  return { value: val };
};

const slider = (props: any) => (
  <Form.Range {...props} min={SLIDER_OPTIONS.min} max={SLIDER_OPTIONS.max} />
);

const profileError = (id: any) =>
  id && <span className="error"> {id.message} </span>;

export default function NewGame() {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const profileList = useAppSelector(getProfileList);

  const [width, setWidth] = useState(SLIDER_OPTIONS.min);
  const [height, setHeight] = useState(SLIDER_OPTIONS.min);
  const [lockProportions, setLockProportions] = useState(true);
  const [firstPlayer, setFirstPlayer] = useState("");
  const [secondPlayer, setSecondPlayer] = useState("");

  const EMPTY_PROFILE = <option value="">{SELECT_PROFILE}</option>;
  const getProfiles = (exclude: string) => [
    EMPTY_PROFILE,
    profileList
      .filter((profile) => profile.id !== Number(exclude))
      .map((profile) => <option value={profile.id}>{profile.name}</option>),
  ];

  const lockSquareProportions = (val: boolean) => {
    if (val) {
      let v = Math.min(width, height);
      setHeight(v);
      setWidth(v);
    }
    setLockProportions(val);
  };

  const changeWidth = (val: number) => {
    if (lockProportions) {
      setHeight(val);
    }
    setWidth(val);
  };

  const changeHeight = (val: number) => {
    if (lockProportions) {
      setWidth(val);
    }
    setHeight(val);
  };

  const submitForm = (data: any) => {
    const players = profileList.filter( x => [firstPlayer, secondPlayer].includes(x.id.toString()));
    dispatch(newGameStart({height,width, players: players }));
    navigate(ROUTES.GAME, {
      state: {
        width: width,
        height: height,
        availableMoves: width * height,
        winCount: 3,
        playerOne: Number(firstPlayer),
        playerTwo: Number(secondPlayer),
      },
    });
  };

  return (
    <Container className="content">
      <Form onSubmit={handleSubmit(submitForm)}>
        <Row>
          <Form.Group as={Col} controlId="firstPlayerProfileId">
            <Form.Label>{FIRST_PLAYER}</Form.Label>
            <Form.Select
              value={firstPlayer}
              {...register("firstPlayerProfile", {
                required: PROFILE_REQUIRED,
                onChange: (x: any) => setFirstPlayer(x.target.value),
              })}
            >
              {getProfiles(secondPlayer)}
            </Form.Select>
            {profileError(errors.firstPlayerProfile)}
          </Form.Group>
          <Form.Group as={Col} controlId="secondPlayerProfileId">
            <Form.Label>{SECOND_PLAYER}</Form.Label>
            <Form.Select
              value={secondPlayer}
              {...register("secondPlayerProfile", {
                required: PROFILE_REQUIRED,
                onChange: (x: any) => setSecondPlayer(x.target.value),
              })}
            >
              {getProfiles(firstPlayer)}
            </Form.Select>
            {profileError(errors.secondPlayerProfile)}
          </Form.Group>
        </Row>

        <Row className="justify-content-md-center board-row">
          <Col sm={4} className="switch-col">
            <Form.Check
              type="switch"
              id="scale-switch"
              label={KEEP_PROPORTIONS}
              checked={lockProportions}
              onChange={(x: any) => lockSquareProportions(x.target.checked)}
            />
          </Col>
        </Row>

        <Row className="justify-content-md-center">
          <Col sm={3} className="image-col">
            <Image fluid src={board} />
          </Col>
          <Form.Group as={Col} sm={1} controlId="boardHeightId">
            {slider({
              ...sliderValue(height),
              className: "slider-vertical",
              onChange: (x: any) => changeHeight(x.target.value),
            })}
            <Form.Label className="board-label-vertical">{height}</Form.Label>
          </Form.Group>
        </Row>
        <Row className="justify-content-md-center align-center">
          <Form.Group as={Col} sm={4} controlId="boardWidthId">
            {slider({
              ...sliderValue(width),
              className: "slider",
              onChange: (x: any) => changeWidth(x.target.value),
            })}
            <br />
            <Form.Label className="board-label">{width}</Form.Label>
          </Form.Group>
        </Row>

        <Row className="justify-content-md-center">
          <Col sm={4}>
            <Button type="submit" variant="success">
              {START_GAME}
            </Button>
          </Col>
        </Row>
      </Form>
    </Container>
  );
}
