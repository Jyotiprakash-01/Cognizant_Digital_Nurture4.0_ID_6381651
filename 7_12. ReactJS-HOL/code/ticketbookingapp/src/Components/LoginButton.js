function LoginButton(props){
    return(
        <div className="btn">
            <button onClick={props.onClick}>Login</button>
        </div>
    )
}
export default LoginButton;