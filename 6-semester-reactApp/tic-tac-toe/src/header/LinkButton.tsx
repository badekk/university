import { Button, Col } from "react-bootstrap";
import { Link } from "react-router-dom";

export interface LinkButtonProps {
  linkTo: string;
  label: string;
}

export default function LinkButton(props: LinkButtonProps) {
  return (
    <Col>
      <Link to={props.linkTo}>
        <Button className="nav-button" variant="primary">
          {props.label}
        </Button>
      </Link>
    </Col>
  );
}
