import axios from 'axios'

export const NewsService = {
    getAllNews,
    getNews
}

async function getAllNews(){
    const response = await axios.get("http://localhost:8080/news/getall")
    return response.data;
}

async function getNews(a){
    const response = await axios.get(`http://localhost:8080/news/get/${a}`)
    return response.data;
}