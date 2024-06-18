import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
    const [formData, setFormData] = useState({ username: "", password: "" });
    const navigate = useNavigate();

    //event in this case is on change because its associate to it in line 31
    function changeFormData(event) {
        //const = what event targeted it (either username or password)
        const id = event.target.id;

        Object.keys(formData).forEach((element) => {
            if (element === id) {
                setFormData((prevState) => ({
                    //this interates through prevStates keys and assigns that value to id... i think
                    ...prevState,
                    [id]: event.target.value,
                }));
            }
        });
    }

    function submitForm(event) {
        event.preventDefault();

        navigate(`/details/${formData.username}/${formData.password}`);
    }

    return (
        <>
            <form onSubmit={submitForm}>
                <label htmlFor='username'>Username:</label>
                <input type='text' id='username' onChange={changeFormData}></input>

                <label htmlFor='password'>Password:</label>
                <input type='password' id='password' onChange={changeFormData}></input>

                <button type='submit'>Login</button>
            </form>
        </>
    );
}

export default Login;