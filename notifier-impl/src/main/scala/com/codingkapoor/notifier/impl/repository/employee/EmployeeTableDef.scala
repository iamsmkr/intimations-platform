package com.codingkapoor.notifier.impl.repository.employee

import slick.jdbc.MySQLProfile.api._

final case class EmployeeEntity(empId: Long, empName: String, expoToken: Option[String])

class EmployeeTableDef(tag: Tag) extends Table[EmployeeEntity](tag, "employee") {

  def empId = column[Long]("EMP_ID", O.PrimaryKey)

  def empName = column[String]("EMP_NAME")

  def expoToken = column[Option[String]]("EXPO_TOKEN")

  override def * =
    (empId, empName, expoToken).mapTo[EmployeeEntity]
}

object EmployeeTableDef {
  lazy val employees = TableQuery[EmployeeTableDef]
}
