# AI Freelancer Assistant — Microservices Backend

> A production-grade AI-powered backend platform built with Java Spring Boot microservices, leveraging Google Gemini AI to automate freelancing workflows including proposal generation, dispute resolution and milestone risk analysis.

---

## Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Microservices](#microservices)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Environment Variables](#environment-variables)
- [Docker Setup](#docker-setup)
- [Kubernetes Deployment](#kubernetes-deployment)
- [Project Status](#project-status)

---

## Overview

AI Freelancer Assistant is a backend microservices platform designed to solve real problems faced by freelancers. Instead of spending hours writing proposals, resolving disputes or manually tracking project risks — this platform automates all three using Google Gemini AI through clean, independent REST API microservices.

Each service is fully stateless, independently deployable and communicates through a centralised API Gateway with JWT authentication.

---

## Architecture

```
Client (Postman / Swagger UI)
            │
            ▼
┌─────────────────────────┐
│      API Gateway         │  ← Port 8080
│  (Spring Cloud Gateway)  │  ← JWT Validation
│  (Spring Cloud Gateway)  │  ← Request Routing
└─────────┬───────────────┘
          │
    ┌─────┴──────┐
    ▼            ▼
┌────────┐  ┌────────────────────────────────────┐
│  Auth   │  │         AI Microservices            │
│ Service │  │                                    │
│ :8084  │  │  ┌──────────┐  ┌──────────┐  ┌──────────┐ │
└────────┘  │  │ Proposal  │  │ Dispute  │  │  Risk    │ │
            │  │ Generator │  │ Analyser │  │Predictor │ │
            │  │  :8081    │  │  :8082   │  │  :8083   │ │
            │  └─────┬─────┘  └────┬─────┘  └────┬─────┘ │
            └────────┼─────────────┼──────────────┼───────┘
                     └─────────────┼──────────────┘
                                   ▼
                          Google Gemini AI API
```

---

## Microservices

### 1. Smart Proposal Generator — Port 8084
Generates professional client proposals automatically based on project requirements using Gemini AI.

**Endpoint:**
```
POST /api/proposal/generate
```

**Request:**
```json
{
  "projectTitle": "E-commerce Website",
  "description": "Build a full stack web application",
  "budget": 500,
  "clientName": "John Smith",
  "skills": ["Django", "React", "PostgreSQL"]
}
```

**Response:**
```json
{
  "generatedProposal": "Dear John Smith, I am pleased to submit my proposal..."
}
```

---

### 2. Smart Invoice Dispute Analyser — Port 8083
Analyses freelancer-client disputes using AI and provides fair resolution recommendations based on contract terms and both party arguments.

**Endpoint:**
```
POST /api/dispute/resolve
```

**Request:**
```json
{
  "disputeDescription": "Client claims work was not delivered on time",
  "freelancerArgument": "Delays were caused by late client feedback",
  "clientArgument": "Feedback was provided within agreed timeline",
  "contractTerms": "Delivery within 14 days after requirements finalised"
}
```

**Response:**
```json
{
  "resolution": "Based on the contract terms provided...",
  "recommendation": "Partial milestone payment suggested",
  "reasoning": "Both parties share responsibility due to..."
}
```

---

### 3. Milestone Risk Predictor — Port 8082
Analyses current milestone progress and predicts delay risks using AI, providing actionable suggestions to keep projects on track.

**Endpoint:**
```
POST /api/risk/analyse
```

**Request:**
```json
{
  "milestoneName": "Backend API Development",
  "deadline": "2026-06-01",
  "completionPercentage": 30,
  "daysElapsed": 20,
  "totalDays": 30,
  "pastDelays": 2
}
```

**Response:**
```json
{
  "riskLevel": "HIGH",
  "riskScore": 85,
  "analysis": "At current pace, milestone will likely miss deadline",
  "suggestions": [
    "Break remaining tasks into smaller chunks",
    "Communicate delay risk to client immediately"
  ]
}
```

---

### 4. API Gateway — Port 8080 *(In Progress)*
Centralised entry point for all microservices. Handles JWT token validation and request routing.

- Routes all incoming requests to correct microservice
- Validates JWT tokens on every protected request
- Aggregates Swagger documentation for all services
- Single URL for entire platform

---

### 5. Auth Service — Port 8081 *(In Progress)*
Handles user registration, login and JWT token generation and validation.

**Endpoints:**
```
POST /api/auth/register
POST /api/auth/login
GET  /api/auth/validate
```

---

## Tech Stack

| Category | Technology |
|---|---|
| **Primary Language** | Java 21 |
| **Framework** | Spring Boot |
| **AI Integration** | Google Gemini AI API |
| **API Gateway** | Spring Cloud Gateway |
| **Security** | Spring Security + JWT |
| **Database** | PostgreSQL, MongoDB |
| **Containerisation** | Docker + Docker Compose |
| **Orchestration** | Kubernetes |
| **CI/CD** | GitHub Actions |
| **API Documentation** | Swagger / OpenAPI |
| **Deployment** | Render |

---

## Getting Started

### Prerequisites

Make sure you have installed:
- Java 21
- Maven
- Docker + Docker Compose
- PostgreSQL
- A Google Gemini API key — get one free at [https://makersuite.google.com](https://makersuite.google.com)

---

### Clone the Repository

```bash
git clone https://github.com/zicots7/ai-freelancer-assistant.git
cd ai-freelancer-assistant
```

---

### Set Up Environment Variables

Create a `.env` file in the root directory:

```env
GEMINI_API_KEY=your_gemini_api_key_here
JWT_SECRET=your_jwt_secret_key_here
DB_USERNAME=postgres
DB_PASSWORD=your_password_here
AUTH_DB_URL=jdbc:postgresql://localhost:5432/auth_db
```

> Never commit your `.env` file — it is already in `.gitignore`

---

### Run Individual Services Locally

Each service can be run independently:

```bash
# Proposal Generator
cd SmartProposal
mvn spring-boot:run

# Dispute Analyser
cd SmartInvoiceDisputeAnalyser
mvn spring-boot:run

# Risk Predictor
cd MilestoneRiskPredictor
mvn spring-boot:run
```

---

### Startup Order — Important

Always start services in this order:

```
1. auth-service           (Port 8081)
2. SmartProposal          (Port 8084)
3. SmartInvoiceDisputeAnalyser  (Port 8083)
4. MilestoneRiskPredictor (Port 8082)
5. AiFreelanceAssistantGateway  (Port 8080) ← Always last
```

---

## API Documentation

Each service has Swagger UI available locally:

| Service | Swagger URL |
|---|---|
| API Gateway (all services) | http://localhost:8080/swagger-ui.html |
| Auth Service | http://localhost:8081/swagger-ui.html |
| Risk Predictor | http://localhost:8082/swagger-ui.html |
| Dispute Analyser | http://localhost:8083/swagger-ui.html |
| Proposal Generator | http://localhost:8084/swagger-ui.html |


---

## Environment Variables

| Variable | Description | Required |
|---|---|---|
| `GEMINI_API_KEY` | Google Gemini AI API key | ✅ All AI services |
| `JWT_SECRET` | Secret key for JWT signing | ✅ Auth + Gateway |
| `DB_USERNAME` | PostgreSQL username | ✅ Auth service |
| `DB_PASSWORD` | PostgreSQL password | ✅ Auth service |
| `AUTH_DB_URL` | PostgreSQL connection URL | ✅ Auth service |
| `PROPOSAL_SERVICE_URL` | URL for proposal service | ✅ Gateway |
| `DISPUTE_SERVICE_URL` | URL for dispute service | ✅ Gateway |
| `RISK_SERVICE_URL` | URL for risk service | ✅ Gateway |
| `AUTH_SERVICE_URL` | URL for auth service | ✅ Gateway |

---

## Docker Setup

Run all services together with Docker Compose:

```bash
# Build and start all services
docker-compose up --build

# Run in background
docker-compose up -d

# Stop all services
docker-compose down
```

---

## Kubernetes Deployment

Kubernetes manifests are available in the `/K8s` directory:

```bash
# Apply all Kubernetes configs
kubectl apply -f K8s/

# Check running pods
kubectl get pods

# Check services
kubectl get services
```

Kubernetes handles service discovery automatically — no external service registry needed.

---

## Project Status

| Service | Status |
|---|---|
| Smart Proposal Generator | ✅ Complete — tested via Postman |
| Smart Invoice Dispute Analyser | ✅ Complete — tested via Postman |
| Milestone Risk Predictor | ✅ Complete — tested via Postman |
| API Gateway | 🔄 In Progress |
| Auth Service | 🔄 In Progress |
| Docker Compose | ✅ Complete |
| Kubernetes Configs | ✅ Complete |
| CI/CD Pipeline | ✅ Complete |
| Production Deployment | ✅ Complete Partially without gateway |

---

## Author

**Trinankur Samanta**
MCA Student — Kazi Nazrul University, West Bengal

- GitHub: [github.com/zicots7](https://github.com/zicots7)
- LinkedIn: [linkedin.com/in/trinankur-s](https://www.linkedin.com/in/trinankur-s/)
- Fiverr: [fiverr.com/s/1q5NKG6](https://www.fiverr.com/s/1q5NKG6)

---

> This project demonstrates production-grade microservices architecture with AI integration — built as part of my portfolio while pursuing MCA. All three AI services are fully functional and tested. Gateway and Auth service currently in active development.
