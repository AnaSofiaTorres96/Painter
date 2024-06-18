import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import "./App.css";
import { routes } from "./routes";

function App() {
    return (
        <Router>
            <Routes>
                {routes.map(({ path, element }, index) => (
                    <Route key={index} path={path} element={element} />
                ))}
            </Routes>
        </Router>
    );
}

export default App;
