### Spring JPA Example

Following steps are taken to configure the Spring with JPA:

#### Steps
1. Create a Spring boot project from the spring initializer.
2. Add dependencies for spring JPA, H2 database and web.
3. Update the `application.properties` file to include the database connection details.
4. Add SQL scripts in `data.sql` file to insert the initial data when the application runs.
5. Create a class that represents the database table. Annotate the class with `@Entity` to map it with the database table. To mark a column as the primary key, annotate the column with `@Id`, and `@GeneratedValue` to make sure that the ID is auto generated.
6. Create a repository class. Annotate the class with `@Repository` to let the spring create the bean for the class. To access the datalayer, inject the `EntityManager` class to the repository.


##### Create Spring boot project:
You can create the spring boot project directly from the Intelij Idea or from the [spring initializer site](https://start.spring.io/).

#### Add following dependencies to the `pom.xml` file
```xml
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
```

#### Add following configuration information in `application.properties` file
```text
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
spring.data.jpa.repositories.bootstrap-mode=default
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
```

#### Create a class to represent the database table
```java
@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String location;
    private Date birthDate;

    public Person() {
    }

    public Person(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

```

#### Add the repository class to access the database
```java
@Repository
public class PersonJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person findById(Integer id) {
        return entityManager.find(Person.class, id);
    }
}

```