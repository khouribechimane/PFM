import { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate, useLocation } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

const UpdateEventForm = () => {
    const [categories, setCategories] = useState([]);

    const location = useLocation();

    //const admin = JSON.parse(sessionStorage.getItem("active-admin"));
    //const admin_jwtToken = sessionStorage.getItem("admin-jwtToken");

    let navigate = useNavigate();

    const retrieveAllCategories = async () => {
        const response = await axios.get(
            "http://localhost:8080/api/event/category/fetch/all"
        );
        return response.data;
    };

    useEffect(() => {
        const getAllCategories = async () => {
            const resCategory = await retrieveAllCategories();
            if (resCategory) {
                setCategories(resCategory.categories);
            }
        };

        getAllCategories();
    }, []);

    const [selectedImage1, setSelectImage1] = useState(null);

    const [event, setEvent] = useState(location.state);

    const handleInput = (e) => {
        setEvent({ ...event, [e.target.name]: e.target.value });
    };

    const saveEvent = (e) => {
        e.preventDefault();
        if (event === null) {
            toast.error("Invalid input!");
            return;
        }

        if (event.categoryId === "" || event.categoryId === "0") {
            toast.error("Select Category!");
            return;
        }

        if (event.venueType === "" || event.venueType === null) {
            toast.error("Select Venue Type!");
            return;
        }

        const formData = new FormData();
        formData.append("id", event.id);
        formData.append("name", event.name);
        formData.append("description", event.description);
        formData.append("venueName", event.venueName);
        formData.append("venueType", event.venueType);
        formData.append("location", event.location);
        if (selectedImage1) {
            formData.append("image", selectedImage1);
        }
        formData.append("noOfTickets", event.noOfTickets);
        formData.append("startDate", convertToEpochTime(event.startDate));
        formData.append("endDate", convertToEpochTime(event.endDate));
        formData.append("ticketPrice", event.ticketPrice);
        formData.append("categoryId", event.categoryId);
        formData.append("availableTickets", event.availableTickets);

        axios
            .put("http://localhost:8080/api/event/update", formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            })
            .then((resp) => {
                let response = resp.data;

                if (response.success) {
                    toast.success(response.responseMessage);

                    setTimeout(() => {
                        navigate("/admin/event/all");
                    }, 2000);
                } else {
                    toast.error(response.responseMessage);
                }
            })
            .catch((error) => {
                console.error(error);
                toast.error("An error occurred while updating the event. Please try again.");
            });
    };

    const convertToEpochTime = (dateString) => {
        const selectedDate = new Date(dateString);
        const epochTime = selectedDate.getTime();
        return epochTime;
    };

    return (
        <div>
            <div class="mt-2 d-flex aligns-items-center justify-content-center mb-4">
                <div class="card form-card shadow-lg" style={{ width: "60rem" }}>
                    <div className="container-fluid">
                        <div
                            className="card-header bg-color custom-bg-text mt-2 text-center"
                            style={{
                                borderRadius: "1em",
                                height: "45px",
                            }}
                        >
                            <h5 class="card-title">Update Event</h5>
                        </div>
                        <div class="card-body text-color">
                            <form className="row g-3">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="title" className="form-label">
                                        <b>Event Title</b>
                                    </label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="name"
                                        name="name"
                                        onChange={handleInput}
                                        value={event.name}
                                    />
                                </div>
                                <div className="col-md-6 mb-3">
                                    <label className="form-label">
                                        <b>Event Description</b>
                                    </label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        name="description"
                                        onChange={handleInput}
                                        value={event.description}
                                    />
                                </div>

                                <div className="col-md-6 mb-3">
                                    <label className="form-label">
                                        <b>Event Category</b>
                                    </label>

                                    <select
                                        name="categoryId"
                                        onChange={handleInput}
                                        className="form-control"
                                        value={event.categoryId}
                                    >
                                        <option value="" disabled selected>Select Event Category</option>

                                        {categories.map((category) => {
                                            return (
                                                <option key={category.id} value={category.id}> {category.name} </option>
                                            );
                                        })}
                                    </select>
                                </div>

                                <div className="col-md-6 mb-3">
                                    <label htmlFor="title" className="form-label">
                                        <b>Event Venue Name</b>
                                    </label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="venueName"
                                        name="venueName"
                                        onChange={handleInput}
                                        value={event.venueName}
                                    />
                                </div>

                                <div className="col-md-6 mb-3">
                                    <label className="form-label">
                                        <b>Event Venue Type</b>
                                    </label>

                                    <select
                                        name="venueType"
                                        onChange={handleInput}
                                        className="form-control"
                                        value={event.venueType}
                                    >
                                        <option value="" disabled selected>Select Venue Type</option>
                                        <option value="Stadiums">Stadiums</option>
                                        <option value="Arenas">Arenas</option>
                                        <option value="Sports Complexes">Sports Complexes</option>
                                        <option value="Gymnasiums">Gymnasiums</option>
                                        <option value="Swimming Pools">Swimming Pools</option>
                                        <option value="Athletic Tracks">Athletic Tracks</option>
                                        <option value="Tennis Courts">Tennis Courts</option>
                                        <option value="Golf Courses">Golf Courses</option>
                                        <option value="Ice Rinks">Ice Rinks</option>
                                        <option value="Cricket Grounds">Cricket Grounds</option>
                                        <option value="Baseball Fields">Baseball Fields</option>
                                        <option value="Soccer Fields">Soccer Fields</option>
                                        <option value="Basketball Courts">Basketball Courts</option>
                                        <option value="Martial Arts Dojos">Martial Arts Dojos</option>
                                        <option value="Bowling Alleys">Bowling Alleys</option>
                                    </select>
                                </div>
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="street" className="form-label">
                                        <b>Location</b>
                                    </label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="location"
                                        name="location"
                                        onChange={handleInput}
                                        value={event.location}
                                    />
                                </div>
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="pincode" className="form-label">
                                        <b>No. Of Tickets</b>
                                    </label>
                                    <input
                                        type="number"
                                        className="form-control"
                                        id="noOfTickets"
                                        name="noOfTickets"
                                        onChange={handleInput}
                                        value={event.noOfTickets}
                                    />
                                </div>
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="pincode" className="form-label">
                                        <b>Available Tickets</b>
                                    </label>
                                    <input
                                        type="number"
                                        className="form-control"
                                        id="availableTickets"
                                        name="availableTickets"
                                        onChange={handleInput}
                                        value={event.availableTickets}
                                    />
                                </div>
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="ticketPrice" className="form-label">
                                        <b>Ticket Price</b>
                                    </label>
                                    <input
                                        type="number"
                                        className="form-control"
                                        id="ticketPrice"
                                        name="ticketPrice"
                                        onChange={handleInput}
                                        value={event.ticketPrice}
                                    />
                                </div>
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="ticketPrice" className="form-label">
                                        <b>Event Start Time</b>
                                    </label>
                                    <input
                                        type="datetime-local"
                                        className="form-control"
                                        id="startDate"
                                        name="startDate"
                                        onChange={handleInput}
                                        value={event.startDate}
                                    />
                                </div>
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="ticketPrice" className="form-label">
                                        <b>Event End Time</b>
                                    </label>
                                    <input
                                        type="datetime-local"
                                        className="form-control"
                                        id="endDate"
                                        name="endDate"
                                        onChange={handleInput}
                                        value={event.endDate}
                                    />
                                </div>

                                <div className="col-md-6 mb-3">
                                    <label htmlFor="image" className="form-label">
                                        <b>Event Image</b>
                                    </label>
                                    <input
                                        type="file"
                                        className="form-control"
                                        name="image"
                                        onChange={(e) => setSelectImage1(e.target.files[0])}
                                    />
                                </div>

                                <div className="col-md-6 mb-3 text-center">
                                    <button
                                        onClick={saveEvent}
                                        className="btn btn-outline-dark rounded-5"
                                        style={{
                                            width: "120px",
                                            padding: "10px 0",
                                            backgroundColor: "#6f42c1",
                                            color: "white",
                                        }}
                                    >
                                        Save Event
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <ToastContainer />
        </div>
    );
};

export default UpdateEventForm;

