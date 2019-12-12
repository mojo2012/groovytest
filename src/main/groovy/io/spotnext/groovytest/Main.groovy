package io.spotnext.groovytest

class Main {
	static void main(String... args) {
		println("Starting")

		// automatic constructor for all privates fields, used via named variables
		final def user = new UserData(name: "mojo")
		// invokes the overridden setName() method
		user.name = "test"

		// nested instantiation, almost like json
		def user2 = new UserData([
			id   : 2,
			name : "test",
			group: new UserGroup([
				id  : 100,
				name: "group"
			])
		])

		user2.with {
			name = "test2"
		}

		// extension methods
		String nullObj = " a "
		if (nullObj?.trimToNull() != null) {
			println("NOT blank")
		}

		// auto implemented clonable
		final def userClone =  (UserData) user.clone()
		assert userClone.name == user.name

		// awesome map initialization
		def map = ["a": 1, "b": 2]
		// and also for collections
		def list = [1, 2, 3]
		list << 4 // add
		list += 5 // add
		def listEntry = list[6] // doesn't fail

		// operator overloading, also customizable
		def number1 = new BigDecimal(10)
		def number2 = new BigDecimal(10)
		number1 +  number2

		// java lambdas
		def lambda = { int a, int b ->  a + b }
		//		var lambda = (int a, int b) -> { a + b }

		// invoke method reference
		//		var valueOf = String::valueOf
		//		println(valueOf("a"))

		// json
		def json = [
			id: 2,
			content: [
				name: "mojo"
			]
		]

		def d1 = 1.mm
		def d2 = 1.cm
		def sum = (d1 + d2).cm // add different distances and convert

		println("Distance: $sum")

		//multiline strings
		final def output = """\
			Hello $user.name (id=$user.id),
			How are you?
			""".stripIndent()
		println(output)
	}
}
