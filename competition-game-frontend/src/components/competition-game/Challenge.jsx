import React, { Component, Fragment } from "react";
import ChallengeAPI from "../../api/ChallengeAPI";
import { Button, Col, Form, FormControl, InputGroup, Dropdown, DropdownButton } from "react-bootstrap";

class Challenge extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      description: "",
      challengeType: "",
      sourceCode: "",
      showSuccessMessage: false,
      hasSubmissionFailed: false
    };

    this.handleChange = this.handleChange.bind(this);
    this.submitChallenge = this.submitChallenge.bind(this);
  }

  handleChange(event) {
    this.setState(
      {
        ...this.state,
        [event.target.name]: event.target.value
      },
      () => {
        console.log(this.state);
      }
    );
  }
  submitChallenge() {
    ChallengeAPI.executeSubmitChallenge(this.state.name, this.state.description, this.state.challengeType, this.state.sourceCode)
      .then(response => {
        console.log(response);
        this.setState({ showSuccessMessage: true });
        this.props.history.push(`/challenge`);
      })
      .catch(() => {
        this.setState({ showSuccessMessage: false });
        this.setState({ hasSubmissionFailed: true });
      });
  }

  displayChallengeInForm() {
    ChallengeAPI.executeSubmitChallenge(this.state.name, this.state.description, this.state.challengeType, this.state.sourceCode)
      .then(response => {
        console.log(response);
        this.setState({ showSuccessMessage: true });
        this.props.history.push(`/challenge/${this.state.name}`);
      })
      .catch(() => {
        this.setState({ showSuccessMessage: false });
        this.setState({ hasSubmissionFailed: true });
      });
  }

  render() {
    return (
      <div className="container">
        {this.state.hasLoginFailed && <div className="alert alert-warning">Try After Sometime</div>}
        {this.state.showSuccessMessage && <div>Submitted Sucessful</div>}
        <Form onSubmit={this.submitChallenge}>
          <Form.Row>
            <Form.Group as={Col} md="10" controlId="validationCustom01"></Form.Group>
          </Form.Row>
          <Form.Row>
            <Form.Group as={Col} md="2" controlId="validationCustom02">
              <Form.Label>NAME</Form.Label>
            </Form.Group>
            <Form.Group as={Col} md="7" controlId="validationCustom03">
              <Form.Control type="text" name="name" value={this.state.name} onChange={this.handleChange} placeholder="Name" required />
              <Form.Control.Feedback type="invalid">Please provide a valid name.</Form.Control.Feedback>
            </Form.Group>
          </Form.Row>
          <Form.Row>
            <Form.Group as={Col} md="2" controlId="validationCustom02">
              <Form.Label>SELECT TASK</Form.Label>
            </Form.Group>
            <Form.Group as={Col} md="7" controlId="validationCustom03">
              <Form.Control type="text" name="challengeType" value={this.state.challengeType} onChange={this.handleChange} placeholder="SELECT TASK" required />
              <Form.Control.Feedback type="invalid">Please provide a valid SELECT TASK.</Form.Control.Feedback>
            </Form.Group>
          </Form.Row>
          <Form.Row>
            <Form.Group as={Col} md="2" controlId="validationCustom02">
              <Form.Label>DESCRIPTION</Form.Label>
            </Form.Group>
            <Form.Group as={Col} md="7" controlId="validationCustom03">
              <Form.Control type="text" name="description" value={this.state.description} onChange={this.handleChange} placeholder="Description" required />
              <Form.Control.Feedback type="invalid">Please provide a valid Description.</Form.Control.Feedback>
            </Form.Group>
          </Form.Row>

          <Form.Row>
            <Form.Group as={Col} md="2" controlId="validationCustom02">
              <Form.Label>SOLUTION CODE</Form.Label>
            </Form.Group>
            <Form.Group controlId="exampleForm.SelectCustom1">
              <FormControl as="textarea" aria-label="With textarea" name="sourceCode" value={this.state.sourceCode} onChange={this.handleChange} />
            </Form.Group>
          </Form.Row>
          <Button type="submit">Submit</Button>
        </Form>
      </div>
    );
  }
}

export default Challenge;
