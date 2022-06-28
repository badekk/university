import { ProfileItem } from "../storage/profileSlice";
import { Row, Table } from "react-bootstrap";
import { useAppSelector } from "../../app/hooks";
import { getProfileList } from "../storage/profileSlice";

const NAME = "Name";
const COUNT = "Count";

const printLabel = (val: string) => <span className="table-label">{val}</span>;

export interface ScoreTableProps {
  supplier: (profile: ProfileItem) => number;
  label: string;
}

export default function ScoreTable(props: ScoreTableProps) {
  const profileList = useAppSelector(getProfileList);

  return (
    <Row>
      {printLabel(props.label)}
      <Table striped bordered hover size="sm" variant="dark">
        <thead>
          <tr>
            <th>{NAME}</th>
            <th>{COUNT}</th>
          </tr>
        </thead>
        <tbody>
          {[...profileList]
            .sort((a, b) => {
              let c = props.supplier(b) - props.supplier(a);
              return c === 0 ? a.name.localeCompare(b.name) : c;
            })
            .map((profile) => (
              <tr>
                <td>{profile.name}</td>
                <td>{props.supplier(profile)}</td>
              </tr>
            ))}
        </tbody>
      </Table>
    </Row>
  );
}
