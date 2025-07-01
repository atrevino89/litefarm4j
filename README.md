This README file is not only a description of this repo's content but an explanation of what I'm doing and why.

# Litefarm4j

This is complete rewrite and rethink of Litefarm's API.

## where am I coming from... ?

### The project:
[Litefarm](https://github.com/LiteFarmOrg/LiteFarm) is a great open source project, baked by a well reputed university with a small and awesome core team.
They allow you to collaborate in any possible yet responsible way. Even though I haven't been an active collaborator, I really like the project, their vision and its people.

### The stack:
The actual Litefarm's API is written in NodeJs with Express.Js using the classic and powerful MVC architecture, 
some bits of code are shared to use in both backend and frontend, some portions are written in TS but JS is the dominant programming language/syntax.
It uses different tools such as:
- Knex and Objection to communicate with the DB
- SDKs for AWS S3 and google maps.
- Swagger / OpenAPI specs
- big etc.

### The problem:
Well, there's no real problem as the API is written in certain way that just works,
but PERSONALLY I find it a bit difficult to extend and collaborate.

### The proposal:
- Use a robust architecture (I picked Hexagonal architecture / ports and adapters).
- Design differently the core of the API through Domain-driven design.
- Write the API in a more "formal" and scalable language (I picked Java 17+).
- Use battle tested tools and frameworks like Spring Boot, Hibernate, 
- Use heavily interfaces / contracts and design patterns (where applies)
- Implement other development practices such as Test-driven development, SOLID, KISS, YAGNI, etc etc
- if possible use Event-driven architecture and Kafka 

### Proposal reasoning:
The real reason behind this it's because I think is easier to collaborate in such environment where 
standards and practices are well propagated through a project, choosing what others companies are using is not always the best
for the project but this can be used as a trampoline to learn, gain experience and transfer the knowledge to other open source projects. 
Also, when I was (and still) learning these things I didn't find many production grade open source projects with such characteristics, technologies and architecture, 
I think it's a good opportunity to create a project from scratch, use the idea of an awesome and existing project like Litefarm and who knows maybe with the time this could
be their next production API.


## ROADMAP

### Develop core domain / business logic - CURRENTLY IN PROGRESS
- [ ] Farm management
- [ ] Locations
- [ ] Tasks
- [ ] Crops
- [ ] Crop planning
- [ ] People

### Develop application layer
- [ ] Create use cases for each of the domain aggregate root

### Develop the infrastructure layer
- [ ] Implement REST endpoints for the available use cases
- [ ] Adapter for Cloud functions entry points (AWS Lambda or GCP Cloud functions)
- [ ] Adapter for CLI (specially to load fixtures or configurations into the DB)

### CI/CD
- [ ] GH Actions pipeline to run tests and package project

## Future:
### More domain and business logic
- [ ] Animals
- [ ] Documents
- [ ] Certifications
- [ ] Finances
- [ ] Insights

I'm mapping little by little the components and some requirements in an [Excalidraw](https://excalidraw.com/#json=h6yFzTRlHCjs2OWoYlArR,aiGMbcMSuocpJ175l554jw) diagram that I'll try to keep updated.