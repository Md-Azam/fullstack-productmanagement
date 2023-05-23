import React, { useState, useEffect, Fragment } from "react";
import { BASE_URL } from "../urls/baseUrl";
import { Col, Row, Card, Container, Button } from "react-bootstrap";
import { GetAllVideos, DeletePostService } from "../urls/videoService";
import useCollapse from "react-collapsed";
import { Link, useParams } from "react-router-dom";
import { toast } from "react-toastify";
import axios from "axios";

const ViewPost = () => {
  const [isExpanded, setExpanded] = useState(false);
  const { getCollapseProps, getToggleProps } = useCollapse({ isExpanded });

  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(false);
  //Gatting All videos .

  const getAllVideos = async () => {
    try {
      const response = await GetAllVideos();
      setPosts(response.data);
      console.log(response.data);
      console.log(response);
      setLoading(true);
    } catch (error) {
      alert(error.message);
    }
  };
  useEffect(() => {
    getAllVideos();
  }, []);

  const handleDelete = (id) => {
    console.log(id);
    if (window.confirm("Are you sure wanted to delete")) {
      DeletePostService(id);
    }
  }

  return (
    <div>
      <Container className="mb-2 p-3">
        <Button className="p-4" variant="primary" size="lg" href="/">
          Back to add Product
        </Button>

      </Container>
      <Container className="mb-2 p-3"></Container>
      <br />
      <Container>
        <Card>
          <Row>
            {loading &&
              posts.map((post) => (
                <Col sm={12} md={6} lg={3} key={post.id}>
                  <Card className="my-3 p-3 rounded h-90">
                    <Card.Header></Card.Header>
                    <Card.Body>


                      <Card.Title>Product name: {post.name}</Card.Title>
                      <Card.Subtitle>
                        <Card.Text>
                          <strong style={{ color: "blue" }}>Product Type: {post.type}</strong>
                        </Card.Text>

                        <Card.Text>
                          <strong style={{ color: "green" }}>Product place: {post.place}</strong>
                        </Card.Text>

                        <Card.Text>
                          <strong style={{ color: "red" }}>Product warranty: {post.warranty}</strong>
                        </Card.Text>
                      </Card.Subtitle>


                      <div>
                        <Button color="primary"
                          style={{ marginRight: "5px" }}
                          onClick={() => handleDelete(post.id)}
                        >Delete</Button>



                        <Link
                          className={"btn btn-primary mx-2"}
                          to={`/viewone/${post.id}`}
                        >
                          View
                        </Link>

                      </div>
                    </Card.Body>
                  </Card>
                </Col>
              ))}
          </Row>
        </Card>
      </Container>
    </div>
  );
};

export default ViewPost;
