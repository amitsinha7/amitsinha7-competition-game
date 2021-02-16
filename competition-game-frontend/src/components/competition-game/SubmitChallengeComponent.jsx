import React, { Component } from "react";
import CompetitionGameService from "../../api/competition-game/CompetitionGameService";
import { Form, Row, Col, Button } from "react-bootstrap";
class SubmitChallengeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      challenges: [],
      name: "",
      id: "",
      notes: "",
    };
    this.showChallenges = this.showChallenges.bind(this);
    this.handleChange = this.handleChange.bind(this);
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
    return (
      <div className="container outer-container">
        <form className="outer-container">
          <div className="form-group outer-container" fxLayout="column">
            <div fxLayout="row" fxLayoutGap="20px">
              <div className="col-sm-2 col-form-label" fxFlex="20">Name: </div>
              <div className="col-sm-7" fxFlex="80">
                <input
                  className="form-control"
                  type="text"
                  name="username"
                  value={this.state.name}
                  onChange={this.handleChange}
                />
              </div>
            </div>

            <form class="form-inline">
              <label class="my-1 mr-2" for="inlineFormCustomSelectPref">
                SELECT TASK
              </label>
              <select
                class="custom-select my-1 mr-sm-2"
                id="inlineFormCustomSelectPref"
              >
                <option selected>Choose...</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
              </select>

              <button type="submit" class="btn btn-primary my-1">
                Submit
              </button>
            </form>
          </div>
        </form>
      </div>
    );
  }
}

export default SubmitChallengeComponent;
