import { Link } from "react-router-dom";

function List() {
    console.log("is anyone there?");
    return (
        <>
            <Link to={"/login"}>
                <button>Go to Login</button>
            </Link>
        </>
    );
        
}

export default List;