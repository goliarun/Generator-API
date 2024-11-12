# Generator-API
Scalable Tracking Number Generator API

Here's a README.md file for the tracking number generator API project.

---

# Tracking Number Generator API

This project provides a scalable, RESTful API to generate unique tracking numbers for parcels, designed to handle high concurrency and scalable deployments. The API is built using Spring Boot and follows best practices for project structure, configuration, and deployment.

## Table of Contents
- Getting Started
- API Documentation
- Project Structure
- Database Setup
- Deployment
- Usage
- Testing
- Additional Notes

## Getting Started

### Prerequisites
- Java 17 or later
- Maven 3.6 or later
- Docker (optional, for database containerization)
- Git

### Setup

1. Clone the Repository
   bash
   git clone https://github.com/your-username/tracking-number-generator.git
   cd tracking-number-generator
   

2. **Build the Project**
   bash
   mvn clean install
   

3. **Run the Application**
   bash
   mvn spring-boot:run
   
   The API should be available at http://localhost:8080/api/next-tracking-number.

### Configuration
Edit the application.properties  in  src/main/resources for any custom settings:
- Database: Configure your database URL, username, and password.
- Server Port: Change the server port if needed.

## API Documentation

This API provides a single endpoint to generate unique tracking numbers:

### Endpoint: GET /api/next-tracking-number

#### Query Parameters:
- origin_country_id: ISO 3166-1 alpha-2 code for the origin country (e.g., MY).
- destination_country_id: ISO 3166-1 alpha-2 code for the destination country (e.g., ID).
- weight: Parcel weight in kilograms, up to three decimal places (e.g., 1.234).
- created_at: Creation timestamp in RFC 3339 format (e.g., 2018-11-20T19:29:32+08:00).
- customer_id: UUID for the customer (e.g., de619854-b59b-425e-9db4-943979e1bd49).
- customer_name: Customer's name (e.g., RedBox Logistics).
- customer_slug: Customer's slug in kebab-case (e.g., redbox-logistics).

#### Response:
- **Success Response** (Status Code: 200)
    json
    {
        "tracking_number": "ABC123456DEF",
        "created_at": "2024-11-11T19:00:00Z"
    }
    
  
- **Error Response** (Status Code: 400)
    json
    {
        "error": "Invalid parameters provided"
    }
    

## Project Structure

├── src
│   ├── main
│   │   ├── java/com/example/tracking
│   │   │   ├── controller        # API controllers
│   │   │   ├── service           # Business logic
│   │   │   ├── model             # Domain models/entities
│   │   │   ├── repository        # Database access layers
│   │   └── resources
│   │       └── application.properties # Configuration settings
└── pom.xml                       # Project dependencies and build config


## Database Setup
The project uses an in-memory H2 database by default. For production, switch to a persistent relational database (e.g., PostgreSQL or MySQL) by updating the application.properties file with the appropriate JDBC URL, username, and password.

## Deployment

This API can be deployed to any cloud platform that supports Java applications. Here are some example deployment methods:
1. Docker: Build a Docker image and deploy it using Kubernetes or a cloud service.
    bash
    docker build -t tracking-number-api .
    docker run -p 8080:8080 tracking-number-api
    
2. Cloud Platforms: Deploy using Heroku, Google App Engine, or AWS Elastic Beanstalk. Follow their documentation for setup.

3. Environment Variables: Set database and server configurations as environment variables for security.

## Usage

Example of a GET request using  curl:
bash
curl -X GET "http://localhost:8080/api/next-tracking-number?origin_country_id=US&destination_country_id=CA&weight=1.234&created_at=2024-11-11T19:00:00Z&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox%20Logistics&customer_slug=redbox-logistics"


## Testing

Run unit and integration tests with Maven:
bash
mvn test


Test coverage includes:
- **API Layer**: Validation of parameter inputs and response format.
- **Service Layer**: Ensuring tracking number uniqueness and format compliance.
- **Concurrency**: Simulate high concurrency for tracking number generation.

## Additional Notes

- **Scaling**: Designed for horizontal scaling. Configure a load balancer to distribute traffic across instances.
- **Concurrency**: Database-level constraints are used to ensure tracking number uniqueness even under high concurrency.
- **Error Handling**: The application returns meaningful error messages for validation errors and system issues.

For further information, contact the repository owner.
