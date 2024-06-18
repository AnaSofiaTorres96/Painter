import { Navigate } from "react-router-dom";
import Details from "./pages/Details";
import Login from "./pages/Login";
import LandingPage from "./pages/LandingPage";
import Characters from "./pages/Characters";

const routes = [
    {
        path: "/",
        //element = corresponding react component
        element: <Navigate to = {"landingPage"}/>,
    },
    {
        path: "/landingPage",
        element: <LandingPage />,
    },
    {
        path: "/characters",
        element: <Characters />,
    },
    {
        path: "/login",
        element: <Login />,
    },
    {
        path: "/details",
        element: <Details />,
    }
];

export { routes };