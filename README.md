# Survey Management System

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## Overview

The Survey Management System is a web-based application designed to streamline the creation, distribution, and analysis of surveys. It provides a user-friendly interface for managing surveys, collecting responses, and generating insightful reports.

## Features

- **User microservice:** Secure user accounts and authentication system.
- **survery Management Frontend:** Easily create and customize surveys with various question types.
- **Zuul apigateway:** Share surveys via unique links or email invitations.

## Technologies Used

- Frontend: [React](https://reactjs.org/), [Bootstrap](https://getbootstrap.com/)
- Backend: [Node.js](https://nodejs.org/), [Express](https://expressjs.com/)
- Database: [MongoDB](https://www.mongodb.com/)

## Getting Started

### Prerequisites

- Node.js and npm installed
- MongoDB installed and running

### Installation

1. Clone the repository: `git clone https://github.com/your-username/survey-management-system.git`
2. Navigate to the project directory: `cd survey-management-system`
3. Install dependencies: `npm install`
4. Set up environment variables: Create a `.env` file based on the provided `.env.example`.

### Usage

1. Start the backend server: `npm run start-server`
2. Start the frontend: `npm start`
3. Access the application at [http://localhost:3000](http://localhost:3000)

## Contribution

Contributions are welcome! Follow these steps:

1. Fork the repository
2. Create a new branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m 'Add your feature'`
4. Push to the branch: `git push origin feature/your-feature`
5. Submit a pull request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
