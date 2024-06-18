import { Link } from "react-router-dom";

function LandingPage (){
    return (
        <>
        <Link to={"/characters"}>
                <button>Meet the cast</button>
            </Link>
        </>
    )
}

export default LandingPage;