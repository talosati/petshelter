<h1 align="center">Spring project using Thymeleaf and SQL database</h1>

<p align="center">
<a href="https://github.com/badges/shields/graphs/contributors" alt="Contributors">
        <img src="https://img.shields.io/github/languages/code-size/talosati/petshelter" /></a>
<a href="https://github.com/badges/shields/graphs/contributors" alt="Contributors">
        <img src="https://img.shields.io/github/stars/talosati/petshelter?style=social" /></a>
<a href="https://github.com/badges/shields/graphs/contributors" alt="Contributors">
        <img src="https://img.shields.io/github/forks/talosati/petshelter?style=social" /></a>
</p>

<p align="center">
<img src="https://github.com/talosati/petshelter/blob/main/readme_assets/humen.png" alt="humen" height="400"/>
</p>

<h2>Description</h2>
<p align="justify">You can check list of owners and their pets, edit or delete data of stored items. Java backend using Thymeleaf to making dynamic HTML templates for displaying results. The added owners and pets are stored in a SQL database, handled by Hibernate ORM. 
App is deployed using Heroku.</p>

<p align="center">
<img src="https://github.com/talosati/petshelter/blob/main/readme_assets/pets.png" alt="pets" height="400"/>
</p>

<h2>Framework, tools :muscle: :muscle:</h2> 
<ul>
  <li><a href="https://docs.spring.io/spring-boot/docs/2.2.7.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data">Spring Boot</a></li>
  <li><a href="https://docs.gradle.org/current/userguide/userguide.html">Gradle</a></li>
  <li><a href="https://hibernate.org/">Hibernate</a></li></li>
  <li><a href="https://www.thymeleaf.org/">Thymeleaf</a></li></li>
  <li><a href="https://devcenter.heroku.com/">Heroku</a></li></li>
</ul>

<h2>MVC</h2>
<p align="justify">Code is structured by MVC concept, using dependency injection.</p>
<pre>
 ┬  
 ├ controllers
 ├ dtos  
 ├ models  
 ├ repositories  
 ├ services  
</pre>

```
  @Autowired
  public MainController(HumanService humanService,
                        PetService petService) {
    this.humanService = humanService;
    this.petService = petService;
  }
```

<h2>Hibernate</h2>
<p align="center">
<img src="https://github.com/talosati/petshelter/blob/main/readme_assets/newPet.png" alt="newPet" height="400"/>
</p>
<p align="justify">Hibernate ORM can create tables in our SQL database, handle relation between tables, save data into database, get data from database, update or delete stored records. Here you can see a few example for queries:</p>

```
Optional<Pet> findByPetName(String petName);

@Query(value = "SELECT * FROM pet", nativeQuery = true)
List<Pet> getAllPets();
```

<h2>Thymeleaf</h2>
<p align="justify">Thymeleaf allow using conditional fragments that help us also to display error messages if input data isn't correct.</p>
<p align="center">
<img src="https://github.com/talosati/petshelter/blob/main/readme_assets/validator.png" alt="newPet" height="400"/>
</p>

```
<p1 th:if="${invalidHumanData}" style="color: red">"Something went wrong, please check if the fields are filled out
        or use another name, because the name is already taken"</p1>
<form class="title" th:action="@{/add-human}" method="POST">
    <div class="form-row">
        <div class="col-7">
            <input type="text" class="form-control" placeholder="Name of human" th:field="${human.humanName}">
        </div>
    </div>
    <button type="submit" class="btn btn-outline-danger">ADD</button>
</form>
```

<h2>Heroku :fire:</h2>
<p align="justify">App is deployed to Heroku. You can see my app <a href="https://petshelter-spring.herokuapp.com/" target="_blank">here</a>.</p>

<h2 align="center">Thank you for reading! :wave:</h2>


