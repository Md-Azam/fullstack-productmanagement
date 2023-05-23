import React, { useState, useEffect } from 'react'
import { BASE_URL } from '../urls/baseUrl';
import axios from 'axios';
import { Link, useParams } from "react-router-dom";
import { Container, Card, CardBody, Input, Form, Label, Button, } from 'reactstrap';
const SeeOne = () => {

  const [product, setProduct] = useState({
    id: " ",
    name: "",
    type: "",
    place: "",
    warranty: "",
  });
  const { id } = useParams();
  useEffect(() => {
    loadUser();
  }, []);
  const loadUser = async () => {
    const result = await axios.get(BASE_URL + `/pid/${id}`);
    setProduct(result.data);
    console.log("something wrong")
    setProduct(result.data);
  };



  return (
    <div>
      <div className="row">
        <div
          className={"col-md-6 offset-md-3 border rounded p-4 mt-2 shadow"} >
          <h2 className={"text-center m-4"}>Post Detail</h2>
          <div className="card">
            <div className="card-header">

              Details of Product id : {product.id}
              <ul className={"list-group list-group-flush"}>
                <li className="list-group-item">
                  <b>Name of Product: </b>
                  {product.name}
                </li>
                <li className="list-group-item">
                  <b>Type: </b>
                  {product.type}
                </li>

                <li className="list-group-item">
                  <b>Place: </b>
                  {product.place}
                </li>
                <li className="list-group-item">
                  <b>Warranty: </b>
                  {product.warranty}
                </li>
              </ul>

            </div>
            <Container className="mb-2 p-4">
                    <Button color="primary" size="lg" href="/view">Click to Watch All Products</Button>
                </Container>
          </div>
        </div>
      </div>
    </div>
  )
}

export default SeeOne;