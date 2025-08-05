import sr from './images/sr.png'
import './App.css';
import DisplayListOfOffices from './components/DisplayListOfOffices';
import { OfficeList } from './components/ListOfOffices';
function App() {
  const element="Office Space"
  const jsxatt=<img src={sr} width="25%" height ="25%" alt="Office Space"/>
  const ItemName={Name:"DBS",Rent:50000,Address:'Chennai'}
  const colors=[]
  if(ItemName.Rent<60000){
    colors.push('textRed')
  }
  else{
    colors.push('textGreen')
  }
  return (
    <div className="App">
      <h1>{element}, at Affordable Range</h1>
      {jsxatt}
      <h1>Name: {ItemName.Name}</h1>
      <h1 className={colors[0]}>Rent Rs : {ItemName.Rent}</h1>
      <h1>Address : {ItemName.Address}</h1>
      <DisplayListOfOffices OfficeList={OfficeList}/>      
    </div>
  );
}

export default App;
