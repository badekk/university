import React from "react";
import { Container, Image, Row, Table } from "react-bootstrap";
import { useLocation, useParams } from "react-router-dom";
import { ProfileItem } from "../store/profileSlice";
import logo from "../../assets/logo.jpeg";

export interface SingleProfileState {
  profile: ProfileItem;
}

const WINS = "Wins";
const DRAWS = "Draws";
const LOSES = "Loses";

export default function Profile() {
  const { profileId } = useParams();
  const profileState = useLocation().state as SingleProfileState;
  const profile = profileState.profile;

  return (
    <Container className="profile-section">
      <Row>
        <Image fluid src={logo} roundedCircle />
      </Row>
      <Row className="name-row">
        <h2>{profile.name}</h2>
      </Row>
      <Row className="stats-row">
        <Table
          striped
          bordered
          hover
          size="sm"
          variant="dark"
          className="profile-table"
        >
          <tbody>
            <tr>
              <th>{WINS}</th>
              <td>{profile.stats.win}</td>
            </tr>
            <tr>
              <th>{DRAWS}</th>
              <td>{profile.stats.draw}</td>
            </tr>
            <tr>
              <th>{LOSES}</th>
              <td>{profile.stats.lose}</td>
            </tr>
          </tbody>
        </Table>
      </Row>
    </Container>
  );
}
