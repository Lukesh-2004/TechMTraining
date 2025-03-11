import React, { useState } from "react";
import { Form, Button, Alert } from "react-bootstrap";

interface CourseFormProps {
  refreshCourses: () => void;
}

const CourseForm: React.FC<CourseFormProps> = ({ refreshCourses }) => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [showAlert, setShowAlert] = useState(false);
  const [alertMessage, setAlertMessage] = useState("");
  const [alertVariant, setAlertVariant] = useState<"success" | "danger">("success");

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!title || !description) {
      setAlertMessage("Please fill in all fields.");
      setAlertVariant("danger");
      setShowAlert(true);
      return;
    }

    try {
      await fetch("http://localhost:4500/courses", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ title, description }),
      });

      setTitle("");
      setDescription("");
      refreshCourses();
      setAlertMessage("Course added successfully!");
      setAlertVariant("success");
      setShowAlert(true);
    } catch (error) {
      console.error("Error adding course:", error);
      setAlertMessage("Failed to add course. Please try again.");
      setAlertVariant("danger");
      setShowAlert(true);
    }
  };

  return (
    <Form onSubmit={handleSubmit} className="p-4 border rounded bg-light shadow">
      <h3 className="text-primary">Add a Course</h3>
      {showAlert && (
        <Alert variant={alertVariant} onClose={() => setShowAlert(false)} dismissible>
          {alertMessage}
        </Alert>
      )}
      <Form.Group className="mb-3">
        <Form.Label>Course Title</Form.Label>
        <Form.Control
          type="text"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
      </Form.Group>
      <Form.Group className="mb-3">
        <Form.Label>Description</Form.Label>
        <Form.Control
          as="textarea"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
      </Form.Group>
      <Button variant="primary" type="submit" className="w-100">
        Submit
      </Button>
    </Form>
  );
};

export default CourseForm;