import axios from "axios";
const api = axios.create ({
    baseURL: 'http://localhost:8080/v1/elx/recados/1'
}); 

export default api;