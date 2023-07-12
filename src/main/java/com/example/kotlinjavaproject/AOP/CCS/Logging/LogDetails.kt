package com.example.kotlinjavaproject.AOP.CCS.Logging

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "LogDetails")
class LogDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id:Int?=null

    @Column(name = "Log_Status")
    @Enumerated(EnumType.STRING)
    lateinit var logStatus: LogStatus

    @Column
    var parameters: String?=null

    @Column
    var methodName : String?=null

    @Column
    var logDate:Date= Date()

    @Column
    var returnValue:String?=null


}