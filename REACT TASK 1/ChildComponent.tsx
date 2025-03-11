import React from "react";
import { Card } from "react-bootstrap";

interface ChildProps {
  title: string;
  body: string;
}

const ChildComponent: React.FC<ChildProps> = ({ title, body }) => {
  return (
    <Card className="mb-3">
      <Card.Body>
        <Card.Title>{title}</Card.Title>
        <Card.Text>{body}</Card.Text>
      </Card.Body>
    </Card>
  );
};

export default ChildComponent;
