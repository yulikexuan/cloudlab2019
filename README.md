# The Cloud Lab

### Microservice Patterns and Spring Cloud

Implementing all these patterns from scratch would be a tremendous amount of
work

Fortunately, the Spring team has integrated a wide number of battletested
open source projects into a Spring subproject collectively known as Spring
Cloud

Spring Cloud wraps the work of open source companies such as Pivotal, 
HashiCorp, Netflix in delivering patterns

Spring Cloud simplifies setting up and configuring of these projects into your 
Spring application so that you can focus on writing code, not getting buried in 
the details of configuring all the infrastructure that can go with building and 
deploying a microservice application


#### Core Development Pattern (chap 02, 03, 08)
  - Service Granularity (chap 02) **[Domain Driven Design]**
  - Communication Protocols (chap 02)  **[Spring-Boot]**
  - Interface Design (chap 02)  **[Spring-Boot]**
  - Configuration Management of Services (chap 03)  **[Spring Cloud Config]**
  - Event Processing Between Services (chap 08) **[Spring Cloud Stream]**
  
#### Discovery and Routing Patterns (chap 04, 06)
  - Service Discovery (chap 04) **[Spring-Cloud / Netflix Eureka]**
  - Service Routing (chap 06) **[Spring-Cloud / Netflix Zuul]**

#### Client Resiliency Patterns (chap 05)
  - Client-Side Load Balancing **[Spring-Cloud / Netflix Ribbon]**
  - Circuit Breakers Pattern **[Spring-Cloud / Netflix Hystrix]**
  - Fallback Pattern **[Spring-Cloud / Netflix Hystrix]**
  - Bulkhead Pattern **[Spring-Cloud / Netflix Hystrix]**

#### Security Patterns (chap 07)
  - Authentication **[Spring-Cloud Security / OAuth2]**
  - Authorization **[Spring-Cloud Security / OAuth2]**
  - Credential Management and Propagation     
    **[Spring-Cloud Security / OAuth2 / JWT]**

#### Logging and Tracing Patterns (chap 09)
  - Log Correlation **[Spring-Cloud Sleuth]**
  - Log Aggregation **[Spring-Cloud Sleuth with Papertrail]**
  - Transaction Tracing **[Spring-Cloud Sleuth with Zipkin]**

#### Build / Deployment Patterns (chap 10)
  - Build and Deployment Pipeline **[CircleCI-CD / Docker / Travis CI]**
  - Infrastructure as Code **[Docker]**
  - Immutable Servers **[Docker]**
  - Phoenix Servers [ˈfinɪks] **[CircleCI-CD / Docker / Travis CI]**

1. Core Development Pattern

    - Service Granularity **[Domain Driven Design]**
  
      - What is the right level of responsibility the service should have?
    
      - How to approach decomposing a business domain down into microservices 
        so that each microservice has the right level of responsibility?
      
        - Making a service too coarse-grained with responsibilities that 
          overlap into different business problems domains makes the service 
          difficult to maintain and change over time
  
        - Making the service too fine-grained increases the overall complexity 
          of the application and turns the service into a “dumb” data 
          abstraction layer with no logic except for that needed to access the 
          data store

      - Keep learning [chap 2] ... ...
    
    - Communication Protocols **[Spring-Boot]**
  
      - How will developers communicate with services?
      
      - Keep learning [chap 2] ... ...
    
    - Interface Design **[Spring-Boot]**

      - What’s the best way to design the actual service interfaces that
        developers are going to use to call services? 
        
      - How to structure service URLs to communicate service intent? 
      
      - What about versioning services?
        
        - A well-design microservice interface makes using services intuitive
      
      - Keep learning [chap 2] ... ... 
      
    - Configuration Management of Services **[Spring Cloud Config]**
    
      - How to manage the configuration of microservices so that as it moves 
        between different environments in the cloud but never have to change 
        the core application code or configuration? 
        
      - Use @RefreshScope with the class which has reference to config 
        properties in order to refresh config properties
      
        - Reference config properties    
          ```
          @Value("${example.property}")
          private String exapleProperty;
          ```
      - Keep learning [chap 3] ... ... 
      
    - Event Processing Between Services **[Spring Cloud Stream]**
    
      - How to decouple microservices using events in order to minimize 
        hardcoded dependencies between services and increase the resiliency 
        of the whole application?

      - Keep learning [chap 8] ... ... 

