package ec.edu.uce.TaskList.model;

import jakarta.persistence.*;

@Entity(name = "Tarea")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tittle;
    @Column
    private String description;
    @Column
    private String state;
    @Column
    private String dateCreation;

    public Task() {

    }

    public Task(String tittle, String description, String state, String dateCreation) {
        this.tittle = tittle;
        this.description = description;
        this.state = state;
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", dateCreation='" + dateCreation + '\'' +
                '}';
    }
}
