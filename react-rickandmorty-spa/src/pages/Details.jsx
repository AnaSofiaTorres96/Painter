import { Link, useParams } from "react-router-dom";

function Details() {
    const { username, password } = useParams();

    return (
        <>
            <h1>{username}</h1>
            <h1>{password}</h1>
            <Link to={"/list"}>
                <button>Go to List</button>
            </Link>
        </>
    );
}

export default Details;