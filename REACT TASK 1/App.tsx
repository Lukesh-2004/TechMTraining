import React, { useEffect, useState } from "react";
import Form from "./Components/Form";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

interface Course {
  id: number;
  title: string;
  description: string;
}

const App: React.FC = () => {
  const [courses, setCourses] = useState<Course[]>([]);

  const fetchCourses = async () => {
    const response = await fetch("http://localhost:4500/courses");
    const data: Course[] = await response.json();
    setCourses(data);
  };

  useEffect(() => {
    fetchCourses();
  }, []);

  return (
    <div className="app-container">
      <header className="text-center">
        <h1 className="app-title">Welcome to Your Learning Hub</h1>
        <p className="subtitle">
          Discover a variety of courses to enhance your knowledge
        </p>
      </header>

      <section className="course-section">
        <div className="row justify-content-center">
          {courses.map((course) => (
            <div key={course.id} className="col-lg-4 col-md-6 col-sm-12 mb-4">
              <div className="card course-card">
                <h4 className="card-title">{course.title}</h4>
                <p className="card-text">{course.description}</p>
              </div>
            </div>
          ))}
        </div>
      </section>

      <section className="form-section mt-5">
        <div className="form-header">
          <h2>Add a New Course</h2>
          <p>Fill in the form below to contribute a new course</p>
        </div>
        <div className="mt-3">
          <Form refreshCourses={fetchCourses} />
        </div>
      </section>
    </div>
  );
};

export default App;
