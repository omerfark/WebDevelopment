import axios from 'axios'

export const NewsImageService ={
    getByIdImage,
    getAllImage
}

async function getByIdImage(newsimage_id){
    const response = await axios.get(`http://localhost:8080/news/getimage?newsimage_id=${newsimage_id}`)
    return response.data;
}

async function getAllImage(){
    const response = await axios.get("http://localhost:8080/news/getallimage")
    return response.data;
}