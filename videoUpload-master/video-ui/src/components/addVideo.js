import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import {
  Container,
  Card,
  CardBody,
  Input,
  Form,
  Label,
  Button,Row,Col
} from "reactstrap";
import { SaveVideoInfo, UplaodVideo, saveProduct } from "../urls/videoService";
import { ProgressBar } from "react-bootstrap";
import axios from 'axios';
import "react-circular-progressbar/dist/styles.css";
import { CircularProgressbar, buildStyles } from "react-circular-progressbar";

const AddVideo = () => {
  const [product, setProduct] = useState({
    name: "",
    type: "",
    place: "",
    warranty: "",
  });

   const [urlData, setUrlData] = useState({
    name: "",
    originalUrl: "",
  });

const [getUrl,setGetUrl] = useState([])
  const [progress, setProgress] = useState(0);
  const [products, setProducts] = useState(null);
  const [loading, setLoading] = useState(true);

  //fields change handle function .
  const fieldChangeHandle = (event) => {
    setProduct({ ...product, [event.target.name]: event.target.value });
  };

  //Url SortnerField Change
   const urlfieldChangeHandle = (event) => {
    setUrlData({ ...urlData, [event.target.name]: event.target.value });
  };

  //Upload  function  .
  const createVideo = (event) => {
    event.preventDefault();
    console.log(product);

    //submit call starts here .
    saveProduct(product)
      .then((data) => {
        console.log(data);

        console.log(product);
        setProduct({
          name: "",
          type: "",
          place: "",
          warranty: "",
        });
        toast.success("Product Uploaded with Information!!");
      })
      .catch((error) => {
        alert("upload failed");
      });
  };

 

  useEffect(() => {
    // Define an async function to fetch data from the API
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:7009/urls'); // Replace with your API endpoint
        setGetUrl(response.data); // Update the state with the received data
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };
  
    fetchData(); // Invoke the async function
  }, []);

   //Upload  function  .
  const createSortUrl = (event) => {
    event.preventDefault();
    console.log(product);

    //submit call starts here .
    axios.post("http://localhost:7009/urls",urlData)
      .then((data) => {
        console.log(data);

        console.log(urlData);
        setProduct({
          name: "",
          originalUrl: "",
        });
        toast.success("Url Sorted with Information!!");
      })
      .catch((error) => {
        alert("upload failed");
      });
  };
  return (
    <div className="wrapper">
      <Container>
        <Container className="mb-2 p-4">
          <Button color="primary" size="lg" href="/view">
            Click to Watch All Products
          </Button>
        </Container>
        <Card className="shadow-sm border-1 mt-2 border-radius-2">
          <CardBody>
            <h3>
              <strong>Form for Add products </strong>
            </h3>
            <Form onSubmit={createVideo}>
              <div>
                <Label for="name"> Name</Label>
                <Input
                  type="text"
                  id="name"
                  placeholder="Enter Product name here"
                  className="rounded-2"
                  name="name"
                  onChange={fieldChangeHandle}
                />
              </div>
              <div>
                <Label for="type">Type </Label>
                <Input
                  type="text"
                  id="type"
                  placeholder="Enter type"
                  className="rounded-2"
                  name="type"
                  onChange={fieldChangeHandle}
                />
              </div>
              <div>
                <Label for="place">Place </Label>
                <Input
                  type="text"
                  id="place"
                  placeholder="Enter place"
                  className="rounded-2"
                  name="place"
                  onChange={fieldChangeHandle}
                />
              </div>

              <div>
                <Label for="warranty">Warranty </Label>
                <Input
                  type="number"
                  id="warranty"
                  placeholder="Enter year of expiry"
                  className="rounded-2"
                  name="warranty"
                  onChange={fieldChangeHandle}
                />
              </div>

              <Container className="text-center p-2
              ">
                <Button className="rounded-2 mb-2 " color="primary">
                  {" "}
                  Submit
                </Button>
              </Container>
            </Form>
          </CardBody>
        </Card>

        <Container>
          <Card className="shadow-sm border-1 mt-2 border-radius-2">
            <CardBody>
              <h3>
                <strong>URL SORTNER </strong>
              </h3>
              <Form onSubmit={createSortUrl}>
                <div>
                  <Label for="type">Name </Label>
                  <Input
                    type="text"
                    id="name"
                    placeholder="Enter name"
                    className="rounded-2"
                    name="name"
                    onChange={urlfieldChangeHandle}
                  />
                </div>

                <div>
                  <Label for="warranty">Original url </Label>
                  <Input
                    type="text"
                    id="originalUrl"
                    placeholder="Enter originalUrl"
                    className="rounded-2"
                    name="originalUrl"
                    onChange={urlfieldChangeHandle}
                  />
                </div>

                <Container className="text-center p-2">
                  <Button className="rounded-2 mb-2 " color="primary">
                    {" "}
                    Submit
                  </Button>
                </Container>
              </Form>
            </CardBody>
          </Card>
    </Container>

    </Container>
       <Container>
        <Card>
          <table class="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {getUrl.map(item => (
            <tr key={item.id}>
              <td>{item.name}</td>
              <td style={{color:"blue"}}>{item.originalUrl}</td>
              <td>{item.sortedUrl}</td>
            </tr>
          ))}
        </tbody>
      </table>
      
            
        
        </Card>
        </Container>
        <Container>
    </Container>
    </div>
    
  );
};
export default AddVideo;
