import React, { Component } from "react";
import ChallengeAPI, { JWT_TOKEN } from "../../api/ChallengeAPI.js";

class TopPlayer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      players: [],
      message: null,
      hasLoginFailed: false,
      showSuccessMessage: false
    };
    this.getTopPlayers = this.getTopPlayers.bind(this);
  }

  getTopPlayers() {
    ChallengeAPI.getTopPlayers(sessionStorage.getItem(JWT_TOKEN))
      .then(response => {
        this.setState({ players: response.data });
        this.props.history.push(`/challenge`);
      })
      .catch(() => {
        this.setState({ showSuccessMessage: false });
        this.setState({ hasLoginFailed: true });
      });
  }

  render() {
    console.log("render");
    return (
      <div>
        <h1>Top Players</h1>
        {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
        <div className="container">
          <table className="table">
            <thead>
              <tr>
                <th>Nick Name</th>
                <th>SUCCESS SOLUTIONS</th>
                <th>TASKS</th>
              </tr>
            </thead>
            <tbody>
              {this.state.players.map(player => (
                <tr key={player.id}>
                  <td>{player.nickname}</td>
                  <td>{}</td>
                  <td>{player.toString()}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default TopPlayer;
