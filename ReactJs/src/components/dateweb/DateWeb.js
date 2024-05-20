import React from "react";
import "./DateWeb.scss"

export default function DateWeb(props) {
    const create_date = props.date // PostgreSQL'den gelen tarih
    const dateObj = new Date(create_date);


    const year = dateObj.getFullYear(); // Yıl
    const month = dateObj.getMonth() + 1; // Ay (0-11 arası olduğu için +1 eklenir)
    const day = dateObj.getDate(); // Gün
  
    return (
      <div className="expense-date mx-auto">
        <div className="expense-date__day">{day + " / " + month + " / " + year}</div>

      </div>
    );
}