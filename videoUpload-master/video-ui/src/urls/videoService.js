import axios from 'axios';
import { BASE_URL } from './baseUrl'

//Create product Information .
export const saveProduct = (data) => {
    return axios.post(BASE_URL, data).then((response) => response.data);
};



//Get All product .
export const GetAllVideos = () => {
    return axios.get(BASE_URL + `/`);

};

//load product by id
export const loadUser = (id) => {
    return axios.get(BASE_URL + `/pid/${id}`)
};

export const DeletePostService = (id) => {

    axios.delete(BASE_URL + `/deleteProduct/${id}`).then((resp) => {
        console.log("response", resp);
    }).catch((error) => {
        console.log(error);
    });
};