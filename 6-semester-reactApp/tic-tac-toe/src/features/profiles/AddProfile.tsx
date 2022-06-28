import { useState } from "react";
import { Button, Form, Modal } from "react-bootstrap";
import { useForm } from "react-hook-form";
import { useAppDispatch } from "../../app/hooks";
import { createProfile, GameStats, ProfileItem } from "./profileSlice";

export interface AddProfileProps {
  show: boolean;
  onHide: () => void;
  existingProfiles: Array<ProfileItem>;
}

const emptyStats: GameStats = {
  win: 0,
  draw: 0,
  lose: 0,
};

const CLOSE = "Close";
const SAVE = "Save";
const HEADER = "Add profile";
const NAME = "Name";
const NAME_REQUIRED = "Name is required";
const PROFILE_NAME_EXISTS = "Profile name already exists";

export default function AddProfile(props: AddProfileProps) {
  const [profileName, setProfileName] = useState("");
  const dispatch = useAppDispatch();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const submitForm = (data: any) => {
    dispatch(createProfile({ name: profileName, stats: emptyStats }));
    props.onHide();
  };

  return (
    <Modal centered show={props.show} onHide={props.onHide} backdrop="static">
      <Modal.Header closeButton>
        <Modal.Title>{HEADER}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form id="newProfileForm" onSubmit={handleSubmit(submitForm)}>
          <Form.Label htmlFor="newProfileName">{NAME}</Form.Label>
          <Form.Control
            value={profileName}
            {...register("newProfileName", {
              required: NAME_REQUIRED,
              onChange: (x: any) => setProfileName(x.target.value),
              validate: {
                exists: (value: string) =>
                  !props.existingProfiles.find(
                    (profile) => profile.name === value
                  ) || PROFILE_NAME_EXISTS,
              },
            })}
          ></Form.Control>
          {errors.newProfileName && (
            <span className="error"> {errors.newProfileName.message} </span>
          )}
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={props.onHide}>
          {CLOSE}
        </Button>
        <Button variant="primary" type="submit" form="newProfileForm">
          {SAVE}
        </Button>
      </Modal.Footer>
    </Modal>
  );
}
