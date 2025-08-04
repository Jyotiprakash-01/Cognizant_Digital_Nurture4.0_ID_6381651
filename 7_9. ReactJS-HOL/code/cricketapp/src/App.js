
import './App.css';
import { ListOfPlayers, Scorebelow70, ListOfIndianPlayers } from './components/ListOfPlayers';
import { players, IndianTeam } from './components/players';
import { OddPlayers, EvenPlayers, IndianPlayers } from './components/IndianPlayers';


function App() {
  var flag = true
  if (flag === true) {
    return (
      <div>
        <h1>List of Players</h1>
        <ListOfPlayers players={players} />
        <hr />
        <h1>List of Players having Scores less than 70</h1>
        <Scorebelow70 players={players} />
      </div>
    )
  }
  else {
    return (
      <div>
        <div>
          <h1>Indian Players</h1>
          <h1>Odd Players</h1>
          {OddPlayers(IndianTeam)}
          <hr />
          <h1>Even Players</h1>
          {EvenPlayers(IndianTeam)}
        </div>
        <div>
          <hr />
          <h1>List of Indian Players Merged</h1>
          <ListOfIndianPlayers IndianPlayers={IndianPlayers} />
        </div>
      </div>

    );
  }
}

  export default App;
