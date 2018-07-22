### Building & Deploying Microservices Using Travis & Heroku based CI/CD Tools 

---
In this article we are going to learn how we can use Travis CI for Continuous Integration and Continuous Deployment (CI/CD) 
of a SpringBoot application. We will learn how to run maven build goals, perform test coverage validation using JaCoCo plugin,
Code Quality checks using SonarCloud, build Docker image and push it to DockerHub and finally deploy it to Heroku.

--- 

[![Build Status](https://travis-ci.org/nitesh009/spring-boot-app.svg?branch=master)](https://travis-ci.org/nitesh009/spring-boot-app)

I have used Travis CI for this project to do all the usual tasks such as:

* Checkout the latest code
* Compile and run Junit and Integration Tests
* Run JaCoCo code coverage and fail the build if desired percentage is not met
* Run SonarQube code quality checks
* Optionally, built Docker image and publish it to Docker Hub
* Deploy application on some free cloud hosting service like Heroku or OpenShift

---

I have used below open source stack for performing all operations-
* GitHub for code repository
* SonarCloud for free SonarQube service
* Docker Hub for publishing Docker images
* Heroku for deploying the application

---
Let us see how we can do all the above mentioned tasks using Travis-CI for a SpringBoot project.

> Steps Involved 

| Step Number     | Operations          |
| -------- | -------------- |
| Step 1: | Create SpringBoot project |
| Step 2: | Create .travis.yml file |
| Step 3: | Enable Travis-CI for GitHub repository |
| Step 4: | Add JaCoCo Code Coverage check |
| Step 5: | Run Unit and Integration Tests |
| Step 6:| SonarQube code quality checks using SonarCloud |
| Step 7:| Build Docker image and publish to DockerHub |
| Step 8:| Deploy to Heroku |

Once the build is successful and deployed on Heroku you should be able to access the application 
at ***https://<app>.herokuapp.com/***

---
> Configurations 

| Services     | Commands          |
| -------- | -------------- |
| Docker compose | docker-compose up |
| Docker build | docker build -t imagename:latest . |
| Docker run | docker run -it imagename |
| Docker push to Docker Hub | docker push nitesh009/spring-boot-app |
| Docker tagging before push | docker tag 6eef95e7abf4 nitesh009/spring-boot-app:initials |
| Deployed App URL on Heroku| https://nk-spring-boot-app.herokuapp.com/ |
| Docker Hub Deployed Image URL| https://hub.docker.com/r/nitesh009/spring-boot-app/ |


---
> Note
  I just covered the most commonly performed tasks in Java applications only, 
  but Travis-CI can perform lot more. 
  Checkout the TravisCI documentation at https://docs.travis-ci.com/.
