import axios from "axios";

export const EducationService ={
    getAllEducation,
    getMainEducation,
    getAllEduStep,
    getByIdEducation
}

async function getAllEducation(){
    const response = await axios.get("http://localhost:8080/Education/getall")
    return response.data;
}

async function getMainEducation(){
    const response = await axios.get("http://localhost:8080/Education/getmainall")
    return response.data;
}

async function getByIdEducation(a){
    const response = await axios.get (`http://localhost:8080/Education/get/${a}`)
    return response.data;
}


async function getAllEduStep(){
    const response = await axios.get(`http://localhost:8080/educontent/getall`)
    return response.data;
}
