import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Aboutus from "./components/aboutus/AboutUs";
import "bootstrap/dist/css/bootstrap.min.css";
import Footer from "./components/footer/Footer";
import Navbar2react from "./components/navbar2react/Navbar2react";
import NewsPage from "./components/newspage/NewsPage";
import Education from "./components/education/Education";
import MainPage from "./components/mainpage/MainPage";
import ContactPage from "./components/contactpage/ContactPage";
import Education2Content from "./components/educationContent/Education2Content";
import NewsContent from "./components/newscontent/NewsContent";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar2react></Navbar2react>
        <Routes>
          <Route exact path="/mainpage" Component={MainPage}>
            MainPage
          </Route>
          <Route exact path="/aboutus/getall" Component={Aboutus}>
            Aboutus
          </Route>
          <Route exact path="/news/getall" Component={NewsPage}>
            NewsPage
          </Route>
          <Route exact path="/Education/get" Component={Education}>
            Education
          </Route>
          <Route exact path="/contactpage/get" Component={ContactPage}>
            ContactPage
          </Route>
          <Route exact path="/eduContent/get" Component={Education2Content}>
          <Route 
            path=":id"
            element={<Education2Content/>}
            />
            EducationContent
          </Route>
          <Route exact path="/newsContent/get" Component={NewsContent}>
            <Route 
            path=":id"
            element={<NewsContent/>}
            />
            NewsContent
          </Route>
        </Routes>
        <Footer></Footer>
      </BrowserRouter>
    </div>
  );
}

export default App;
