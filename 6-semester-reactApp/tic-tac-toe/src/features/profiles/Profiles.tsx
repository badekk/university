import React, { useState } from "react";
import { Button, Container, Row, Table } from "react-bootstrap";
import { Outlet, useNavigate } from "react-router-dom";
import { useAppDispatch, useAppSelector } from "../../app/hooks";
import AddProfile from "./AddProfile";

import "./Profiles.scss";
import { deleteProfile, getProfileList } from "../storage/profileSlice";

const NAME_HEADER = "Name";
const WIN_HEADER = "Win";
const DRAW_HEADER = "Draw";
const LOSE_HEADER = "Lose";
const ADD_PROFILE = "Add profile...";
const ACTIONS = "Actions";

export default function Profiles() {
  const navigate = useNavigate();
  const dispatch = useAppDispatch();
  const [showModal, setShowModal] = useState(false);
  const profileList = useAppSelector(getProfileList);

  const openModal = () => setShowModal(true);
  const hideModal = () => setShowModal(false);

  const del = (id: number | undefined) => id && dispatch(deleteProfile(id));

  let idx = 1;
  return (
    <Container className="content">
      <Row>
        <Button variant="dark" onClick={openModal}>
          {ADD_PROFILE}
        </Button>
        <AddProfile
          show={showModal}
          onHide={hideModal}
          existingProfiles={profileList}
        />
        <Table
          striped
          bordered
          hover
          size="sm"
          variant="dark"
          className="profile-table"
        >
          <thead>
            <tr>
              <th style={{ width: "3%" }}>{"#"}</th>
              <th style={{ width: "60%" }}>{NAME_HEADER}</th>
              <th style={{ width: "10%" }}>{WIN_HEADER}</th>
              <th style={{ width: "10%" }}>{DRAW_HEADER}</th>
              <th style={{ width: "10%" }}>{LOSE_HEADER}</th>
              <th style={{ width: "7%" }}>{ACTIONS}</th>
            </tr>
          </thead>
          <tbody>
            {profileList.map((profile) => (
              <tr>
                <td>{idx++}</td>
                <td
                  onClick={() =>
                    navigate(`${profile.id}`, { state: { profile: profile } })
                  }
                >
                  {profile.name}
                </td>
                <td>{profile.stats.win}</td>
                <td>{profile.stats.draw}</td>
                <td>{profile.stats.lose}</td>
                <td>
                  <Button variant="info" onClick={() => del(profile.id)}>
                    Delete
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </Row>
      <Row>
        <Outlet />
      </Row>
    </Container>
  );
}
