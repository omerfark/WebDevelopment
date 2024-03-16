import axios from 'axios'

export const SocialmediaService = {
    getAllSocialmedia
}

async function getAllSocialmedia(){
    const response = await axios.get("http://localhost:8080/news/socialmedia");
    return response.data;
}