2. Discovery and Routing Patterns

     How a client application that wants to consume a microservice discovers 
     the location of the service and is routed over to it
     
     These two patterns aren’t dependent on one another
  
    - Service Discovery **[Spring-Cloud / Netflix Eureka]**
    
      - How to make microservices discoverable so client applications can find 
        them without having the location of the service hardcoded into the 
        application?
        
      - How to ensure that misbehaving microservice instances are removed from 
        the pool of available service instances?
        
      - Service discovery abstracts away the physical location of the service 
        from the client
        
      - New microservice instances can be added to scale up
      
      - Unhealthy service instances can be transparently removed from the 
        services
        
      - Keep learning [chap 4] ... ... 

    - Service Routing **[Spring-Cloud / Netflix Zuul]**
    
      - How to provide a single entry point for all services so that security 
        policies and routing rules are applied uniformly to multiple services
        and service instances in microservice applications?
        
      - How to ensure that each developer in the team doesn’t have to come up 
        with their own solutions for providing routing to their services?
        
      - Service routing gives the microservice client a single logical URL to 
        talk to and acts as a policy enforcement point for things like 
        authorization, authentication, and content checking
        
      - Keep learning [chap 6] ... ... 

3. Client Resiliency Patterns

    Because microservice architectures are highly distributed, developers have 
    to be extremely sensitive in how to prevent a problem in a single service 
    (or service instance) from ascading up and out to the consumers of the 
    service

    - Client-Side Load Balancing **[Spring-Cloud / Netflix Ribbon]**
    
      - How to cache the location of service instances on the service client 
        so that calls to multiple instances of a microservice are load balanced 
        to all the health instances of that microservice?
        
      - The service client caches microservice endpoints retrieved from the 
        service discovery and ensures that the service calls are load balanced 
        between instances
        
    - Circuit Breakers Pattern **[Spring-Cloud / Netflix Hystrix]**
    
      - How to prevent a client from continuing to call a service that’s 
        failing or suffering performance problems? 
        
      - When a service is running slowly, it consumes resources on the client 
        calling it
        
      - It must be better to make failing microservice calls **fail fast** so 
        that the calling client can quickly respond and take an appropriate 
        action
        
      - The circuit breaker pattern ensures that a service client does not 
        repeatedly call a failing service
        
      - Instead, a circuit breaker "fails fast" to protect the client
        
    - Fallback Pattern **[Spring-Cloud / Netflix Hystrix]**
    
      - When a service call fails, how to provide a “plug-in” mechanism that 
        will allow the service client to try to carry out its work through 
        alternative means other than the microservice being called?
        
      - When a client does fail, is there an alternative path the client can
        take to retrieve data from or take action with
        
    - Bulkhead Pattern **[Spring-Cloud / Netflix Hystrix]**
    
      - Microservice applications use multiple distributed resources to carry 
        out their work
        
      - How to compartmentalize these calls so that the misbehavior of one 
        service call doesn’t negatively impact the rest of the application?
        
        - Compartmentalize: to divide something into separate sections, 
          especially so that one thing does not affect the other
          
      - How do you segregate different service calls on a client to make sure 
        one misbehaving service does not take up all the resources on the 
        client?
        
    - Keep learning [chap 5] ... ... 

4. Security Patterns

    - Authentication **[Spring-Cloud Security / OAuth2]**
    
      - How to determine the service client calling the service is who they say 
        they are?
    
    - Authorization **[Spring-Cloud Security / OAuth2]**
      
      - How to determine whether the service client calling a microservice is 
        allowed to undertake the action they’re trying to undertake?
      
    - Credential Management and Propagation 
      
      **[Spring-Cloud Security / OAuth2 / JWT]**
    
      - How to prevent a service client from constantly having to present their 
        credentials for service calls involved in a transaction?
      
      - Specifically, how token-based security standards such as OAuth2 and 
        JavaScript Web Tokens (JWT) can be used to obtain a token that can
        be passed from service call to service call to authenticate and 
        authorize the user
        
        - By using a token-based security scheme, it's possible to implement 
          service authentication and authorization without passing around 
          client credentials
  
    - Keep learning [chap 7] ... ... 
    
5. Logging and Tracing Patterns 

    The downside of a microservice architecture is that it’s much more 
    difficult to debug and trace what the heck is going on within the 
    application and services

    - Log Correlation **[Spring-Cloud Sleuth]**
    
      - How to tie together all the logs produced between services for a single 
        user transaction?
        
      - How to implement a correlation ID, which is a unique identifier that 
        will be carried across all service calls in a transaction and can be 
        used to tie together log entries produced from each service
        
      - Make all service log entries have a correlation ID that ties the log 
        entry to a single transaction
        
    - Log Aggregation **[Spring-Cloud Sleuth with Papertrail]**
    
      - How to pull together all of the logs produced by the microservices 
        (and their individual instances) into a single queryable database
        
      - How to use correlation IDs to assist in searching the aggregated logs
      
      - An aggregation mechanism collects all of the logs from all the services 
        instances
        
      - As data comes into a central data store, it is indexed and stored in a 
        searchable format
      
    - Transaction Tracing **[Spring-Cloud Sleuth with Zipkin]**
    
      - How to visualize the flow of a client transaction across all the 
        services involved and understand the performance characteristics of 
        services involved in the transaction
        
      - The development and operations teams can query the log data to find 
        individual transactions
        
        - They should also be able to visualize the flow of all the services 
          involved in a transaction
        
    - Keep learning [chap 9] ... ... 
    
