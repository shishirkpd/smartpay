# Smartcloud instance prices API

**Important: Do NOT fork this repository if you want to submit a solution.**

Imagine we run our infrastructure on a fictional cloud provider, Smartcloud. As their machine instance prices fluctuate all the time, Smartcloud provides an API for us to retrieve their prices in real time. This helps us in managing our cost.

# Requirements

Implement an API for fetching and returning machine instance prices from Smartcloud.

```
GET /prices?kind=sc2-micro
{"kind":"sc2-micro","amount":0.42}, ... (omitted)
```

This project scaffold provides an end-to-end implementation of an API endpoint which returns some dummy data. You should try to follow the same code structure.

You should implement `SmartcloudPriceService` to call the [smartcloud](https://hub.docker.com/r/smartpayco/smartcloud) endpoint and return the price data. Note that the smartcloud service has usage quota and may return error occassionally to simulate unexpected errors. Please make sure your service is able to handle the constraint and errors gracefully.

You should also include a README file to document:-
1. Any assumptions you make
1. Any design decisions you make
1. Instruction on how to run your code

You should use git and make small commits with meaningful commit messages as you implement your solution.

# Setup

Follow the instruction at [smartcloud](https://hub.docker.com/r/smartpayco/smartcloud) to run the Docker container on your machine.

Clone or download this project onto your machine and run

```
$ sbt run
```

The API should be running on your port 8080.

# How to submit

Please push your code to a public repository and submit the link via email. Please do not fork this repository.


# How to run
### Steps to follow
1. SmartCloud should be up and running, use below command to run smartcloud
```
docker run -p 9999:9999 smartpayco/smartcloud:latest
```
2. Run the smartcloud-prices code by using below command
```
$ sbt run
```
3. Access api using below urls
#### API GET /instance-kinds
Get all running instance kind [getAllInstances](http://localhost:8080/instance-kinds)
```
http://localhost:8080/instance-kinds
```
 Response example
```json
[ { "kind": "sc2-micro" }, 
  { "kind": "sc2-small" },
  { "kind": "sc2-medium" },
  { "kind": "sc2-std-2" },
  { "kind": "sc2-std-4" },
  { "kind": "sc2-std-8" },
  { "kind": "sc2-std-16" },
  { "kind": "sc2-std-32" },
  { "kind": "sc2-himem-2" },
  { "kind": "sc2-himem-4" },
  { "kind": "sc2-himem-8" },
  { "kind": "sc2-himem-16" },
  { "kind": "sc2-himem-32" },
  { "kind": "sc2-hicpu-2" },
  { "kind": "sc2-hicpu-4" },
  { "kind": "sc2-hicpu-8" },
  { "kind": "sc2-hicpu-16" },
  { "kind": "sc2-hicpu-32" }
]
```
#### API GET /prices?kind=sc2-micro
Get price of given instance kind [getPriceOfKind](http://localhost:8080/instance-kinds/prices?kind=sc2-himem-2)
```text
http://localhost:8080/instance-kinds/prices?kind=sc2-himem-2
```
Response example
```json
{
  "kind": "sc2-micro",
  "price": 0.883,
  "timestamp": "2022-01-08T13:09:13.917Z"
}
```