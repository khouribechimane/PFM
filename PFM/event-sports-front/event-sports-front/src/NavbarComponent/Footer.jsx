import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <div>
      <div className="container my-5">
        <footer className="text-center text-lg-start text-color">
          <div className="container-fluid p-3 pb-0">
            <section>
              <div className="row justify-content-center text-center">
                <div className="col-lg-4 col-md-6 mb-4 mb-md-0">
                  <h5 className="text-uppercase text-color-second">Sport Event</h5>
                  <p>
                    Welcome to our Sport Event Management platform, where every detail is tailored to perfection.
                    Let us bring your vision to life and create unforgettable sports experiences!
                  </p>
                </div>

                <div className="col-lg-4 col-md-6 mb-4 mb-md-0">
                  <h5 className="text-uppercase text-color-second">About us</h5>
                  <p>
                    Our platform offers a comprehensive solution for managing sports events from start to finish.
                    We streamline event planning, registration, ticketing, and more, ensuring that every event runs smoothly.
                    Let us help you organize and manage events that leave a lasting impact!
                  </p>
                </div>

                <div className="col-lg-4 col-md-6 mb-4 mb-md-0">
                  <h5 className="text-uppercase text-color-second">Contact us</h5>
                  <ul className="list-unstyled mb-0">
                    <li className="d-flex justify-content-center align-items-center">
                      <strong className="text-color me-2">Tél :</strong>
                      <a href="tel:+212523353700" className="text-color">
                        +212 523 353 700
                      </a>
                    </li>
                    <li className="d-flex justify-content-center align-items-center">
                      <strong className="text-color me-2">Email :</strong>
                      <a href="mailto:eventsport@gmail.com" className="text-color">
                        eventsport@gmail.com
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            </section>

            <hr className="mb-4" />

            <section>
              <p className="d-flex justify-content-center align-items-center">
                <span className="me-3 text-color">Login from here</span>
                <Link to="/user/login" className="active">
                  <button
                    type="button"
                    className="btn btn-outline-light btn-rounded bg-color text-color"
                  >
                    Log in
                  </button>
                </Link>
              </p>
            </section>

            <hr className="mb-6" />
          </div>

          <div className="text-center">
            ©️ 2025 Copyright:
            <a className="text-color-3" href="#">
              sportevent.com
            </a>
          </div>
        </footer>
      </div>
    </div>
  );
};

export default Footer;