# Dockerized Hello World Web Service

### What is the purpose of this repo?
You can use this code base as an example of a web service providing simple REST APIs and run it as a docker container

### How to Build
Run one of the following commands based on your OS
* ##### Windows
        $ .\mvnw.cmd clean package
* ##### Linux
        $ .\mvnw clean package

### How to create docker image
* [Download and install docker based on your OS](https://docs.docker.com/get-docker/)
* ##### Run the following command
        $ docker build . -t `YourImageName`

### Run the image

* ##### Run the following command
        $ docker run -p `YourDesirePort`:8080 --name `YourContainerName` -d `YourImageName`

### Examples
After running the docker image you can use the web service as the following:</p>
* `hostIP`:`YourDesirePort`/helloworld
* `hostIP`:`YourDesirePort`/helloworld?name=`YourDesireName`
* `hostIP`:`YourDesirePort`/author
