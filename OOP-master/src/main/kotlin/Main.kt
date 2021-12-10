import java.util.*

abstract class Employee(
    var firstName: String,
    var lastName: String,
    var exp: Int,
    var baseSalary: Double,
    var myManager: String
){

    open fun giveSalary(): Double{
if (exp > 2 && exp <= 5)
    baseSalary = baseSalary + 200
       else if (exp > 5)
           baseSalary = (baseSalary * 1.2) + 500
        return baseSalary
    }
}

class Developer(
    firstName: String,
    lastName: String,
    exp: Int,
    baseSalary: Double,
    myManager: String
) : Employee (firstName, lastName, exp, baseSalary, myManager){

}
class Designer (
    firstName: String,
    lastName: String,
    exp: Int,
    baseSalary: Double,
    myManager: String,
    var coef: Double
): Employee (firstName, lastName, exp, baseSalary, myManager){
    override fun giveSalary(): Double {
    return super.giveSalary() * coef
}
}


class Manager (
    firstName: String,
    lastName: String,
    exp: Int,
    baseSalary: Double,
    var team: MutableList<Employee> = mutableListOf()


): Employee (firstName, lastName, exp, baseSalary, myManager = "Null" ){
    fun teams(){team.forEach { Employee ->
        if (Employee.myManager == this.firstName)
            team.add(Employee)

    }}
    override fun giveSalary(): Double {
        val devCount = team.filterIsInstance<Developer>().count()
        val designerCount = team.filterIsInstance<Designer>().count()

        if (devCount > designerCount)
            return super.giveSalary() * 1.1 // baseSalary = baseSalary * 1.1
        if (devCount + designerCount > 5 && devCount + designerCount <= 10)
            return super.giveSalary() + 200 // baseSalary = baseSalary + 200
        if (devCount + designerCount > 10)
            return super.giveSalary() + 300
        return super.giveSalary()
    }}



class Department(
    var managers: MutableList<Manager> = mutableListOf()
){
    fun giveAllSalary(){
        managers.forEach { manager ->
        manager.giveSalary()
        manager.team.forEach { employee ->
        employee.giveSalary()
        }
        }
    }

}


fun main(){
 val dev1 = Developer("Andriy","Sheva",2, 3000.0, "Paul")
 val dev2 = Developer("Anton","Ostapov",4, 1200.0, "Paul")
val dev3 = Developer("John","Cena",6, 6500.0, "Dima")
    val dev4 = Developer("Dvane","Johnson",8, 8700.0, "Paul")
    val dev5 = Developer("Avraam","Lincoln",10, 3400.0, "Dima")
    val dev6 = Developer("Sofia","Pavlenko",12, 1200.0, "Paul")
    val dev7 = Developer("Sebastian","Kastellanos",16, 4300.0, "Paul")

    val designer1 = Designer("Robert", "DeNiro",3, 6200.0, "Dima", 0.4,)
    val designer2 = Designer("Vasiliy", "Lomachenko",6, 1500.0,"Dima", 0.5)
    val designer3 = Designer("Don", "Karleone",9, 9000.0,"Paul", 0.6)
    val designer4 = Designer("Dominic", "Torreto",12, 5000.0,"Paul", 0.7)

val manager1 = Manager("Paul", "Panch",7, 3000.0, mutableListOf())
val manager2 = Manager("Dima", "Dimich",7, 6000.0, mutableListOf())


println("Salary of " + dev1.firstName + " " + dev1.lastName + " : " + dev1.giveSalary())
    println("Salary of " + dev2.firstName + " " + dev2.lastName + " : " + dev2.giveSalary())
    println("Salary of " + dev3.firstName + " " + dev3.lastName + " : " + dev3.giveSalary())
    println("Salary of " + dev4.firstName + " " + dev4.lastName + " : " + dev4.giveSalary())
    println("Salary of " + dev5.firstName + " " + dev5.lastName + " : " + dev5.giveSalary())
    println("Salary of " + dev6.firstName + " " + dev6.lastName + " : " + dev6.giveSalary())
    println("Salary of " + dev7.firstName + " " + dev7.lastName + " : " + dev7.giveSalary())

    println("Salary of " + designer1.firstName + " " + designer1.lastName + " : " + designer1.giveSalary())
    println("Salary of " + designer2.firstName + " " + designer2.lastName + " : " + designer2.giveSalary())
    println("Salary of " + designer3.firstName + " " + designer3.lastName + " : " + designer3.giveSalary())
    println("Salary of " + designer4.firstName + " " + designer4.lastName + " : " + designer4.giveSalary())

    println("Salary of " + manager1.firstName + " " + manager1.lastName + " : " + manager1.giveSalary())
    println("Salary of " + manager2.firstName + " " + manager2.lastName + " : " + manager2.giveSalary())
}