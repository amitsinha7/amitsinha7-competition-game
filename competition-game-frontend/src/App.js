import React, { Component } from 'react';
import CompetitionGameApp from './components/competition-game/CompetitionGameApp'
import './App.css';
import './bootstrap.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <CompetitionGameApp />
      </div>
    );
  }
}

export default App;