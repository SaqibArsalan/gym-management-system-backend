package com.gym.com.gym.classes.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "sessions")
data class Session(
    @Column(name = "session_date")
    val sessionDate: LocalDate = LocalDate.now(),

    @Column(name = "trainer_id")
    val trainerId: String = "",

    @Column(name = "capacity")
    val capacity: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    val gymClass: GymClass = GymClass()

) : BaseEntity() {
}