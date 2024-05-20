import axios from "axios";

export const ContactService = {
    getContactInfo,
    postContactMessage
}

async function getContactInfo(){
    const response = await axios.get("http://localhost:8080/contactpage/get?contact_id=1");
    return response.data;
}


async function postContactMessage(props){
    await axios({
        method: 'post',
        url: 'http://localhost:8080/contactpage/postform',
        data: {
            contactForm_name: props.name,
            contactForm_email: props.email,
            contactForm_title: props.title,
            contactForm_mesaj: props.message
        }
      });
}