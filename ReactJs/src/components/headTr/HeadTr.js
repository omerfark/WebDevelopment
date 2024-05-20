import React from 'react';
export default function HeaderTr(props) {

  return (
    <header>
      <div
        className='p-5 text-center bg-image'
        style={{ backgroundImage: "url('https://aecom.com/sa/wp-content/uploads/2016/08/CIP_image_3-e1471970780624.jpg')", height: 250 }}
      >
        <div className='mask' style={{ backgroundColor: 'rgba(0, 0, 0, 0.6)' }}>
          <div className='d-flex justify-content-center align-items-center h-10'>
            <div className='text-white' >
              <h3 className='text-white '>{props.items}</h3>
              <div className="mt-5 mb-2" style={{ backgroundColor: 'rgba(255, 0, 0, 0.6)' }}>
              <a className='btn btn-lg' href='/mainpage' role='button'>
                Anasayfa
              </a>
              <i>/</i>
              <a className='btn btn-lg' href='/Education/get' role='button'> {props.items} </a>
              </div>

            </div>
          </div>
        </div>
      </div>
    </header>
  );
}