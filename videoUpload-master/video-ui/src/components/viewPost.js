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

  const [tableData, setTableData] = useState([]);

  const [byType, setByType] = useState([]);
  const [byWarranty, setByWarranty] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchNum, setSearchNum] = useState();
  const [searchByType,setSearchByType] =useState('');

  
   // Function to fetch table data from the API
   const fetchTableData = async () => {
    try {
      const response = await axios.get(BASE_URL + `/name/${searchTerm}`);
      setTableData(response.data);
      console.log(response.data);
    } catch (error) {
      console.error('Error fetching table data:', error);
    }
  };

  const fetchByType = async () => {
    try {
      const response = await axios.get(BASE_URL + `/type/${searchByType}`);
      setByType(response.data);
      console.log(response.data);
    } catch (error) {
      console.error('Error fetching table data:', error);
    }
  };

  const fetchByWarranty = async () => {
    try {
      const response = await axios.get(BASE_URL + `/isExp/${searchNum}`);
      setByWarranty(response.data);
      console.log(response.data);
    } catch (error) {
      console.error('Error fetching table data:', error);
    }
  };

  // Fetch table data when the component mounts or when the search term changes
  useEffect(() => {
    fetchByWarranty();
  }, [searchNum]);

  // Fetch table data when the component mounts or when the search term changes
  useEffect(() => {
    fetchTableData();
  }, [searchTerm]);

  // Fetch table data when the component mounts or when the search term changes
  useEffect(() => {
    fetchByType();
  }, [searchByType]);

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
        <Container>
          <h1>Search Products By Name</h1>
          <div>
      <input
        type="text"
        placeholder="Search..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />
      <table class="table">
    
        <thead margin="6px">
          <tr margin="6px">
            <th margin="6px">Name </th>
            <th margin="6px">place </th>
            <th margin="6px">type </th>
            <th margin="6px">warranty </th>
           
            {/* Add more table headers for other fields */}
          </tr>
          </thead>
        <tbody>
          {tableData.map((row, index) => (
            <tr key={index}>
              <td margin="26px" ><strong style={{color:"red"}}>{row.name}</strong></td>
              <td margin="6px" ><strong style={{color:"red"}}>{row.place}</strong></td>
              <td margin="6px" ><strong style={{color:"red"}}>{row.type}</strong></td>
              <td margin="6px" ><strong style={{color:"red"}}>{row.warranty}</strong></td>
              {/* Add more table cells for other fields */}
            </tr>
          ))}
        </tbody>
      </table>
      </div>

        </Container>


        <Container>
          <h1>Search Products By Type</h1>
          <div>
      <input
        type="text"
        placeholder="Search..."
        value={searchByType}
        onChange={(e) => setSearchByType(e.target.value)}
      />
      <table class="table">
    
        <thead margin="6px">
          <tr margin="6px">
            <th margin="6px">Name </th>
            <th margin="6px">place </th>
            <th margin="6px">type </th>
            <th margin="6px">warranty </th>
           
            {/* Add more table headers for other fields */}
          </tr>
          </thead>
        <tbody>
          {byType.map((row, index) => (
            <tr key={index}>
              <td margin="26px" ><strong style={{color:"red"}}>{row.name}</strong></td>
              <td margin="6px" ><strong style={{color:"red"}}>{row.place}</strong></td>
              <td margin="6px" ><strong style={{color:"red"}}>{row.type}</strong></td>
              <td margin="6px" ><strong style={{color:"red"}}>{row.warranty}</strong></td>
              {/* Add more table cells for other fields */}
            </tr>
          ))}
        </tbody>
      </table>
      </div>

        </Container>


        <Container>
          <h1>Search Products By Warranty</h1>
          <div>
      <input
      type="integer"
        placeholder="Search..."
        value={searchNum}
        onChange={(e) => setSearchNum(e.target.value)}
      />
      <table class="table">
    
        <thead margin="6px">
          <tr margin="6px">
            <th margin="6px">Name </th>
            <th margin="6px">place </th>
            <th margin="6px">type </th>
            <th margin="6px">warranty </th>
           
            {/* Add more table headers for other fields */}
          </tr>
          </thead>
        <tbody>
          {byWarranty.map((row, index) => (
            <tr key={index}>
              <td margin="26px" ><strong style={{color:"red"}}>{row.name}</strong></td>
              <td margin="6px" ><strong style={{color:"red"}}>{row.place}</strong></td>
              <td margin="6px" ><strong style={{color:"red"}}>{row.type}</strong></td>
              <td margin="6px" ><strong style={{color:"red"}}>{row.warranty}</strong></td>
              {/* Add more table cells for other fields */}
            </tr>
          ))}
        </tbody>
      </table>
      </div>

        </Container>
      </Container>
    </div>
  );
};

export default ViewPost;
