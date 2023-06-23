package com.codemind.MappingsDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubrChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetails",cascade = CascadeType.ALL)
    private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public InstructorDetails() {
    }

    public InstructorDetails(String youtubrChannel, String hobby) {
        this.youtubrChannel = youtubrChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubrChannel() {
        return youtubrChannel;
    }

    public void setYoutubrChannel(String youtubrChannel) {
        this.youtubrChannel = youtubrChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubrChannel='" + youtubrChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
