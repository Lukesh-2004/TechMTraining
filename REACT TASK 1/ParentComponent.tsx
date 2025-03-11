import axios from "axios";
import React, { useEffect, useState } from "react";
import { Alert, Card, Container } from "react-bootstrap";
import ChildComponent from "./ChildComponent";
import Form from "./Form";

interface Course {
  id: number;
  title: string;
  description: string;
}

const ParentComponent: React.FC = () => {
  const [courses, setCourses] = useState<Course[]>([]);
  const [error, setError] = useState<string | null>(null); // Add error state

  const fetchCourses = () => {
    axios
      .get<Course[]>("http://localhost:4500/courses")
      .then((response) => {
        setCourses(response.data);
        setError(null); // Clear error if data is fetched successfully
      })
      .catch((error) => {
        setError("Error fetching data: " + error.message); // Set error message
      });
  };

  useEffect(() => {
    fetchCourses();
  }, []);

  return (
    <Container className="mt-4">
      <h2>Available Courses</h2>
      
      {/* Display error message if there is an error */}
      {error && <Alert variant="danger">{error}</Alert>}
      
      {/* Loading or courses list */}
      {courses.length === 0 && !error ? (
        <p>Loading courses...</p>
      ) : (
        courses.map((course) => (
          <Card key={course.id} className="mb-3">
            <Card.Body>
              <ChildComponent
                title={course.title}
                body={course.description}
              />
            </Card.Body>
          </Card>
        ))
      )}

      <Form refreshCourses={fetchCourses} />
    </Container>
  );
};

export default ParentComponent;
