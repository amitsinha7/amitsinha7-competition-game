import React, { Component } from "react";
import CompetitionGameService from "../../api/competition-game/CompetitionGameService";
import { Form, Row, Col, Button, Intro, Panel, Results } from "react-bootstrap";

const questionsMap = [0, 1, 2, 3];

class SubmitChallengeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      challenges: [],
      challenge: "",
      name: "",
      id: "",
      notes: "",
      questions: ["question1", "question2", "question3", "question4"],
      answers: ["answers1", "answers2", "answers3", "answers4"],
    };
    this.showChallenges = this.showChallenges.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.onSelect = this.onSelect.bind(this);
  }

  onSelect(value) {
    /* Some code for when buttons are clicked */
  }
  componentDidMount() {
    // get all entities - GET
  }
  create(e) {
    // add entity - POST
    e.preventDefault();
  }
  update(e) {
    // update entity - PUT
    e.preventDefault();
  }
  delete(e) {
    // delete entity - DELETE
    e.preventDefault();
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
    const elements = ["one", "two", "three"];

    const items = [];

    for (const [index, value] of elements.entries()) {
      items.push(<li key={index}>{value}</li>);
    }

    return <div>{items}</div>;
  }
}

export default SubmitChallengeComponent;
