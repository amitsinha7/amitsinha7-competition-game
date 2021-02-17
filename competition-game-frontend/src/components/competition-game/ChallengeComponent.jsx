import React, { Component, useState, useEffect } from "react";
import CompetitionGameService from "../../api/competition-game/CompetitionGameService";
import { Form, TextField, SelectField, SubmitButton } from './FormElements';


class ChallengeComponent extends Component {

  constructor(props) {
    super(props);
    this.state = {
      challenges: []
    };
    this.showChallenges = this.showChallenges.bind(this);
  }

  componentDidMount() {
    
  }

  handleChange(changeObject) {
    this.setState(changeObject);
  }

  componentWillUnmount() {}

  shouldComponentUpdate(nextProps, nextState) {
    return true;
  }

  componentDidMount() {
    this.showChallenges();
  }

  showChallenges() {
    CompetitionGameService.retrieveAllTasks().then((response) => {
      console.log(response);
      this.setState({ challenges: response.data });
    });
  }

  render() {
    return (
        <div className="container">
          <div className="row">
            <div className="col">
              Name{" "}
              <input
                type="text"
                name="name"
                value={this.state.name}
                onChange={this.handleChange}
              />
            </div>
          </div>
          <button className="btn btn-success" onClick={this.loginClicked}>
            Login
          </button>
        </div>
    );
  }
}

export default ChallengeComponent;