6. Build / Deployment Patterns

    One of the core parts of a microservice architecture is that each instance 
    of a microservice should be identical to all its other instances
    
    “Configuration Drift” (something changes on a server after it’s been 
    deployed) is not allowed to occur, because this can introduce instability 
    in applications
    
    An immutable infrastructure is a critical piece of successfully using a 
    microservice architecture, because you have to guarantee in production that 
    every microservice instance you start for a particular microservice is 
    identical to its brethren (brothers)

    The goal is to integrate the configuration of the infrastructure right into
    the build-deployment process so that we no longer deploy software artifacts 
    such as a Java WAR or EAR to an already-running piece of infrastructure
    
    **Instead, build and compile a microservice and the virtual server images 
      it is running on as part of the build proces**
    
    Then, when a microservice get deployed, the entire machine image with the 
    server running on it gets deployed
    
    - Build and Deployment Pipeline **[CircleCI-CD / Docker / Travis CI]**
    
      - How to create a repeatable build and deployment process that 
        emphasizes one-button builds and deployment to any environment 
        
      - The deployment of the microservice and the server it’s running on must 
        to be one atomic artifact that’s deployed as a whole between 
        environments
        
    - Infrastructure as Code **[Docker]**
    
      - How to treat the provisioning (configration) of your services as code
        that can be executed and managed under source control
        
      - The code of microservices is built 
      
      - The test of microservices is run
      
      - The infrastructure of microservices should also be treated as code 
      
        - When the microservices is compiled and packaged, a vurtual server or 
          container image with the microservice installed on it should also be
          baked and provisioned
      
    - Immutable Servers **[Docker]**
    
      - Once a microservice image is created, how to ensure that it’s never 
        changed after it has been deployed?
        
      - The moment an image is baked and deployed, no developer or system
        administrator is allowed to make modifications to the servers
        
      - When promoting between environments, the entire container or image
        is started with environment-specific variables that are passed to the 
        server when the server is first started
        
    - Phoenix Servers [ˈfinɪks] **[CircleCI-CD / Docker / Travis CI]**
    
      - The longer a server is running, the more opportunity for configuration
        drift 
        
      - How to ensure that servers that run microservices get torn (tear) down 
        on a regular basis (定期) and recreated off an immutable image?
        
      - Because the actual servers are constantly being torn down as part of
        the continous integration process, new servers are being started and 
        torn down
        
        - This greatly decreases the change of configuration drift between 
          environments
     
     - Keep learning [chap 10] ... ...  
     
### the Core Principles and Patterns needed to Manage App Config Data in a Cloud-Based Microservice Application

#### The Tranditional Way: 
   Placing configuration file (*.properties, *.yml) under source control 
   (if that) and deploying it as part of their application, this approach might 
   work with a small number of applications, but it quickly falls apart when 
   dealing with cloud-based applications that may contain hundreds of 
   microservices, where each microservice in turn might have multiple service 
   instances running
   
#### The Goal
  1. Completely separating the configuration of an application from the actual 
     code being deployed
  2. Building the server and the application and an immutable image that never
     changes as it’s promoted through your environments
  3. Injecting any application configuration information at startup time of the
     server through either environment variables or through a centralized 
     repository the application’s microservices read on startup
     
#### Four Principles
  1. Segregate
     - Completely separate the services configuration information from the actual 
     physical deployment of a service
     - Application configuration shouldn’t be deployed with the service instance
     - Instead, configuration information should either be passed to the starting 
     service as environment variables or read from a centralized repository when 
     the service starts
  2. Abstract
     - Abstract the access of the configuration data behind a service interface
       rather than writing code that directly accesses the service repository 
       (that is, read the data out of a file or a database using JDBC), have the 
       application use a REST-based JSON service to retrieve the configuration 
       data
  3. Centralize
     - Because a cloud-based application might literally have hundreds of
       services, it’s critical to minimize the number of different repositories 
       used to hold configuration information
     - Centralize your application configuration into as few repositories as 
       possible
     - The application configuration data needs to be tracked and 
       version-controlled because mismanaged application configuration is a 
       fertile breeding ground for difficult-todetect bugs and unplanned outages
  4. Harden
     - Because your application configuration information is going to be
       completely segregated from your deployed service and centralized, it’s 
       critical that whatever solution you utilize can be implemented to be 
       highly available and redundant
       
#### Spring Cloud Configuration Server
  - RESTful web service based application built on Spring-Boot
  - Easy to use and intergrated with Spring-Boot and Git
  
