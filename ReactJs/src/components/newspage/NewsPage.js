import React, { useState, useEffect } from "react";
import { NewsService } from "../../services/NewsService";
import DateWeb from "../dateweb/DateWeb";

import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import { Card, Row } from "react-bootstrap";
import HeaderTr from "../headTr/HeadTr";
import "./NewsPage.scss";
import { NewsImageService } from "../../services/NewsImageService";

export default function NewsPage() {
  const [newsData, setNewsData] = useState([]);

  useEffect(() => {
    (async () => {
      const fetchNews = await NewsService.getAllNews();
      setNewsData(fetchNews);
    })();
  }, []);

  const [allImage, setAllImage] = useState([]);
  useEffect(() => {
    (async () => {
      const fetchAllImage = await NewsImageService.getAllImage();
      setAllImage(fetchAllImage);
    })();
  }, []);

  return (
    <>
      <HeaderTr items="Haberler" />
      <Container>
        <Row>
          {newsData.map((news) => (
            <div className="col-4 mt-5 ">
              <Card
                style={{ width: "20rem" }}
                className="mainpage_card mx-auto card-content"
              >
                {allImage.map((imageControl) => {
                  const idControl = news.news_id;
                  const imageIdControl = imageControl.news_id.news_id;
                  if (parseInt(idControl) === imageIdControl) {
                    return (
                      <Card.Img
                        src={`data:image/png;base64,${imageControl.newsimage_link}`}
                        alt="Resim"
                        style={{
                          width: "100%",
                          height: "210px",
                          objectFit: "cover",
                        }}
                        key={imageControl.news_id} // Eğer kullanıyorsanız, key eklemek iyi bir uygulamadır.
                      />
                    );
                  }
                  return null;
                })}
                <Card.Body style={{ width: "320px", marginBottom: "10px" }}>
                  <Card.Title title={news.news_title}
                    style={{
                      fontSize: "18px",
                      fontWeight: "bold",
                      whiteSpace: "nowrap",
                      overflow: "hidden",
                      textOverflow: "ellipsis",
                    }}
                  >
                    {news.news_title}
                  </Card.Title>
                  <Card.Text
                    style={{
                      justifyContent: "space-between",
                      alignItems: "right",
                      marginTop:"10px"
                    }}
                  >
                    <DateWeb date={news.create_date} />
                  </Card.Text>
                  <Card.Text>
                    {news.news_content.substring(0, 100) + "..."}
                  </Card.Text>
                  <Button
                    href={`/newsContent/get/${news.news_id}`}
                    variant="primary"
                    style={{ marginTop: "10px", textAlign: "center" }}
                  >
                    Go somewhere
                  </Button>
                </Card.Body>
              </Card>
            </div>
          ))}
        </Row>
      </Container>
    </>
  );
}
