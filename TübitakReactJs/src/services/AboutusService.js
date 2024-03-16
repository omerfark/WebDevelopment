import axios from "axios";

export const AboutusService = {
    getAboutus,
    getAllAboutus
}

async function getAboutus(){
    const response = await axios.get("http://localhost:8080/aboutus/get?aboutus_id=1");
    return response.data;
}

async function getAllAboutus(){
    const response = await axios.get("http://localhost:8080/aboutus/getall");
    return response.data;
}
