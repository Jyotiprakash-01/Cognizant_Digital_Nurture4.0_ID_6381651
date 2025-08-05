
import './App.css';
import { useState } from 'react';
import CurrencyConverter from './Components/CurrencyConverter';

function App() {
  const [count,setCount]=useState(0);
  const handleIncrement = () =>{
    setCount(count+1);
    alert("Hello Member 1");
  };
  const handleDecrement = ()=>{
    setCount(count-1);
  };
  const sayWelcome = (arg) =>{
    alert(`${arg}`);
  }
  const handleClick=()=>{
    alert("I was Clicked");
  }
  return (
    <div>
      <p className='val'>{count}</p>
      <div className='btn'><button onClick={handleIncrement}>Increment</button></div>
      <div className='btn'><button onClick={handleDecrement}>Decrement</button></div>
      <div className='btn'><button onClick={() =>sayWelcome("welcome")}>Say welcome</button></div>
      <div className='btn'><button onClick={handleClick}>Click on me</button></div>
      <CurrencyConverter/>
    </div>

  );
}

export default App;
