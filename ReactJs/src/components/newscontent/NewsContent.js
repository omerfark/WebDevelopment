import React, { useState, useEffect } from "react";
import { NewsService } from "../../services/NewsService";
import { useParams } from "react-router-dom";
import { Container, Row, Col } from "react-bootstrap";
import "./NewsContent.scss";
import { NewsImageService } from "../../services/NewsImageService";
import HeaderTr from "../headTr/HeadTr";

export default function NewsContent() {
  const [newsContentData, setnewsContentData] = useState([]);
  const { id } = useParams();

  // //for image deneme
  // const [newsImage, setNewsImage] = useState({});
  // useEffect(() => {
  //   (async () => {
  //     const imageId = 12;
  //     const fetcImage = await NewsImageService.getByIdImage(imageId);
  //     setNewsImage(fetcImage);
  //   })();
  // }, []);
  // //id bazlı image cekmek

  const [allImage, setAllImage] = useState([]);
  useEffect(() => {
    (async () => {
      const fetchAllImage = await NewsImageService.getAllImage();
      setAllImage(fetchAllImage);
    })();
  }, []);

  console.log("burasıcokomelli", allImage);

  useEffect(() => {
    (async () => {
      const fetchContent = await NewsService.getNews(id);
      setnewsContentData(fetchContent);
    })();
  }, [id]);

  const dateObj = new Date(newsContentData.create_date);
  const year = dateObj.getFullYear(); // Yıl
  const month = dateObj.getMonth(); // Ay (0-11 arası olduğu için +1 eklenir)
  const day = dateObj.getDate(); // Gün
  const monthNames = [
    "Ocak",
    "Şubat",
    "Mart",
    "Nisan",
    "Mayıs",
    "Haziran",
    "Temmuz",
    "Ağustos",
    "Eylül",
    "Ekim",
    "Kasım",
    "Aralık",
  ];
  const monthName = monthNames[month];

  return (
    <>
    <HeaderTr
        items="Haberler"
      />
      <Container>
        <Row className="m-5 justify-content-left">
          <Col md={8}>
            <Row className=" justify-content-left headerBorder">
              <i>
                {"Anasayfa " +
                  " / " +
                  "Haberler " +
                  " / " +
                  newsContentData.news_title}
              </i>
            </Row>
            <Row className=" justify-content-left mb-5">
              <h3 className="mt-5">
                <b>{newsContentData.news_title}</b>
              </h3>
              <i>
                {day + " " + monthName + " " + year + " / "}
                {newsContentData.news_educator}
              </i>
            </Row>
            <Row className="mt-4 mb-4">
              <i> {newsContentData.news_content}</i>
            </Row>
            <Row xs={2} md={2}>
              {allImage.map((imageControl) => {
                const idControl = id;
                const imageIdControl = imageControl.news_id.news_id;
                if (parseInt(idControl) === imageIdControl) {
                  return (
                  <img
                    src={`data:image/png;base64,${imageControl.newsimage_link}`}
                    alt="foto1"
                    style={{
                      maxWidth: "100%",
                      height: "auto",
                    }}
                  />
                  );
                }
                return null;
              })}
            </Row>
          </Col>
        </Row>
      </Container>
    </>
  );
}
