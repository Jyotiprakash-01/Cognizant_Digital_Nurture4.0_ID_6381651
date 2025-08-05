
import './App.css';
import { useState } from 'react';
import LogoutButton from './Components/LogoutButton';
import LoginButton from './Components/LoginButton';
import Greeting from './Components/Greetings';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };
  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />
  }
  else {
    button = <LoginButton onClick={handleLoginClick} />
  }
  
  return (
    <div className="App">
      <Greeting isLoggedIn={isLoggedIn} />
      {button}
    </div>
  );
}

export default App;
