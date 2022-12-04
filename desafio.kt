// [Kotlin Playground](https://pl.kotl.in/ETQyCE7nR?theme=darcula)

class Users(val name: String)

class Activities() {
    val contents: MutableList<EducationalContent> = mutableListOf()

	fun newContent(topic: EducationalContent) {
    	contents.add(topic)                      
	}
}

data class EducationalContent(val name: String, val duration: Int = 60)

data class Courses(val name: String, var contents: List<EducationalContent>) {

    val subscribed = mutableListOf<Users>()
    
    val peopleSubscribed: List<Users> = subscribed
    
    fun enroll(user: Users) {
		subscribed.add(user)
    }
    
    fun getSubscribers(): List<Users> {
    	return peopleSubscribed
	}
}

fun main() {
    	val activity = Activities()
		activity.newContent(EducationalContent("Coleções em Kotlin", duration = 120))
        activity.newContent(EducationalContent("Orientação em Objetos", duration = 180))
        
		val course = Courses("Kotlin - DIO", activity.contents)
        
        val user = Users("William")
        val user1 = Users("Eiji")
        course.enroll(user)
        course.enroll(user1)
        
        println("Usuários registrados no curso de ${course.name}")
        course.getSubscribers().forEach {
        	i -> println(i.name)
    	}
}
