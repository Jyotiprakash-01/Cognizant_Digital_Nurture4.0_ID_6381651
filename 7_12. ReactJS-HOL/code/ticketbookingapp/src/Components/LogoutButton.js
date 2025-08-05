function LogoutButton(props){
    return(
        <div className="btn">
            <button onClick={props.onClick}>Logout</button>
        </div>
    )
}
export default LogoutButton;