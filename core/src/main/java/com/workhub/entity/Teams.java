package com.workhub.entity;

import com.workhub.service.Statusable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TEAMS")
public class Teams extends BaseEntity implements Statusable {

    @Column(name = "team_name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "team_leader")
    private String teamLeader;

    //TODO: Map with department entity
//    @JoinColumn(name = "department", referencedColumnName = "id")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Integer department;

    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;

}
