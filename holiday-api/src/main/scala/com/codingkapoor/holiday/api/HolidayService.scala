package com.codingkapoor.holiday.api

import akka.{Done, NotUsed}

import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait HolidayService extends Service {

  def addHoliday(): ServiceCall[Holiday, Done]

  def deleteHoliday(id: Long): ServiceCall[NotUsed, Done]

  def getHolidays(start: MonthYear, end: MonthYear): ServiceCall[NotUsed, Seq[HolidayRes]]

  override final def descriptor: Descriptor = {
    import Service._
    import MonthYear._

    named("holiday")
      .withCalls(
        restCall(Method.POST, "/api/holidays", addHoliday _),
        restCall(Method.DELETE, "/api/holidays/:id", deleteHoliday _),
        restCall(Method.GET, "/api/holidays?start&end", getHolidays _)
      )
      .withAutoAcl(true)
  }
}
